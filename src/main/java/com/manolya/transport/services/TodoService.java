package com.manolya.transport.services;

import com.manolya.transport.dto.TodoDTO;
import com.manolya.transport.models.Todo;
import com.manolya.transport.repositories.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Todo createTodo(TodoDTO todoDTO){
        Todo todo = todoDTO.toEntity();
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, TodoDTO todoDTO){
        Todo todo = getTodoById(id);
        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
        todo.setPriority(todoDTO.getPriority());
        return todoRepository.save(todo);
    }

    public Todo getTodoById(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isEmpty()){
            throw new RuntimeException("Todo Bulunamadı");
        }
        return todo.get();
    }

    public void deleteTodo(Long id){
        Todo todo = getTodoById(id);
        todoRepository.delete(todo);
    }

    public Todo setCompleted(Long id, boolean completed){
        Todo todo = getTodoById(id);
        todo.setCompleted(completed);
        return todoRepository.save(todo);
    }

}
