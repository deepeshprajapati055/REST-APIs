package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entity.User;
import com.restapi.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	//api for add the user.
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	//api for show all the users'.
	@GetMapping("/showUsers")
	public List<User> showAllUsers(@RequestBody User user){
		return userService.showAllUsers();
	}
	
	//api for update the particular user.
	@PostMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	//api for deleting the user with there id.
	@GetMapping("/deleteUser/{id}")
	public User deleteUser(@PathVariable("id") Integer id) {
		return userService.deleteUser(id);
	}
	
}