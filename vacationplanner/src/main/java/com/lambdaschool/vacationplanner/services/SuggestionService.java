package com.lambdaschool.vacationplanner.services;

import com.lambdaschool.vacationplanner.models.Suggestions;

public interface SuggestionService
{
    Suggestions save(Suggestions suggestions);

    Suggestions update(Suggestions suggestions, long id);

    void delete(long id);
}
