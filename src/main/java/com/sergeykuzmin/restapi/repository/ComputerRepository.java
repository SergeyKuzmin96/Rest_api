package com.sergeykuzmin.restapi.repository;

import com.sergeykuzmin.restapi.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends QuerydslPredicateExecutor<Computer>, JpaRepository<Computer, Long> {


}
