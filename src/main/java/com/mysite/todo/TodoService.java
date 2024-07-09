package com.mysite.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> getTodos() {
        return this.todoRepository.findAll();
    }

    public void createTodo(String content) {
        Todo todo = new Todo();
        todo.setContent(content);
        todo.setCompleted(false);
        this.todoRepository.save(todo);
    }
}
