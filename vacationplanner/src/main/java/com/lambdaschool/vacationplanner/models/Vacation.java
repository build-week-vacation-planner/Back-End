package com.lambdaschool.vacationplanner.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "VACATION")
public class Vacation
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long vacationid;

    @Column(name = "location")
    private String vacationlocation;

    @Column(name = "thingstodo")
    private String thingstodo;

    @Column(name = "date")
    private String vacationdate;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PARTICIPANTS", joinColumns = {@JoinColumn(name = "vacationid")}, inverseJoinColumns = {@JoinColumn(name = "userid")})
    @JsonIgnoreProperties("vacations")
    private List<User> participants = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "VACATIONSUGGESTIONS", joinColumns = {@JoinColumn(name = "vacationid")}, inverseJoinColumns = {@JoinColumn(name = "suggestionid")})
    private List<Suggestions> vacationsuggestions = new ArrayList<>();

    public Vacation()
    {
    }

    public Vacation(String vacationlocation, String thingstodo, String vacationdate, List<User> participants)
    {
        this.vacationlocation = vacationlocation;
        this.thingstodo = thingstodo;
        this.vacationdate = vacationdate;
        this.participants = participants;
    }

    public long getVacationid()
    {
        return vacationid;
    }

    public void setVacationid(long vacationid)
    {
        this.vacationid = vacationid;
    }

    public String getVacationlocation()
    {
        return vacationlocation;
    }

    public void setVacationlocation(String vacationlocation)
    {
        this.vacationlocation = vacationlocation;
    }

    public String getThingstodo()
    {
        return thingstodo;
    }

    public void setThingstodo(String thingstodo)
    {
        this.thingstodo = thingstodo;
    }

    public String getVacationdate()
    {
        return vacationdate;
    }

    public void setVacationdate(String vacationdate)
    {
        this.vacationdate = vacationdate;
    }


    public List<User> getParticipants()
    {
        return participants;
    }

    public void setParticipants(List<User> participants)
    {
        this.participants = participants;
    }

    public List<Suggestions> getVacationsuggestions()
    {
        return vacationsuggestions;
    }

    public void setVacationsuggestions(List<Suggestions> vacationsuggestions)
    {
        this.vacationsuggestions = vacationsuggestions;
    }
}
