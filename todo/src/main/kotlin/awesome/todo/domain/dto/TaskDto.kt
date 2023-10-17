package awesome.todo.domain.dto

import awesome.todo.domain.Task
import awesome.todo.domain.TaskStatus
import java.util.*

class TaskDto (
    val id: String = "",
    val name: String = "",
    val details: String = "",
    val status: TaskStatus = TaskStatus.TO_DO,
    val creationDate: Date = Date()
) {
    companion object {
        fun getInstance(task: Task) = TaskDto(
            id = task.id,
            name = task.name,
            details = task.details,
            status = task.status ?: TaskStatus.TO_DO,
            creationDate = task.creationDate
        )
    }
}