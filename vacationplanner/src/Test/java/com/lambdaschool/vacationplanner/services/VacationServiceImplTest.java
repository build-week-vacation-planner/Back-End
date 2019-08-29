package com.lambdaschool.vacationplanner.services;

import com.lambdaschool.vacationplanner.VacationplannerApplication;
import com.lambdaschool.vacationplanner.models.Vacation;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VacationplannerApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VacationServiceImplTest
{
    @Autowired
    private VacationService vacationService;

    @Test
    public void Asave()
    {
        Vacation v1 = new Vacation("Boston", "May 10", "May 19", "Clam Chowder");

        Vacation addVacation = vacationService.save(v1);

        assertNotNull(addVacation);

        Vacation foundVacation = vacationService.findById(addVacation.getVacationid());
        assertEquals(addVacation.getVacationid(), foundVacation.getVacationid());
    }

    @Test
    public void Bupdate()
    {
        Vacation v1 = new Vacation("Boston", "May 10", "May 19", "Clam Chowder");

        v1.setVacationid(200);

        Vacation updatedV1 = vacationService.update(v1, 7);

        assertEquals("Boston", updatedV1.getVacationlocation());
    }

    @Test
    public void CfindById()
    {
        assertEquals("Hawaii", vacationService.findById(7).getVacationlocation());
    }
}
