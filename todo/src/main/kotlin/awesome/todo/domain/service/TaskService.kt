package awesome.todo.domain.service

import awesome.todo.domain.Task
import awesome.todo.domain.TaskStatus
import awesome.todo.domain.dto.TaskDto
import awesome.todo.domain.repo.TaskRepo
import org.springframework.stereotype.Service
import java.util.*

@Service
class TaskService (
    private val taskRepo: TaskRepo
        ) {

    fun findAll(): List<Task> = taskRepo.findAll();

    fun findById(id: String) = taskRepo.findOneById(id);

    fun create(dto: TaskDto): Task {
        // validate dto
        return taskRepo.save(Task(
            name = dto.name,
            details = dto.details,
            status = dto.status,
        ));
    }

    fun update(task: Task, dto: TaskDto) {
        // validate dto
        task.name = dto.name;
        task.details = dto.details;
        task.status = dto.status;
        save(task);
    }

    fun save(task: Task): Task {
        task.updatedDate = Date();
        return taskRepo.save(task);
    }

    fun patch(task: Task, dto: TaskDto) {
        dto.status?.let { status ->
            task.status = status
            save(task)
        }
    }

    fun delete(id: String) {
        taskRepo.deleteById(id);
    }
}