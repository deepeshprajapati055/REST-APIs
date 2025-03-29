package com.restapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restapi.entity.Visitor;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, String> {
	@Query("SELECT v FROM Visitor v WHERE v.sex = :sex")
	List<Visitor> findBySex(@Param("sex") String sex);
	
	@Query("SELECT v FROM Visitor v WHERE v.id = :id")
	Optional<Visitor> findById(@Param("id") String id);
}
