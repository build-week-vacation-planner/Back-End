package com.lambdaschool.vacationplanner.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vacationsuggestion")
public class VacationSuggestion implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = {"vacationSuggestions", "vacationParticipants"})
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "vacationid")
    @JsonIgnoreProperties(value = {"vacationSuggestions", "vacationParticipants"})
    private Vacation vacation;

    @Id
    @ManyToOne
    @JoinColumn(name = "suggestionid")
    @JsonIgnoreProperties(value = {"vacationSuggestions", "vacationParticipants"})
    private Suggestions suggestions;

    public VacationSuggestion()
    {
    }

    public VacationSuggestion(User user, Vacation vacation, Suggestions suggestions)
    {
        this.user = user;
        this.vacation = vacation;
        this.suggestions = suggestions;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Vacation getVacation()
    {
        return vacation;
    }

    public void setVacation(Vacation vacation)
    {
        this.vacation = vacation;
    }

    public Suggestions getSuggestions()
    {
        return suggestions;
    }

    public void setSuggestions(Suggestions suggestions)
    {
        this.suggestions = suggestions;
    }
}
