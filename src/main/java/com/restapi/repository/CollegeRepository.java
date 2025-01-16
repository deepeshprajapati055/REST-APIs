package com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer> {
	
}
