package com.gianpc.restapis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Combina @Controller y @ResponseBody
@RequestMapping("/api/todoType") // Mapea todas las peticiones a /api/todoType a este controlador
public class TodoTypeController{

    @GetMapping("/hello")
    public String helllo(){
        return "Hello World from TodoTypeController";
    }
}
