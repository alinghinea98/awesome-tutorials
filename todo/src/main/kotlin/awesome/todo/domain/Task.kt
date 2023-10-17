package awesome.todo.domain

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Task(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String = "",

    @Column(nullable = false)
    var name: String = "",

    @Column(nullable = false)
    var details: String = "",
    var status: TaskStatus? = TaskStatus.TO_DO
): BaseEntity()

enum class TaskStatus {
    TO_DO,
    DONE,
    IN_PROGRESS
}