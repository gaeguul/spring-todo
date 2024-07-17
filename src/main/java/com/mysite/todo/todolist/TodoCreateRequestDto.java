package com.mysite.todo.todolist;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoCreateRequestDto {
    private String content;

    @Builder
    public TodoCreateRequestDto(String content) {
        this.content = content;
    }

    /**
     * 생성하려는 Todo의 Dto를 전달받아서 Entity로 변환한다.
     *
     * @return 생성할 Todo의 Entity
     */
    public Todo toEntity() {
        return Todo.builder()
                .content(this.content)
                .completed(false)
                .build();
    }
}
