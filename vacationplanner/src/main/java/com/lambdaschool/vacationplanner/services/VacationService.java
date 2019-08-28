package com.lambdaschool.vacationplanner.services;

import com.lambdaschool.vacationplanner.models.Vacation;

public interface VacationService
{
    Vacation save(Vacation vacation);

    Vacation update(Vacation vacation, long id);

    void delete(long id);

    Vacation findById(long id);

    void insertIntoVacaSugg(long userid, long vacationid, long suggestionid);

    void insertIntoVacaParts(long userid, long vacationid);
}
