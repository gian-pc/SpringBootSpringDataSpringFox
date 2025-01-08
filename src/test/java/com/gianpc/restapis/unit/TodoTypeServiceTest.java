package com.gianpc.restapis.unit;

import com.gianpc.restapis.domains.TodoType;
import com.gianpc.restapis.repositories.TodoTypeRepository;
import com.gianpc.restapis.services.TodoTypeService;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTypeServiceTest {

    private TodoTypeRepository todoTypeRepository = Mockito.mock(TodoTypeRepository.class);

    private Validator validator = Mockito.mock(Validator.class);

    private TodoTypeService todoTypeService = new TodoTypeService(todoTypeRepository, validator);

    @Test
    public void whenReadTodoType_thenReturnTodoType() {

        TodoType personal = new TodoType();
        personal.setCode("PERSONAL");
        personal.setDateCreated(new Date());
        Optional<TodoType> personalOptional = Optional.ofNullable(personal);

        //give
        Mockito.when(todoTypeRepository.findById("PERSONAL")).thenReturn(personalOptional);

        //when
        TodoType result = todoTypeService.findByCode("PERSONAL");

        //then
        assertEquals(personal.getCode(), result.getCode());


    }
}
