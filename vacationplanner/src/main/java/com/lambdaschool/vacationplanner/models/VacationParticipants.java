package com.lambdaschool.vacationplanner.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vacationparticipants")
public class VacationParticipants implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = {"vacationParticipants", "userRoles", "quotes", "authority", "vacationSuggestions"})
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "vacationid")
    @JsonIgnoreProperties(value = {"vacation"})
    private Vacation vacation;

    public VacationParticipants()
    {
    }

    public VacationParticipants(User user, Vacation vacation)
    {
        this.user = user;
        this.vacation = vacation;
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
}
