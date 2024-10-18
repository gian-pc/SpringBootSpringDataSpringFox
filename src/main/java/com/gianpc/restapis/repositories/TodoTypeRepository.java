package com.gianpc.restapis.repositories;

import com.gianpc.restapis.domains.TodoType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoTypeRepository extends CrudRepository<TodoType, String>, PagingAndSortingRepository<TodoType, String> {

}
