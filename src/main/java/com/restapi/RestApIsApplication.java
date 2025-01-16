package com.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApIsApplication.class, args);
		System.out.println("Server run on port no - 7070");
	}

}
