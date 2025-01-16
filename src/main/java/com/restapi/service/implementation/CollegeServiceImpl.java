package com.restapi.service.implementation;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.entity.College;
import com.restapi.repository.CollegeRepository;
import com.restapi.service.CollegeService;

@Service
public class CollegeServiceImpl implements CollegeService{

	@Autowired
	CollegeRepository collegeRepository;
	
	@Override
	public College addCollegeDetials(College college) {
		return this.collegeRepository.save(college);
	}

	@Override
	public List<College> readAllCollegeDetails() {
		return this.collegeRepository.findAll();
	}

	@Override
	public College updateCollegeDetails(College college) {
		Optional<College> cl = this.collegeRepository.findById(college.getId());
		if(cl.isEmpty()) {
			return null;
		}else {
			return collegeRepository.save(college);
		}
	}

	@Override
	public College deleteCollegeById(Integer id) {
		Optional<College> cl = this.collegeRepository.findById(id);
		if(cl.isEmpty()) {
			return null;
		}else {
			return cl.get();
		}
	}

}
