package com.sergeykuzmin.restapi.repository;

import com.sergeykuzmin.restapi.model.TV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TvRepository extends QuerydslPredicateExecutor<TV>, JpaRepository<TV, Long> {


}
