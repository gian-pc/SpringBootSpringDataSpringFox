package com.gianpc.restapis.controllers;

import com.gianpc.restapis.domains.TodoType;
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

    /**
     * expose GetMapping en el /read endpoint
     * @return TodoType
     */
    @GetMapping("/read")
    public TodoType readTodoType(){
        TodoType todoType = new TodoType();
        todoType.setCode("1");
        todoType.setDescription("Todo para personal stuff");
        return todoType;
    }
}
