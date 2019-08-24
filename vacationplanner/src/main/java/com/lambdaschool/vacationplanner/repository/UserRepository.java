package com.lambdaschool.vacationplanner.repository;

import com.lambdaschool.vacationplanner.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
