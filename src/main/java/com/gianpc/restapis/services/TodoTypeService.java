package com.gianpc.restapis.services;

import com.gianpc.restapis.domains.Todo;
import com.gianpc.restapis.domains.TodoType;
import com.gianpc.restapis.repositories.TodoTypeRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TodoTypeService {

    private TodoTypeRepository todoTypeRepository;

    private Validator validator;

    // Inyección por constructor
    @Autowired
    public TodoTypeService(TodoTypeRepository todoTypeRepository, Validator validator) {
        this.todoTypeRepository = todoTypeRepository;
        this.validator = validator;
    }

    public TodoType create(TodoType todoType) {
        Set<ConstraintViolation<TodoType>> violations = validator.validate(todoType);// vamos a validar el objeto que quiero guardar
        if (violations.isEmpty()) { // no hay errores de validación
            todoTypeRepository.save(todoType);
        }
        return todoType;
    }

    public TodoType findByCode(String code) {
        Optional<TodoType> todoTypeResult = todoTypeRepository.findById(code);
        if (todoTypeResult.isPresent()) {
            return todoTypeResult.get();
        } else {
            return null;
        }
    }

    public TodoType update(TodoType todoType) {
        todoType.setLastUpdated(new Date());
        todoType = todoTypeRepository.save(todoType);
        return todoType;
    }

    public void deleteByCode(String code) throws Exception {
        if (!todoTypeRepository.existsById(code)) {
            throw new Exception("TodoType no existe");
        }
        todoTypeRepository.deleteById(code);
    }

    // paginación
    public List<TodoType> findAll(String sort, Sort.Direction order, int pageNumber, int numOfRecords){
        Sort idDesc = Sort.by(order, sort);
        Pageable pageRequest = PageRequest.of(pageNumber, numOfRecords, idDesc);
        Page<TodoType> todoTypePages = todoTypeRepository.findAll(pageRequest);
        List<TodoType> todoTypes = todoTypePages.getContent();
        return todoTypes;

    }

}
