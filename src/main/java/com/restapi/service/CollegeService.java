package com.restapi.service;

import java.util.List;

import com.restapi.entity.College;

public interface CollegeService {

	College addCollegeDetials(College college);		//Create - C
	
	List<College> readAllCollegeDetails();			//Read - R
	
	College updateCollegeDetails(College college);	//Update - U
	
	College deleteCollegeById(Integer id);			//Delete - D
	
}
