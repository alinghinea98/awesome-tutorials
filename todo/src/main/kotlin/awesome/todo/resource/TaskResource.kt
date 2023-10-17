package awesome.todo.resource

import awesome.todo.domain.Task
import awesome.todo.domain.dto.TaskDto
import awesome.todo.domain.service.TaskService
import awesome.todo.resource.exception.NotFoundException
import org.springframework.web.bind.annotation.*

@RestController
class TaskResource (
    private val taskService: TaskService
        ) {

    @GetMapping("/tasks")
    fun getTasks(): List<TaskDto> {
        return taskService.findAll().map { TaskDto.getInstance(it) };
    }

    @PostMapping("/tasks")
    fun createTask(@RequestBody dto: TaskDto): String {
        return taskService.create(dto).id; // good practice to return id to the client
    }

    @PutMapping("/tasks/{id}")
    fun updateTask(@PathVariable id: String, dto: TaskDto) {
        val task = taskService.findById(dto.id) ?: throw NotFoundException()
        taskService.update(task, dto);
    }

    @PatchMapping("/tasks/{id}")
    fun patchTask(@PathVariable id: String, dto: TaskDto) {
        val task = taskService.findById(dto.id) ?: throw NotFoundException()
        taskService.patch(task, dto);
    }

    @DeleteMapping("/tasks/{id}")
    fun deleteTask(@PathVariable id: String) {
        taskService.delete(id);
    }
}