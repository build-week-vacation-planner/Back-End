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

    @ManyToMany(mappedBy = "vacationsuggestions")
    @JsonIgnoreProperties("vacationsuggestions")
    private List<Vacation> vacationsuggestion = new ArrayList<>();

    @ManyToMany(mappedBy = "usersuggestions")
    @JsonIgnoreProperties("usersuggestions")
    private List<User> usersuggestions = new ArrayList<>();

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

    public List<Vacation> getVacationsuggestion()
    {
        return vacationsuggestion;
    }

    public void setVacationsuggestion(List<Vacation> vacationsuggestion)
    {
        this.vacationsuggestion = vacationsuggestion;
    }

    public List<User> getUsersuggestions()
    {
        return usersuggestions;
    }

    public void setUsersuggestions(List<User> usersuggestions)
    {
        this.usersuggestions = usersuggestions;
    }
}
