<template>
  <div class="todo">
    <h1>{{ message }}</h1>

    <input type="text" v-model="newTodo">
    <button v-on:click="addTodo" :disabled="!newTodo">Add</button>

    <p>
        <todo-item v-for="todo in todos"
            v-bind:todo="todo"
            v-bind:key="todo.id"
            v-on:completed="onCompleted(todo)"
            v-on:remove="onRemove(todo)"></todo-item>
    </p>
  </div>
</template>

<script>
import TodoItem from './TodoItem.vue'

export default {
  components: {
    TodoItem
  },
  name: 'todo',
  data () {
    return {
      message: 'Hello Vue!',
      newTodo: '',
      todos: []
    }
  },
  methods: {
      onCompleted: function (todo) {
          const patchTodo = {
            completed: todo.completed
          }

          fetch(`todos/${todo.id}`, {
            method: 'PATCH',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(patchTodo)
          }).then(res => res.json())
            .then(response => console.log('Success:', JSON.stringify(response)))
            .catch(error => console.error('Error:', error))
      },
      onRemove: function (todo) {
           fetch(`todos/${todo.id}`, {
             method: 'DELETE',
             headers: {
               'Content-Type': 'application/json'
             }
           }).then(response => this.fetchTodos())
             .catch(error => console.error('Error:', error))
        },
      addTodo: function () {
        const postTodo = {
            title: this.newTodo
        }

        fetch(`todos`, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(postTodo)
          }).then(res => res.json())
            .then(response => {
                this.newTodo = ''
                this.fetchTodos()
            })
            .catch(error => console.error('Error:', error))
      },
      fetchTodos: function () {
        fetch('todos')
            .then(response => response.json())
            .then(todos => this.todos = todos._embedded.todos)
      }
  },
  created() {
      this.fetchTodos()
  }
}
</script>