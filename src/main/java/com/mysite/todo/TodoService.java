package com.mysite.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> getTodoList() {
        return this.todoRepository.findAll();
    }

    public Optional<Todo> findTodoById(Integer id) {
        return this.todoRepository.findById(id);
    }

    public Todo createTodo(String content) {
        Todo todo = new Todo();
        todo.setContent(content);
        todo.setCompleted(false);
        this.todoRepository.save(todo);
        return todo;
    }

    @Transactional
    public Integer deleteTodo(Integer id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id = " + id));
        this.todoRepository.delete(todo);
        return todo.getId();
    }

    @Transactional
    public Todo updateTodo(Integer id, Todo prevTodo) {
        Todo todo = todoRepository.findById(prevTodo.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id = " + id));
        todo.setContent(prevTodo.getContent());
        todo.setCompleted(prevTodo.isCompleted());
        this.todoRepository.save(todo);
        return todo;
    }
}
