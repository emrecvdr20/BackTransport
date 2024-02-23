package com.manolya.transport.controllers;

import com.manolya.transport.dto.TodoDTO;
import com.manolya.transport.models.Todo;
import com.manolya.transport.services.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(){
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }
    @PostMapping
    public ResponseEntity<Todo> createTodo(@Valid @RequestBody TodoDTO todoDTO){
        Todo createdTodo = todoService.createTodo(todoDTO);
        return ResponseEntity.ok(createdTodo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @Valid @RequestBody TodoDTO todoDTO){
        Todo updatedTodo = todoService.updateTodo(id,todoDTO);
        return ResponseEntity.ok(updatedTodo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo (@PathVariable Long id){
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id){
        Todo todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }
    @PatchMapping("/{id}/completed")
    public ResponseEntity<Todo> setCompleted(@PathVariable Long id, @RequestParam boolean completed){
        Todo todo = todoService.setCompleted(id,completed);
        return ResponseEntity.ok(todo);
    }

}
