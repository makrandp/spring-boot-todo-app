package com.example.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.todoapp.exception.ResourceNotFoundException;
import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;

@Service
public class TodoService implements ITodoService {

	@Autowired
	TodoRepository todoRepository;
	
	@Override
	public Todo createTodo(Todo todo) 
	{
		return todoRepository.save(todo);
	}

	@Override
	public List<Todo> findAll() 
	{
		return todoRepository.findAll();
	}

	@Override
	public Todo findTodoById(Long todoId) 
	{
		return todoRepository.findById(todoId)
				.orElseThrow(() -> new ResourceNotFoundException("Todo", "id", todoId));
	}
	
	@Override
	public Todo updateTodo(Long todoId, Todo newTodo) 
	{
		Todo todo = todoRepository.findById(todoId)
				.orElseThrow(() -> new ResourceNotFoundException("Todo", "id", todoId));
		
		todo.setTitle(newTodo.getTitle());
		todo.setDescription(newTodo.getDescription());
		
		return todoRepository.save(todo);
	}

	@Override
	public ResponseEntity<?> deleteTodo(Long todoId) 
	{
		Todo todo = todoRepository.findById(todoId)
				.orElseThrow(() -> new ResourceNotFoundException("Todo", "id", todoId));
		
		todoRepository.delete(todo);
		
		return ResponseEntity.ok("Todo Deleted Successfully");
	}

	@Override
	public List<Todo> findByTitle(String title) {
		return todoRepository.findByTitle(title);
	}

	@Override
	public List<Todo> fetchTodos(String title) {
		return todoRepository.fetchTodos(title);
	}
}
