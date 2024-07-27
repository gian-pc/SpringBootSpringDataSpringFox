package com.gianpc.restapis.controllers;

import com.gianpc.restapis.domains.Todo;
import com.gianpc.restapis.domains.TodoType;
import com.gianpc.restapis.services.TodoService;
import com.gianpc.restapis.services.TodoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/create")
    public Todo create(){
        //..
    }

    @GetMapping("/read")
    public Todo read(){
        //..
    }

    @PutMapping("/update")
    public Todo update(){
        //..
    }

    @DeleteMapping("/delete")
    public void delete(){
        //..
    }
}
