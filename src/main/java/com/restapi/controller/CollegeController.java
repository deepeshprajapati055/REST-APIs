package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entity.College;
import com.restapi.service.CollegeService;

@RestController
public class CollegeController {
	
	@Autowired
	CollegeService collegeService;
	
	@PostMapping("/addColleges")
	public ResponseEntity<?> addCollege(@RequestBody College college) {
		College clg = collegeService.addCollegeDetials(college);
		if(clg!=null) {
			return ResponseEntity.status(HttpStatus.OK).body("college details saved Successfully");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occured while adding the details");
		}
	}
	
	@GetMapping("/showColleges")
	public List<College> showCollege(@RequestBody College college){
		return collegeService.readAllCollegeDetails();
	}
	
	@PostMapping("/updateColleges")
	public College updateCollege(@RequestBody College college) {
		return collegeService.updateCollegeDetails(college);
	}
	
	@GetMapping("/deleteCollege/{id}")
	public College deleteCollegeById(@PathVariable("id") Integer id) {
		return collegeService.deleteCollegeById(id);
	}
}
