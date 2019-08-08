package com.example.todoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.todoapp.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
	List<Todo> findByTitle(String title);
	
	@Query("SELECT a FROM Todo a WHERE a.title=:title")
    List<Todo> fetchTodos(@Param("title") String title);
}
