package com.gianpc.restapis.repositories;

import java.util.Date;
import java.util.List;

import com.gianpc.restapis.domains.Todo;
import org.springframework.data.jpa.repository.Query;
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

    // ---- QUERY METHODS ---- son para algo más elaborado que los finders methods

    // Buscar por título y done
    @Query("SELECT t FROM Todo t WHERE t.done = true") // Esto es un query de objetos no de tablas
    List<Todo> readAllDone();

    // Buscar por fecha de creación mayor o igual a la fecha dada y fecha de vencimiento igual a la fecha dada
    @Query("SELECT t FROM Todo t WHERE t.dateCreated >= ?1 AND t.dueDate = ?2")
    List<Todo> fetchTodos(Date dateCreated, Date dueDate);


    // ------ Ahora ya puedo integrar mis Named Queries  en Spring Data --------
    List<Todo> fetchAllDone();

    List<Todo> fetchAllByName(String title);



}


