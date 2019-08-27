package com.lambdaschool.vacationplanner.services;

import com.lambdaschool.vacationplanner.models.Suggestions;
import com.lambdaschool.vacationplanner.repository.SuggestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "suggestionService")
public class SuggestionServiceImpl implements SuggestionService
{
    @Autowired
    SuggestionsRepository suggestionsRepos;

    @Transactional
    @Override
    public Suggestions save(Suggestions suggestions)
    {
        Suggestions newSuggestion = new Suggestions();
        newSuggestion.setSuggest(suggestions.getSuggest());

        return suggestionsRepos.save(newSuggestion);
    }
}
