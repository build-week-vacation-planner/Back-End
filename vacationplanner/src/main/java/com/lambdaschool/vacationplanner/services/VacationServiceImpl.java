package com.lambdaschool.vacationplanner.services;

import com.lambdaschool.vacationplanner.models.User;
import com.lambdaschool.vacationplanner.models.Vacation;
import com.lambdaschool.vacationplanner.models.VacationParticipants;
import com.lambdaschool.vacationplanner.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service(value = "vacationService")
public class VacationServiceImpl implements VacationService
{
    @Autowired
    private VacationRepository vacationrepos;

    @Transactional
    @Override
    public Vacation save(Vacation vacation)
    {
        Vacation newVacation = new Vacation();
        newVacation.setVacationlocation(vacation.getVacationlocation());
        newVacation.setThingstodo(vacation.getThingstodo());
        newVacation.setStartdate(vacation.getStartdate());
        newVacation.setEnddate(vacation.getEnddate());

        ArrayList<VacationParticipants> newParticipants = new ArrayList<>();
        for (VacationParticipants p : vacation.getVacationParticipants())
        {
            p.setVacation(newVacation);
            newParticipants.add(p);
        }
        newVacation.setVacationParticipants(newParticipants);

        return vacationrepos.save(newVacation);
    }
}
