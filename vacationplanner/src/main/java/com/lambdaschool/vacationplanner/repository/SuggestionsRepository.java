package com.lambdaschool.vacationplanner.repository;

import com.lambdaschool.vacationplanner.models.Suggestions;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface SuggestionsRepository extends CrudRepository<Suggestions, Long>
{
    Suggestions findBySuggestionid(long id);

}
