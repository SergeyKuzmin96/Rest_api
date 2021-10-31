package com.sergeykuzmin.restapi.repository;

import com.sergeykuzmin.restapi.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends QuerydslPredicateExecutor<Country>, JpaRepository<Country, Long> {
}
