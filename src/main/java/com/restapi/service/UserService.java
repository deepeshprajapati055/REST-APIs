package com.restapi.service;

import java.util.List;

import com.restapi.entity.User;

public interface UserService {

	User addUser(User user);
	
	List<User> showAllUsers();
	
	User updateUser(User user);
	
	User deleteUser(Integer id);
	
}
