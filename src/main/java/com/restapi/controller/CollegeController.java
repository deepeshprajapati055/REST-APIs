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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="College Controller", description="API for College Controller")
@RestController
public class CollegeController {
	
	@Autowired
	CollegeService collegeService;
	
	@Operation(summary="Create a new college", description="Add college in the database.")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description="College details saved successfully in the database."),
		@ApiResponse(responseCode = "400", description="Error occured while adding the details of college")
	})
	@PostMapping("/addColleges")
	public ResponseEntity<?> addCollege(
			@io.swagger.v3.oas.annotations.parameters.RequestBody(description="College object to be created")
			@RequestBody College college) {
		College clg = collegeService.addCollegeDetials(college);
		if(clg!=null) {
			return ResponseEntity.status(HttpStatus.OK).body("college details saved Successfully");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occured while adding the details of college");
		}
	}
	
	@Operation(summary="Get mapping for all colleges", description="Show all the colleges that are available in the database.")
	@GetMapping("/showColleges")
	public List<College> showCollege(){
		return collegeService.readAllCollegeDetails();
	}
	
	@Operation(summary="Post mapping for update college", description="Update college fields")
	@PostMapping("/updateColleges")
	public College updateCollege(@RequestBody College college) {
		return collegeService.updateCollegeDetails(college);
	}
	
	@Operation(summary="Get mapping for delete college", description="Deleted college with their id")
	@GetMapping("/deleteCollege/{id}")
	public College deleteCollegeById(
			@Parameter(description="College ID to fetch", example="1")
			@PathVariable("id") Integer id) {
		return collegeService.deleteCollegeById(id);
	}
}
