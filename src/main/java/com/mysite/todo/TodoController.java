package com.mysite.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    @GetMapping("")
    public List<Todo> todoListGet() {
        return this.todoService.getTodoList();
    }

    @GetMapping("/{id}")
    public Optional<Todo> todoGet(Integer id) {
        return this.todoService.findTodoById(id);
    }

    @PostMapping("/create")
    public Todo todoCreate(@RequestParam("content") String content) {
        return this.todoService.createTodo(content);
    }

    @DeleteMapping("/delete/{id}")
    public Integer todoDelete(@PathVariable("id") Integer id) {
        return this.todoService.deleteTodo(id);
    }

    @PutMapping("/update/{id}")
    public Todo todoUpdate(@RequestBody Todo todo, @PathVariable("id") Integer id) {
        return this.todoService.updateTodo(id, todo);
    }
}

