package com.sprint.sprintr.repos;

import com.sprint.sprintr.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends CrudRepository<Users, Long> {
}
