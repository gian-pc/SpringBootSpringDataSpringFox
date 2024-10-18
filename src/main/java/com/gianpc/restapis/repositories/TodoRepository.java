package com.gianpc.restapis.repositories;

import com.gianpc.restapis.domains.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    // metodo que me devuelve todas las tareas(todos) que ya terminaron
    @Query("SELECT t FROM Todo t WHERE t.done = true") // Quiero buscar todos los todos que ya terminaron
    List<Todo> readAllDone();

    List<Todo> findAllDone();
    List<Todo> findAllTitle(String title); // finders

    long countAllByDone(boolean done);
    long deleteAllByDone(boolean done);
}
