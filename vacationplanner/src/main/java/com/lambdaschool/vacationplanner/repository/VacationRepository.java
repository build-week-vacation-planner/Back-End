package com.lambdaschool.vacationplanner.repository;

import com.lambdaschool.vacationplanner.models.Vacation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface VacationRepository extends CrudRepository<Vacation, Long>
{
    Vacation findByVacationid(long id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO vacationsuggestion(userid, vacationid, suggestionid) values (:userid, :vacationid, :suggestionid)",
    nativeQuery = true)
    void insertVacationSuggestion(long userid, long vacationid, long suggestionid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO vacationparticipants(userid, vacationid) values (:userid, :vacationid)", nativeQuery = true)
    void insertVacationParticipants(long userid, long vacationid);
}
