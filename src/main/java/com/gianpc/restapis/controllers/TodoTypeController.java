package com.gianpc.restapis.controllers;

import com.gianpc.restapis.domains.Todo;
import com.gianpc.restapis.domains.TodoType;
import com.gianpc.restapis.services.TodoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Combina @Controller y @ResponseBody
@RequestMapping("/api/todoType") // Mapea todas las peticiones a /api/todoType a este controlador
public class TodoTypeController{

    private TodoTypeService todoTypeService;

    // Inyectar el servicio en el controlador
    @Autowired
    public TodoTypeController(TodoTypeService todoTypeService) {
        this.todoTypeService = todoTypeService;
    }

    @GetMapping("/hello")
    public String helllo(){
        return "Hello World from TodoTypeController";
    }

    /**
     * expose GetMapping en el /read endpoint
     * @return TodoType
     */
    @GetMapping(value = "/read", produces = {"application/json", "application/xml"})
    public TodoType readTodoType(){
        TodoType todoType = new TodoType();
        todoType.setCode("PERSONAL");
        todoType.setDescription("Todo para personal work");
        return todoType;
    }

    @PostMapping( value = "/create", produces = {"application/json", "application/xml"})
    public TodoType createTodoType(){
        TodoType todoType = new TodoType();
        todoType.setCode("PROFESSIONAL");
        todoType.setDescription("Todo para personal work");
        return todoType;
    }

    @PostMapping(consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public TodoType create(@RequestBody TodoType todoType){
        return todoTypeService.create(todoType);
    }

    @GetMapping(value = "/{code}", produces = {"application/xml"}) // Este solo produce xml, por lo tanto debemos agregar una anotación @XmlRootElement al TodoType
    public TodoType read(@PathVariable("code") String code){
        TodoType todoType = todoTypeService.findByCode(code);
        return todoType;
    }

    @PutMapping
    public TodoType updateTodo(@RequestBody TodoType todoType){
        return todoTypeService.update(todoType);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity delete(@PathVariable("code") String code){
        try {
            todoTypeService.deleteByCode(code);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
