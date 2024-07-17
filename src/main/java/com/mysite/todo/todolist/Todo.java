package com.mysite.todo.todolist;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String content;

    @Column(nullable = false)
    private boolean completed = false;

    @Builder
    public Todo(String content, boolean completed) {
        this.content = content;
        this.completed = completed;
    }

    public void update(String content, boolean completed) {
        this.content = content;
        this.completed = completed;
    }

}
