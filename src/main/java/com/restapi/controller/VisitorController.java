package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entity.Visitor;
import com.restapi.service.VisitorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Visitor Controller", description="Restful WebServices for Visitor Controller")
@RestController
@RequestMapping("/visitor")
public class VisitorController {
	
	@Autowired
	private VisitorService visitorService;
	public VisitorController(VisitorService visitorService) {
		super();
		this.visitorService = visitorService;
	}

	@PostMapping
	@Operation(description="Create a new visitor object")
	@ApiResponse(responseCode = "201", description="Visitor is created successfully.")
	public ResponseEntity<Visitor> savingVisitorInformation(
			@io.swagger.v3.oas.annotations.parameters.RequestBody(description="Visitor object to be created.")
			@RequestBody Visitor visitor) {
		Visitor visit = this.visitorService.saveVisitor(visitor);
		return ResponseEntity.status(HttpStatus.CREATED).body(visit);
	}
	
	@GetMapping
	@Operation(description="Get all the visitors")
	@ApiResponse(responseCode="200", description="Show all the list of visitor's available in database.")
	public ResponseEntity<List<Visitor>> getAllVisitorInformation(){
		List<Visitor> getVisitor = this.visitorService.showAllVisitors();
		return ResponseEntity.status(HttpStatus.OK).body(getVisitor);
	}
	
	@Operation(description="Delete visitor by his id")
	@ApiResponse(responseCode="200", description="Visitor is delted successfully with his id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteVisitorById(@PathVariable String id){
		this.visitorService.deleteVisitor(id);
		return ResponseEntity.status(HttpStatus.OK).body("Visitor is successfully deleted with id :"+id);
	}
	
	@PutMapping
	@Operation(description="Update visitor details")
	@ApiResponses({
		@ApiResponse(responseCode="200", description="Visitor is updated successfully."),
		@ApiResponse(responseCode="404", description="Visitor is not found.")
	})
	public ResponseEntity<?> updateVisitor(
			@io.swagger.v3.oas.annotations.parameters.RequestBody(description="Visitor object to be updated.")
			@RequestBody Visitor visitor){
		Visitor updateVisitor = this.visitorService.updateVisitor(visitor);
		if(updateVisitor != null) {
			return ResponseEntity.status(HttpStatus.OK).body(updateVisitor);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visitor not found");
		}
	}
	
	@GetMapping("/getById/{id}")
	@Operation(description="Get Visitor by his id")
	@ApiResponses({
		@ApiResponse(responseCode="200",description="Get visitor successfully by his id."),
		@ApiResponse(responseCode="404",description="Visitor id is not found.")
	})
	public ResponseEntity<?> getByVisitorId(@PathVariable String id){
		Visitor getByVisitor = this.visitorService.getVisitorById(id);
		if(getByVisitor!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(getByVisitor);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visitor id not found.");
		}
	}
	
	@GetMapping("/getBySex/{sex}")
	@Operation(description="Get Visitor by his sex - Male, Femal")
	@ApiResponse(responseCode="200", description="Getting all visitor's by his sex. - female, male")
	public ResponseEntity<?> getByVisitorSex(@PathVariable String sex){
		List<Visitor> getBySexVisitor = this.visitorService.getVisitorBySex(sex);
		return ResponseEntity.status(HttpStatus.OK).body(getBySexVisitor);
	}
}
