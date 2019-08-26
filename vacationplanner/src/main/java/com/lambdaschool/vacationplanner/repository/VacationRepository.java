package com.lambdaschool.vacationplanner.repository;

import com.lambdaschool.vacationplanner.models.Vacation;
import org.springframework.data.repository.CrudRepository;

public interface VacationRepository extends CrudRepository<Vacation, Long>
{
}
