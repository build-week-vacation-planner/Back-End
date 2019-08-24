package com.lambdaschool.vacationplanner.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MESSAGES")
public class Messages
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long messageid;

    @Column(name = "messagecontent")
    private String messagecontent;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "messageauthor", joinColumns = {@JoinColumn(name = "messageid")}, inverseJoinColumns = {@JoinColumn(name = "userid")})
    @JsonIgnoreProperties("messages")
    private List<User> messageauthor = new ArrayList<>();

    public Messages()
    {
    }

    public Messages(String messagecontent, List<User> messageauthor)
    {
        this.messagecontent = messagecontent;
        this.messageauthor = messageauthor;
    }

    public long getMessageid()
    {
        return messageid;
    }

    public void setMessageid(long messageid)
    {
        this.messageid = messageid;
    }

    public String getMessagecontent()
    {
        return messagecontent;
    }

    public void setMessagecontent(String messagecontent)
    {
        this.messagecontent = messagecontent;
    }

    public List<User> getMessageauthor()
    {
        return messageauthor;
    }

    public void setMessageauthor(List<User> messageauthor)
    {
        this.messageauthor = messageauthor;
    }
}
