package com.mysite.todo.todolist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional(readOnly = true)
    public List<TodoResponseDto> getTodoList() {
        return this.todoRepository.findAll().stream()
                .map(TodoResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Integer create(TodoCreateRequestDto requestDto) {
        return this.todoRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Integer update(Integer id, TodoUpdateRequestDto requestDto) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id = " + id));
        todo.update(requestDto.getContent(), requestDto.isCompleted());
        return id;
    }

    @Transactional
    public Integer delete(Integer id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id = " + id));
        todoRepository.delete(todo);
        return todo.getId();
    }
    
}
