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

        newSuggestion = suggestionsRepos.save(newSuggestion);
        return newSuggestion;
    }

    @Transactional
    @Override
    public Suggestions update(Suggestions suggestions, long id)
    {
        Suggestions currentSuggestion = suggestionsRepos.findBySuggestionid(id);

        if (currentSuggestion != null)
        {
            if (id == currentSuggestion.getSuggestionid())
            {
                if (suggestions.getSuggest() != null)
                {
                    currentSuggestion.setSuggest(suggestions.getSuggest());
                }
            }
        }
        return suggestionsRepos.save(currentSuggestion);
    }

    @Override
    public void delete(long id)
    {
        suggestionsRepos.deleteById(id);
    }
}
