package com.restapi.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="visitor_tables")
public class Visitor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="v_id")
	private Integer id;
	
	@Column(name="v_name")
	private String name;
	
	@Column(name="v_age")
	private Integer age;
	
	@Column(name="v_city")
	private String city;
	
	@Column(name="v_address")
	private String address;
	
	@Column(name="v_mobileno")
	private Long mobile;
	
	@Column(name="v_timing")
	private Date dateTime;

	public Visitor(String name, Integer age, String city, String address, Long mobile, Date dateTime) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.address = address;
		this.mobile = mobile;
		this.dateTime = dateTime;
	}

	public Visitor() {
		// TODO Auto-generated constructor stub
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
}
