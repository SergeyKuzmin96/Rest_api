package com.sergeykuzmin.restapi.repository;

import com.sergeykuzmin.restapi.model.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FridgeRepository extends QuerydslPredicateExecutor<Fridge>, JpaRepository<Fridge, Long> {
}
