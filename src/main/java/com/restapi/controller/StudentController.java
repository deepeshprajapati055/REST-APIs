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

import com.restapi.entity.Student;
import com.restapi.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Student Controller", description="API for student management")
@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@Operation(summary="Create a new student")
	@ApiResponses({
		@ApiResponse(responseCode="201", description="Student created successfully in the database"),
		@ApiResponse(responseCode="400", description="Error occured while saving student in the database.")
	})
	@PostMapping("/addStudent")
	public ResponseEntity<?> addStudent(
		@io.swagger.v3.oas.annotations.parameters.RequestBody(description="Student object to be created")
		@RequestBody Student student){
		Student std = studentService.addStudent(student);
		if(std == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occured due to save.");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body("Student saved successfully. :)");
		}
	}
	
	@Operation(summary="Get All Students", description="Fetch all students from the database.")
	@ApiResponse(responseCode="200")
	@GetMapping("/getallstudentdetails")
	public List<Student> getAllStudentDetails(){
		return studentService.getAllStudentDetails();
	}
	
	@Operation(summary="Get student by id")
	@ApiResponses({
		@ApiResponse(responseCode="200", description="Student get successfully with their id"),
		@ApiResponse(responseCode="404", description="Student is not found with their id")
	})
	@GetMapping("/getstudentbyid/{id}")
	public ResponseEntity<?> getStudentById(
			@Parameter(description="Student id to fetch", example="1")
			@PathVariable("id") Integer id) {
		Student std = studentService.getStudentById(id);
		if(std != null) {
			return ResponseEntity.status(HttpStatus.OK).body(std);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with id "+id);
		}
	}
	
	@Operation(summary="Delete student by id")
	@ApiResponses({
		@ApiResponse(responseCode="200", description="Student Deleted Successfully"),
		@ApiResponse(responseCode="404", description="Student is not found"),
	})
	@GetMapping("/deletestudent/{id}")
	public ResponseEntity<?> deleteStudentById(
			@Parameter(description="Delete student by id", example="1")
			@PathVariable("id") Integer id){
			studentService.deleteStudentById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Student Deleted with id: "+id);
	}
	
	@Operation(summary="Update Student Data")
	@ApiResponses({
		@ApiResponse(responseCode="200", description="Student details updated successfully"),
		@ApiResponse(responseCode="404", description="Student not found")
	})
	@PostMapping("/updatestudent/")
	public ResponseEntity<?> updateStudent(
			@io.swagger.v3.oas.annotations.parameters.RequestBody(description="student object to be updated")
			@RequestBody Student student){
		Student std = studentService.updateStudent(student);
		if(std == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body("Student details updated successfully.");
		}
	}
	
	@Operation(summary="Get Sex of Student",description="Get student data by sex")
	@ApiResponses({
		@ApiResponse(responseCode="200", description="Student's successfully get by its gender"),
		@ApiResponse(responseCode="404", description="Student's is not available with this gender")
	})
	@GetMapping("/getstudentbysex/{string}")
	public ResponseEntity<?> studentBySex(
			@Parameter(description="Get student's by its gender", example="male, female")
			@PathVariable("string") String str){
		List<Student> std = studentService.findStudentBySex(str);
		if(std.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student's are not available with this gender.");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(std);
		}
	}
}
