package com.gianpc.restapis.services;

import com.gianpc.restapis.domains.Todo;
import com.gianpc.restapis.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service // proveernos una instancia SINGLETON de esta clase
public class TodoService {

    // Field
    @Autowired
    private TodoRepository todoRepository;

    // Setter
    @Autowired
    public void setTodoRepository(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // Constructor
    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo create(Todo todo) {
        todo.setId(idCount);
        todoCollection.put(idCount, todo);
        idCount++;
        return todo;
    }

    public Todo findById(Long id)   {
        return todoCollection.get(id);
    }

    public Todo update(Todo todo) {
        todo.setLastUpdated(new Date());
        if (todo.isDone()){
            todo.setDateDone(new Date());
        }
        todoCollection.put(todo.getId(), todo);
        return todo;
    }

    public void delete (Long id) throws Exception{
        if(todoCollection.remove(id) == null){
            throw new Exception("No existe ese Id");
        }
    }
}
