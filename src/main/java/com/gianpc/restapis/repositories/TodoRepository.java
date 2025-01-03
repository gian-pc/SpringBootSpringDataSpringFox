package com.gianpc.restapis.repositories;

import java.util.Date;
import com.gianpc.restapis.domains.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>, PagingAndSortingRepository<Todo, Long> {
    // Qué pasaría si queremos introducir algunos métodos adicionales basado en los atributos de la entidad Todo?

    // Finders methods
    // Buscar por título
    Todo findByTitle(String title);

    // Buscar por fecha de creación mayor o igual a la fecha dada
    Todo findByDateCreatedGreaterThanEqual(Date dateCreated);

    // Buscar por fecha de creación menor o igual a la fecha dada
    Todo findByDoneAndDateDone(boolean done, Date dateDone);

    // Contar por fecha de vencimiento menor a la fecha dada
    long countByDueDateLessThan(Date dueDate);

    // Contar por fecha de creación mayor a la fecha dada
    long countByDateCreatedGreaterThanAndDueDate(Date dateCreated, Date dueDate);

    // Eliminar por id
    void deleteById(Long id);

    // Eliminar por título y done
    long deleteByTitleAndDone(String title, boolean done);

}


