package es.jadel.web.vuejs.repos

import es.jadel.web.vuejs.entities.Todo
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "todos", path = "todos")
interface TodosRepository : CrudRepository<Todo, Long>
