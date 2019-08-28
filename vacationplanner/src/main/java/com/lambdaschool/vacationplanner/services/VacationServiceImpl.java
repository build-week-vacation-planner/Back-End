package com.lambdaschool.vacationplanner.services;

import com.lambdaschool.vacationplanner.exceptions.ResourceNotFoundException;
import com.lambdaschool.vacationplanner.models.User;
import com.lambdaschool.vacationplanner.models.Vacation;
import com.lambdaschool.vacationplanner.models.VacationParticipants;
import com.lambdaschool.vacationplanner.models.VacationSuggestion;
import com.lambdaschool.vacationplanner.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

        ArrayList<VacationSuggestion> newSuggestions = new ArrayList<>();
        for (VacationSuggestion s : vacation.getVacationSuggestions())
        {
            s.setVacation(newVacation);
            newSuggestions.add(s);
        }
        newVacation.setVacationSuggestions(newSuggestions);

        return vacationrepos.save(newVacation);
    }

    @Transactional(timeout = -1)
    @Override
    public Vacation update(Vacation vacation, long id)
    {
        System.out.println("The beginning");
        Vacation currentVacation = vacationrepos.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
        System.out.println(currentVacation.getVacationid());
        if (currentVacation != null)
        {
                System.out.println("Hello World");
                if (vacation.getVacationlocation() != null)
                {
                    currentVacation.setVacationlocation(vacation.getVacationlocation());
                }

                if (vacation.getThingstodo() != null)
                {
                    currentVacation.setThingstodo(vacation.getThingstodo());
                }

                if (vacation.getStartdate() != null)
                {
                    currentVacation.setStartdate(vacation.getStartdate());
                }

                if (vacation.getEnddate() != null)
                {
                    currentVacation.setEnddate(vacation.getEnddate());
                }

//                if (vacation.getVacationParticipants().size() > 0)
//                {
//                    for (VacationParticipants v : vacation.getVacationParticipants())
//                    {
//                        currentVacation.getVacationParticipants().add(new VacationParticipants(v.getUser(), v.getVacation()));
//                    }
//                }

//                if (vacation.getVacationSuggestions().size() > 0)
//                {
//                    List<VacationSuggestion> testList = new ArrayList<>();
////                    for (VacationSuggestion v : vacation.getVacationSuggestions())
////                    {
////                        testList.add(new VacationSuggestion(v.getUser(), v.getVacation(), v.getSuggestions()));
////                    }
//                    currentVacation.setVacationSuggestions(testList);
//                }

            }

        return vacationrepos.save(currentVacation);
    }

    public void insertIntoVacaSugg(long userid, long vacationid, long suggestionid)
    {
        vacationrepos.insertVacationSuggestion(userid, vacationid, suggestionid);
    }

    public void insertIntoVacaParts(long userid, long vacationid)
    {
        vacationrepos.insertVacationParticipants(userid, vacationid);
    }

    @Override
    public void delete(long id)
    {
       vacationrepos.deleteById(id);
    }

    @Override
    public Vacation findById(long id)
    {
//        Vacation v = vacationrepos.findByVacationid(id);
        Vacation v = vacationrepos.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
        return v;
    }
}
