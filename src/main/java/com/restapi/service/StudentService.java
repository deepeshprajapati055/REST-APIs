package com.restapi.service;
import com.restapi.entity.Student;
import java.util.List;

public interface StudentService {
	
	Student addStudent(Student student);
	
	List<Student> getAllStudentDetails();
	
	Student getStudentById(Integer id);
	
	void deleteStudentById(Integer id);
	
	Student updateStudent(Student student);
	
	List<Student> findStudentBySex(String str);
}
