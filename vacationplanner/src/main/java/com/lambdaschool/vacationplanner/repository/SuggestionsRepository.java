package com.lambdaschool.vacationplanner.repository;

import com.lambdaschool.vacationplanner.models.Suggestions;
import org.springframework.data.repository.CrudRepository;

public interface SuggestionsRepository extends CrudRepository<Suggestions, Long>
{
}
