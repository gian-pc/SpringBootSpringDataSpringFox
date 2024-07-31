package com.gianpc.restapis.services;

import com.gianpc.restapis.domains.Todo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service // proveernos una instancia SINGLETON de esta clase
public class TodoService {

    // Creamos un map para guardar los todos
    private static Map<Long, Todo> todoCollection = new HashMap<>();

    private static long idCount = 1L;

    public Todo create(Todo todo) {
        todo.setId(idCount);
        todoCollection.put(idCount, todo);
        idCount++;
        return todo;
    }

    public Todo findById(Long id) {
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
