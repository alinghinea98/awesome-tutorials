package awesome.todo.domain

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class BaseEntity (
    @CreationTimestamp
    var creationDate: Date = Date(),
    @UpdateTimestamp
    var updatedDate: Date = Date()
)