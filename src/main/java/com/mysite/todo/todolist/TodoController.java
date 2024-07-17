package com.mysite.todo.todolist;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    @GetMapping("")
    public List<TodoResponseDto> getTodoList() {
        return todoService.getTodoList();
    }

    @PostMapping("/create")
    public Integer create(@RequestBody TodoCreateRequestDto requestDto) {
        return this.todoService.create(requestDto);
    }

    @PutMapping("/update/{id}")
    public Integer update(
            @PathVariable("id") Integer id,
            @RequestBody TodoUpdateRequestDto requestDto
    ) {
        return this.todoService.update(id, requestDto);
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable("id") Integer id) {
        return this.todoService.delete(id);
    }

}

