package com.mysite.todo;

import com.mysite.todo.todolist.TodoCreateRequestDto;
import com.mysite.todo.todolist.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoApplicationTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void testCreateTodo() {
        TodoCreateRequestDto requestDto = new TodoCreateRequestDto(
                "hello"
        );
        System.out.println(requestDto.toEntity().isCompleted());
    }

    @Test
    void testJpa() {
//        Todo todo1 = new Todo();
//        todo1.setContent("todo1");
//        todo1.setCompleted(true); //Boolean.TRUE?
//        this.todoRepository.save(todo1);
//
//        Todo todo2 = new Todo();
//        todo2.setContent("todo2");
//        todo2.setCompleted(true); //Boolean.TRUE?
//        this.todoRepository.save(todo2);
    }

}
