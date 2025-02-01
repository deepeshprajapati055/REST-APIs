package com.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student_details")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length=10, name="std_id")
	private Integer id;
	
	@Column(length=50, name="std_name")
	private String name;
	
	@Column(length=100, name="std_age")
	private Integer age;
	
	@Column(length=10, name="std_mobileno")
	private Long mobileno;
		
	@Column(length=10, name="std_sex")
	private String sex;
	
	@Column(length=100, name="std_address")
	private String address;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, Integer age, Long mobileno, String sex, String address) {
		super();
		this.name = name;
		this.age = age;
		this.mobileno = mobileno;
		this.sex = sex;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getMobileno() {
		return mobileno;
	}

	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
