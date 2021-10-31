package com.sergeykuzmin.restapi.repository;

import com.sergeykuzmin.restapi.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartphoneRepository extends QuerydslPredicateExecutor<Smartphone>, JpaRepository<Smartphone, Long> {
}
