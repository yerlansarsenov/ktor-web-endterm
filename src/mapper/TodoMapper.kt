package com.webendterm.mapper

import com.webendterm.dto.TodoDTO
import com.webendterm.model.Todo

class TodoMapper {

    fun map(todo: Todo?): TodoDTO {
        return TodoDTO(
            id = todo?.id,
            title = todo?.title
        )
    }

    fun map(
        todoDTO: TodoDTO?
    ): Todo? {
        return todoDTO?.title?.let {
            Todo(
                id = todoDTO.id,
                title = it
            )
        }
    }
}
