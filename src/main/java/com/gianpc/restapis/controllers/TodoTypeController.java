package com.gianpc.restapis.controllers;

import com.gianpc.restapis.domains.TodoType;
import com.gianpc.restapis.services.TodoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public TodoType create(@RequestBody TodoType todoType){
        return todoTypeService.create(todoType);
    }

    @GetMapping(value = "/{code}", produces = {"application/xml"}) // Este solo produce xml, por lo tanto debemos agregar una anotación @XmlRootElement al TodoType
    public ResponseEntity<TodoType> read(@PathVariable("code") String code){
        TodoType todoType = todoTypeService.findByCode(code);
        if(null != todoType){
            return new ResponseEntity<>(todoType, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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

    // este metodo obtiene una lista paginada y ordenada de objetos TodoType
    @GetMapping()
    public List<TodoType> findAll(@RequestParam String sort, @RequestParam String order, @RequestParam int pageNumber, @RequestParam int numOfRecords){
        return todoTypeService.findAll(sort, Sort.Direction.fromString(order), pageNumber, numOfRecords);
    }

}
