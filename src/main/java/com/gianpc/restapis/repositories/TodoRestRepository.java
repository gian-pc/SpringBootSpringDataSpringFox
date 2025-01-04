package com.gianpc.restapis.repositories;

import com.gianpc.restapis.domains.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TodoRestRepository extends CrudRepository<Todo, Long>, PagingAndSortingRepository<Todo, Long> {
}
