package com.gianpc.restapis.services;

import com.gianpc.restapis.domains.TodoType;
import com.gianpc.restapis.repositories.TodoTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TodoTypeService {

    private TodoTypeRepository todoTypeRepository;

    // Inyección por constructor
    @Autowired
    public TodoTypeService(TodoTypeRepository todoTypeRepository) {
        this.todoTypeRepository = todoTypeRepository;
    }

    public TodoType create(TodoType todoType){
        todoTypeCollection.put(todoType.getCode(), todoType);
        return todoType;
    }

    public TodoType findByCode(String code){
        return todoTypeCollection.get(code);
    }

    public TodoType update(TodoType todoType){
        todoType.setLastUpdated(new Date());
        todoTypeCollection.put(todoType.getCode(), todoType);
        return todoType;
    }

    public void deleteByCode(String code) throws Exception{
        if (todoTypeCollection.remove(code) == null){
            throw new Exception("TodoType no existe");
        }
    }
}
