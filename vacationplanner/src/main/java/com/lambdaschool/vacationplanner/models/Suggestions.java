package com.lambdaschool.vacationplanner.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SUGGESTIONS")
public class Suggestions
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long suggestionid;

    @Column(name = "suggest")
    private String suggest;

    @OneToMany(mappedBy = "suggestions", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("suggestions")
    private List<VacationSuggestion> vacationSuggestions = new ArrayList<>();

    public Suggestions()
    {
    }

    public Suggestions(String suggest)
    {
        this.suggest = suggest;
    }

    public long getSuggestionid()
    {
        return suggestionid;
    }

    public void setSuggestionid(long suggestionid)
    {
        this.suggestionid = suggestionid;
    }

    public String getSuggest()
    {
        return suggest;
    }

    public void setSuggest(String suggest)
    {
        this.suggest = suggest;
    }

    public List<VacationSuggestion> getVacationSuggestions()
    {
        return vacationSuggestions;
    }

    public void setVacationSuggestions(List<VacationSuggestion> vacationSuggestions)
    {
        this.vacationSuggestions = vacationSuggestions;
    }
}
