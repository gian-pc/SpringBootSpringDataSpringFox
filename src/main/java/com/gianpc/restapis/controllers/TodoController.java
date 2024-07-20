package com.gianpc.restapis.controllers;

import com.gianpc.restapis.domains.Todo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

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
