package com.mysite.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoListApplicationTests {

	@Autowired
	private TodoRepository todoRepository;

	@Test
	void testJpa() {
		Todo todo1 = new Todo();
		todo1.setContent("todo1");
		todo1.setCompleted(true); //Boolean.TRUE?
		this.todoRepository.save(todo1);

		Todo todo2 = new Todo();
		todo2.setContent("todo2");
		todo2.setCompleted(true); //Boolean.TRUE?
		this.todoRepository.save(todo2);
	}

}
