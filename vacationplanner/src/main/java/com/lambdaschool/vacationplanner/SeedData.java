package com.lambdaschool.vacationplanner;

import com.lambdaschool.vacationplanner.models.*;
import com.lambdaschool.vacationplanner.services.RoleService;
import com.lambdaschool.vacationplanner.services.SuggestionService;
import com.lambdaschool.vacationplanner.services.UserService;
import com.lambdaschool.vacationplanner.services.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    VacationService vacationService;

    @Autowired
    SuggestionService suggestionService;


    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        roleService.save(r1);
        roleService.save(r2);
        roleService.save(r3);

        // admin, data, user
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        admins.add(new UserRoles(new User(), r3));
        User u1 = new User("admin", "password", admins);
        u1.getQuotes().add(new Quote("A creative man is motivated by the desire to achieve, not by the desire to beat others", u1));
        u1.getQuotes().add(new Quote("The question isn't who is going to let me; it's who is going to stop me.", u1));
        u1 = userService.save(u1);
        Vacation hawaiiVacation = new Vacation("Hawaii", "Go for a hike", "January 7", "January 15");
        VacationParticipants testPart = new VacationParticipants(u1, hawaiiVacation);
        List<VacationParticipants> testPartList = new ArrayList<>();
        testPartList.add(testPart);
        hawaiiVacation.setVacationParticipants(testPartList);
        vacationService.save(hawaiiVacation);

        // data, user
        ArrayList<UserRoles> datas = new ArrayList<>();
        datas.add(new UserRoles(new User(), r3));
        datas.add(new UserRoles(new User(), r2));
        User u2 = new User("cinnamon", "1234567", datas);
        u2 = userService.save(u2);
        Vacation hawaiiVacation2 = new Vacation("Hawaii", "Go for a hike", "December 7", "January 15");
        VacationParticipants testPart2 = new VacationParticipants(u2, hawaiiVacation2);
        List<VacationParticipants> testPartList2 = new ArrayList<>();
        testPartList2.add(testPart2);
        hawaiiVacation2.setVacationParticipants(testPartList2);
        vacationService.save(hawaiiVacation2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("barnbarn", "ILuvM4th!", users);
        u3.getQuotes().add(new Quote("Live long and prosper", u3));
        u3.getQuotes().add(new Quote("The enemy of my enemy is the enemy I kill last", u3));
        u3.getQuotes().add(new Quote("Beam me up", u3));
        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("Bob", "password", users);
        u4 = userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("Jane", "password", users);
        u5 = userService.save(u5);

        Vacation newVacation = new Vacation("London", "Big Ben", "August 21", "August 28");
        List<VacationParticipants> newParticipants = new ArrayList<>();
        newParticipants.add(new VacationParticipants(u4, newVacation));
        newVacation.setVacationParticipants(newParticipants);
        newVacation = vacationService.save(newVacation);

        Suggestions suggestion = new Suggestions("Go for a walk");
        suggestion = suggestionService.save(suggestion);
        List<VacationSuggestion> newSuggestions = new ArrayList<>();
        VacationSuggestion newVacationSuggestion = new VacationSuggestion(u4, newVacation, suggestion);
        newSuggestions.add(newVacationSuggestion);
        newVacation.setVacationSuggestions(newSuggestions);
    }
}