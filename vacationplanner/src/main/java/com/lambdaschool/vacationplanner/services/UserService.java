package com.lambdaschool.vacationplanner.services;

import com.lambdaschool.vacationplanner.models.User;
import com.lambdaschool.vacationplanner.models.Vacation;
import com.lambdaschool.vacationplanner.models.VacationParticipants;

import java.util.List;

public interface UserService
{

    List<User> findAll();

    User findUserById(long id);

    void delete(long id);

    User save(User user);

    User update(User user, long id);

    // find all vacations by user ID
    List<VacationParticipants> findUserVacations(long id);
}