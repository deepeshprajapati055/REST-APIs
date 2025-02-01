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

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/addStudent")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		Student std = studentService.addStudent(student);
		if(std == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occured due to save.");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body("Student saved successfully.");
		}
	}
	
	@GetMapping("/getallstudentdetails")
	public List<Student> getAllStudentDetails(){
		return studentService.getAllStudentDetails();
	}
	
	@GetMapping("/getstudentbyid/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") Integer id) {
		Student std = studentService.getStudentById(id);
		if(std != null) {
			return ResponseEntity.status(HttpStatus.OK).body(std);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with id "+id);
		}
	}
	
	@GetMapping("/deletestudent/{id}")
	public ResponseEntity<?> deleteStudentById(@PathVariable("id") Integer id){
		studentService.deleteStudentById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Student Deleted with id: "+id);
	}
	
	@PostMapping("/updatestudent/")
	public ResponseEntity<?> updateStudent(@RequestBody Student student){
		Student std = studentService.updateStudent(student);
		if(std == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body("Student details updated successfully.");
		}
	}
	
	@GetMapping("/getstudentbysex/{string}")
	public ResponseEntity<?> studentBySex(@PathVariable("string") String str){
		List<Student> std = studentService.findStudentBySex(str);
		if(std.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This gender is not available");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(std);
		}
	}
}
