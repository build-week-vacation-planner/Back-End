package com.lambdaschool.vacationplanner.controllers;

import com.lambdaschool.vacationplanner.models.User;
import com.lambdaschool.vacationplanner.models.Vacation;
import com.lambdaschool.vacationplanner.models.VacationParticipants;
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
public class VacationController
{
    @Autowired
    private VacationService vacationService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/{userid}/vacation", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addNewVacation(HttpServletRequest request, @Valid @RequestBody Vacation newVacation, @PathVariable long userid)
    {

        List<VacationParticipants> newParticipants = new ArrayList<>();
        newParticipants.add(new VacationParticipants(userService.findUserById(userid), newVacation));
        newVacation.setVacationParticipants(newParticipants);

        newVacation = vacationService.save(newVacation);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newVacationURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/vacation/{vacationid}").buildAndExpand(newVacation.getVacationid()).toUri();
        responseHeaders.setLocation(newVacationURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "vacation/{vacationid}", consumes = {"application/json"}, produces = {"application/json"})
    public  ResponseEntity<?> updateVacation(HttpServletRequest request, @Valid @RequestBody Vacation updatedVacation, @PathVariable long vacationid)
    {
        vacationService.update(updatedVacation, vacationid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "vacation/delete/{vacationid}")
    public ResponseEntity<?> deleteVacationById(HttpServletRequest request, @PathVariable long vacationid)
    {
        vacationService.delete(vacationid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "vacation/{vacationid}", produces = {"application/json"})
    public ResponseEntity<?> getVacationById(HttpServletRequest request, @PathVariable long vacationid)
    {
        Vacation v = vacationService.findById(vacationid);

        return new ResponseEntity<>(v, HttpStatus.OK);
    }
}
