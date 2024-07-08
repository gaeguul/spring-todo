package com.mysite.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @RequestMapping("/todo")
    public String todo(Model model) {
        List<Todo> todoList = this.todoService.getList();
        model.addAttribute("todoList", todoList);
        return "todo";
    }

    /**
     * localhost:8080/로 진입할 경우 todolist를 보여주는 화면으로 리다이렉트
     *
     * @return todo.html로 리다이렉트
     */
    @RequestMapping("/")
    public String root() {
        return "redirect:/todo";
    }
}

