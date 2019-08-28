package com.lambdaschool.vacationplanner.controllers;

import com.lambdaschool.vacationplanner.models.Suggestions;
import com.lambdaschool.vacationplanner.models.User;
import com.lambdaschool.vacationplanner.models.Vacation;
import com.lambdaschool.vacationplanner.models.VacationSuggestion;
import com.lambdaschool.vacationplanner.services.SuggestionService;
import com.lambdaschool.vacationplanner.services.UserService;
import com.lambdaschool.vacationplanner.services.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SuggestionController
{
    @Autowired
    private SuggestionService suggestionService;

    @Autowired
    private UserService userService;

    @Autowired
    private VacationService vacationService;

    @PostMapping(value = "/user/{userid}/vacation/{vacationid}/suggestion", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addNewSuggestion(HttpServletRequest request, @Valid @RequestBody Suggestions newSuggestion, @PathVariable long userid, @PathVariable long vacationid)
    {
        User u = userService.findUserById(userid);
        Vacation v = vacationService.findById(vacationid);

        newSuggestion = suggestionService.save(newSuggestion);

        vacationService.insertIntoVacaSugg(userid, vacationid, newSuggestion.getSuggestionid());



        HttpHeaders responseHeaders = new HttpHeaders();
        URI newSuggestionURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{suggestionid}").buildAndExpand(newSuggestion.getSuggestionid()).toUri();
        responseHeaders.setLocation(newSuggestionURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/user/{userid}/vacation/{vacationid}")
    public ResponseEntity<?> addParticipant(HttpServletRequest request, @PathVariable long userid, @PathVariable long vacationid)
    {
        User u = userService.findUserById(userid);
        Vacation v = vacationService.findById(vacationid);

        vacationService.insertIntoVacaParts(userid, vacationid);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "suggestion/{id}", consumes = {"application/json"}, produces = {"applicaiton/json"})
    public ResponseEntity<?> updateSuggestion(HttpServletRequest request, @RequestBody Suggestions suggestions, @PathVariable long id)
    {
        suggestionService.update(suggestions, id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/suggestion/{id}")
    public ResponseEntity<?> deleteSuggestionbyId(HttpServletRequest request, @PathVariable long id)
    {
        suggestionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
