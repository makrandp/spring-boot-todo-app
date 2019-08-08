package com.example.todoapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.todoapp.model.Todo;

public interface ITodoService 
{
	public Todo createTodo(Todo todo);
	public List<Todo> findAll();
	public Todo findTodoById(Long todoId);
	public Todo updateTodo(Long todoId, Todo todo);
	public ResponseEntity<?> deleteTodo(Long todoId);
	public List<Todo> findByTitle(String title);
	public List<Todo> fetchTodos(String title);
}
