package com.mysite.todo.todolist;

import lombok.Getter;

@Getter
public class TodoResponseDto {

    private Integer id;
    private String content;
    private boolean completed;

    /**
     * Todo Entity를 Dto로 변환한다
     *
     * @param entity ResponseDto로 변환하려는 Todo Entity
     */
    public TodoResponseDto(Todo entity) {
        this.id = entity.getId();
        this.content = entity.getContent();
        this.completed = entity.isCompleted();
    }
}
