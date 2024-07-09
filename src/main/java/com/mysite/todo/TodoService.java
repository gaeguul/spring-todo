package com.mysite.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void deleteTodo(Integer id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id = " + id));
        this.todoRepository.delete(todo);
    }

    @Transactional
    public void updateTodo(Integer id, String content) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id = " + id));
        todo.setContent(content);
        this.todoRepository.save(todo);

    }
}
