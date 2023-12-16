package com.webendterm.service

import com.google.inject.Inject
import com.webendterm.dao.TodoRepository
import com.webendterm.dto.TodoDTO
import com.webendterm.mapper.TodoMapper

class TodoService @Inject constructor(private val todoRepository: TodoRepository, private val todoMapper: TodoMapper) {

    fun findAll() = todoRepository.findAll().map(todoMapper::map)

    fun findById(id: String?) = todoRepository.findbyId(id).let(todoMapper::map)

    fun create(todo: TodoDTO?) = todo.let(todoMapper::map).let(todoRepository::create).let(todoMapper::map)

    fun update(id: String?, todo: TodoDTO?) = todoRepository.update(id, todo)

    fun delete(id: String?) = id.let(todoRepository::delete)
}