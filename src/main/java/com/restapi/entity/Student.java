package com.restapi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Schema(description="Student Entity")
@Entity
@Table(name="student_details")
public class Student {
	
	@Schema(description="Student ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length=10, name="std_id")
	private Integer id;
	
	@Schema(description="Student Name", example="deepesh prajapati")
	@Column(length=50, name="std_name")
	private String name;
	
	@Schema(description="Student Age", example="23")
	@Column(length=100, name="std_age")
	private Integer age;
	
	@Schema(description="Student Mobile Number", example="7854125963")
	@Column(length=10, name="std_mobileno")
	private Long mobileno;
		
	@Schema(description="Student Sex", example="Male")
	@Column(length=10, name="std_sex")
	private String sex;
	
	@Schema(description="Student Address", example="123, Chawdi Market, Delhi - 411954")
	@Column(length=100, name="std_address")
	private String address;

	public Student() {
		
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
