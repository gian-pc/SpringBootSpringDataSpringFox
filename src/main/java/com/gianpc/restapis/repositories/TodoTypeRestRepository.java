package com.gianpc.restapis.repositories;

import com.gianpc.restapis.domains.TodoType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TodoTypeRestRepository extends CrudRepository<TodoType, String>, PagingAndSortingRepository<TodoType, String> {
}
