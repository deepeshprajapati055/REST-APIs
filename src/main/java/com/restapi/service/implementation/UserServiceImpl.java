package com.restapi.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.entity.User;
import com.restapi.repository.UserRepository;
import com.restapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
    @Autowired
    private UserRepository userRepo;
    
    //Save the user to the database.
    @Override
    public User addUser(User user) {
        return this.userRepo.save(user);
    }

    //Show all the user that is present in the database.
    @Override
    public List<User> showAllUsers() {
        return this.userRepo.findAll();
    }
    
    //Update the particular user by there id.
    @Override
    public User updateUser(User user) {
        Optional<User> existingUser = userRepo.findById(user.getId());
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setAge(user.getAge());
            updatedUser.setMobileno(user.getMobileno());
            updatedUser.setCity(user.getCity());
            updatedUser.setAddress(user.getAddress());
            return userRepo.save(updatedUser);
        }
        throw new RuntimeException("User not found with id: " + user.getId());
    }
    
    //Delete the user by there id.
    @Override
    public User deleteUser(Integer id) {
    	Optional<User> u = this.userRepo.findById(id);
        if(u.isEmpty()) {
        	return null;
        }else {
        	return u.get();
        }
    }
}
