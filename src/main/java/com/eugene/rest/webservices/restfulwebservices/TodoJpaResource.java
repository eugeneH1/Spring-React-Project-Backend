package com.eugene.rest.webservices.restfulwebservices;

import com.eugene.rest.webservices.restfulwebservices.todo.Todo;
import com.eugene.rest.webservices.restfulwebservices.todo.TodoHardcodedService;
import com.eugene.rest.webservices.restfulwebservices.todo.TodoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoJpaResource {

    @Autowired
    private TodoHardcodedService todoService;

    @Autowired
    private TodoJpaRepository todoJpaRepository;

    @GetMapping("/jpa/users/{userName}/todos")
    public List<Todo> getAllTodos(@PathVariable String userName) {
        return todoJpaRepository.findByUserName(userName);
//
    }

    @GetMapping("/jpa/users/{userName}/todos/{id}")
    public Todo getTodo(@PathVariable String userName, @PathVariable long id) {
        return todoJpaRepository.findById(id).get();
//        return todoService.findById(id);
    }

    @PostMapping("/jpa/users/{userName}/todos")
    public ResponseEntity<Void> createTodo(@PathVariable String userName,
                                           @RequestBody Todo todo) {
        todo.setUserName(userName);
        Todo createdTodo = todoJpaRepository.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @PutMapping("/jpa/users/{userName}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String userName,
                                           @PathVariable long id,
                                           @RequestBody Todo todo) {
        todo.setUserName(userName);
        Todo updatedTodo = todoJpaRepository.save(todo);

        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @DeleteMapping("/jpa/users/{userName}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String userName, @PathVariable long id) {
        todoJpaRepository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

}
