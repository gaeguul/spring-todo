package com.mysite.todo.todolist;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoUpdateRequestDto {
    private String content;
    private boolean completed;

    @Builder
    public TodoUpdateRequestDto(String content, boolean completed) {
        this.content = content;
        this.completed = completed;
    }

    public Todo toEntity() {
        return Todo.builder()
                .content(this.content)
                .completed(this.completed)
                .build();
    }
}
