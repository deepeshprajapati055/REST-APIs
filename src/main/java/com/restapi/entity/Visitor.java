package com.restapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Visitor {
	
	@Id
	private String id;
	private String name;
	private Integer age;
	private String sex;
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	
}