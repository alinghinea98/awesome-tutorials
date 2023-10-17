package awesome.todo.domain.repo

import awesome.todo.domain.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TaskRepo: JpaRepository<Task, String> {

    @Query("from Task where id =:id")
    fun findOneById(id: String): Task?
}