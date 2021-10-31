package com.sergeykuzmin.restapi.repository;

import com.sergeykuzmin.restapi.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends QuerydslPredicateExecutor<Company>, JpaRepository<Company, Long> {
}
