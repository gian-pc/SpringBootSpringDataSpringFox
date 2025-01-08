package com.gianpc.restapis.unit;

import com.gianpc.restapis.domains.Todo;
import com.gianpc.restapis.repositories.TodoRepository;
import com.gianpc.restapis.services.TodoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TodoServiceTest {

    private TodoRepository todoRepository = Mockito.mock(TodoRepository.class);
    private TodoService todoService = new TodoService(todoRepository);

    @Test
    public void whenUpdate_thenReturnTodo() {
        Todo doLaundry = new Todo();
        doLaundry.setId(1L);
        doLaundry.setTitle("Do Laundry");
        doLaundry.setDone(true);
        doLaundry.setDateCreated(new Date());
        doLaundry.setDueDate(new Date());

        // given
        Mockito.when(todoRepository.save(doLaundry)).thenReturn(doLaundry);

        // when
        Todo result = todoService.update(doLaundry);

        // then
        assertNotNull(result.getDateDone());
    }
}
