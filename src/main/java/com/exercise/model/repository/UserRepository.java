package com.exercise.model.repository;

import com.exercise.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUuid(String UUId);

}
