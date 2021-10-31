package com.sergeykuzmin.restapi.repository;

import com.sergeykuzmin.restapi.model.Cleaner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CleanerRepository extends QuerydslPredicateExecutor<Cleaner>, JpaRepository<Cleaner, Long> {
}
