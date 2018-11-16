<template>
    <li class="todo-item">
        <input type="checkbox" :id="todo.id" v-model="todo.completed" @change="todoCompleted">
        <label :for="todo.id">{{ todo.title }}</label>
        <button @click="todoRemove">Remove</button>
    </li>
</template>

<script>
export default {
  name: 'todo-item',
  props: ['todo'],
  methods: {
      todoCompleted: function () {
        this.$emit('completed')
      },
      todoRemove: function () {
        this.$emit('remove')
      }
  }
}
</script>

<style scoped>

label {
    margin-right: 1em;
}

</style>