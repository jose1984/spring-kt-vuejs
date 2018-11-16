package es.jadel.web.vuejs.entities

import org.springframework.data.jpa.domain.AbstractPersistable
import javax.persistence.Entity

@Entity
data class Todo(val title: String, val completed: Boolean) : AbstractPersistable<Long>()
