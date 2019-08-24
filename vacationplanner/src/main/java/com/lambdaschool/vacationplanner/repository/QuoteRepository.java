package com.lambdaschool.vacationplanner.repository;

import com.lambdaschool.vacationplanner.models.Quote;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository<Quote, Long>
{

}
