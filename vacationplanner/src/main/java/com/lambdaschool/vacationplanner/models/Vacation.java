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

    @Column(name = "startdate")
    private String startdate;

    @Column(name = "enddate")
    private String enddate;

    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("vacation")
    private List<VacationParticipants> vacationParticipants = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "VACATIONSUGGESTIONS", joinColumns = {@JoinColumn(name = "vacationid")}, inverseJoinColumns = {@JoinColumn(name = "suggestionid")})
    private List<Suggestions> vacationsuggestions = new ArrayList<>();

    public Vacation()
    {
    }

    public Vacation(String vacationlocation, String thingstodo, String startdate, String enddate)
    {
        this.vacationlocation = vacationlocation;
        this.thingstodo = thingstodo;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public String getStartdate()
    {
        return startdate;
    }

    public void setStartdate(String startdate)
    {
        this.startdate = startdate;
    }

    public String getEnddate()
    {
        return enddate;
    }

    public void setEnddate(String enddate)
    {
        this.enddate = enddate;
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

    public List<VacationParticipants> getVacationParticipants()
    {
        return vacationParticipants;
    }

    public void setVacationParticipants(List<VacationParticipants> vacationParticipants)
    {
        this.vacationParticipants = vacationParticipants;
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
