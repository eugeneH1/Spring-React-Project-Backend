package com.eugene.rest.webservices.restfulwebservices;

import com.eugene.rest.webservices.restfulwebservices.todo.Todo;
import com.eugene.rest.webservices.restfulwebservices.todo.TodoHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {

    @Autowired
    private TodoHardcodedService todoService;

    @GetMapping("/users/{userName}/todos")
    public List<Todo> getAllTodos(@PathVariable String userName) {
        return todoService.findAll();
    }

    @GetMapping("/users/{userName}/todos/{id}")
    public Todo getTodo(@PathVariable String userName, @PathVariable long id) {

        return todoService.findById(id);
    }

    @PostMapping("/users/{userName}/todos")
    public ResponseEntity<Void> createTodo(@PathVariable String userName,
                                           @RequestBody Todo todo) {
        Todo createdTodo = todoService.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @PutMapping("/users/{userName}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String userName,
                                           @PathVariable long id,
                                           @RequestBody Todo todo) {
        Todo updatedTodo = todoService.save(todo);

        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @DeleteMapping("/users/{userName}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String userName, @PathVariable long id) {
        Todo todo = todoService.deleteById(id);
        if(todo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
