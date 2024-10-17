package com.gianpc.restapis.controllers;

import com.gianpc.restapis.domains.Todo;
import com.gianpc.restapis.services.TodoService;
import com.gianpc.restapis.services.TodoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private TodoService todoService;
    private TodoTypeService todoTypeService;

    @Autowired  // Inyectar el servicio en el controlador
    public TodoController(TodoService todoService, TodoTypeService todoTypeService) {
        this.todoService = todoService;
        this.todoTypeService = todoTypeService;
    }

    // Spring MVC implementa todas estas anotaciones para hacer el CRUD de un Tod0
    @PostMapping
    public Todo create(@RequestBody Todo todo){ // lo que viene en el body de la peticion se mapea a un objeto Todo
        return todoService.create(todo);
    }

    @GetMapping("/{id}")
    public Todo read(@PathVariable("id") Long id){
        return todoService.findById(id);
    }

    @PutMapping
    public Todo update(@RequestBody Todo todo){
        return todoService.update(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try {
            todoService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
