package com.restapi.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.entity.Student;
import com.restapi.repository.StudentRepository;
import com.restapi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		return this.studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudentDetails() {
		return this.studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> s = this.studentRepository.findById(id);
		if(s.isEmpty()) {
			return null;
		}else {
			return s.get();
		}
	}

	@Override
	public void deleteStudentById(Integer id) {
		this.studentRepository.deleteById(id);
	}

	@Override
	public Student updateStudent(Student student) {
		Optional<Student> std = this.studentRepository.findById(student.getId());
		if(std.isEmpty()) {
			return null;
		}else {
			return studentRepository.save(student);
		}
	}

	@Override
	public List<Student> findStudentBySex(String str) {
		return this.studentRepository.findStudentBySex(str);
	}
	
}