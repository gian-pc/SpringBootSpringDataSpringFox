package com.gianpc.restapis.services;

import com.gianpc.restapis.domains.Todo;
import com.gianpc.restapis.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service // proveernos una instancia SINGLETON de esta clase
public class TodoService {

    private TodoRepository todoRepository;

    // Constructor
    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo findById(Long id)   {

       Optional<Todo> todoResult = todoRepository.findById(id);
       if(todoResult.isPresent()){
           return todoResult.get();
       }else {
           return null;
       }
    }

    public Todo update(Todo todo) {
        todo.setLastUpdated(new Date());
        if (todo.isDone()){
            todo.setDateDone(new Date());
        }
        todo = todoRepository.save(todo);
        return todo;
    }

    public void delete (Long id) throws Exception{
        if(!todoRepository.existsById(id)){
            throw new Exception("No existe ese Id");
        }
        todoRepository.deleteById(id);
    }
}
