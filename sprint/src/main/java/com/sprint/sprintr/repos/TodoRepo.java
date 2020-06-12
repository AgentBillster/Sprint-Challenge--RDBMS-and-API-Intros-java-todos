package com.sprint.sprintr.repos;

import com.sprint.sprintr.models.Todos;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<Todos, Long> {
}
