package com.example.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapp.model.Todo;
import com.example.todoapp.service.ITodoService;

@RestController
public class TodoController {
	
	@Autowired
	ITodoService todoService;
	
	@GetMapping("/todo")
	public List<Todo> getAllTodos() 
	{
		return todoService.findAll();
	}
	
	@PostMapping("/todo")
	public Todo createTodo(@RequestBody Todo todo) 
	{
		return todoService.createTodo(todo);
	}
	
	@GetMapping("todo/{id}")
	public Todo findTodoById(@PathVariable(value = "id") Long todoId)
	{
		return todoService.findTodoById(todoId);
	}
	
	@GetMapping("todo/get/{title}")
	public List<Todo> findByTitle(@PathVariable(value = "title") String title)
	{
		return todoService.findByTitle(title);
	}
	
	@GetMapping("todo/fetch/{title}")
	public List<Todo> fetchTodosByTitle(@PathVariable(value = "title") String title)
	{
		return todoService.fetchTodos(title);
	}
	
	@PutMapping("todo/{id}")
	public Todo updateTodo(@PathVariable(value = "id") Long todoId,
			@RequestBody Todo todo){
		return todoService.updateTodo(todoId, todo);
	}
	
	@DeleteMapping("todo/{id}")
	public ResponseEntity<?> deleteTodo(@PathVariable(value = "id") Long todoId)
	{
		return todoService.deleteTodo(todoId);
	}
	
}