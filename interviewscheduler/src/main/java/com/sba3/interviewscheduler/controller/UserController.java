package com.sba3.interviewscheduler.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sba3.interviewscheduler.entity.User;
import com.sba3.interviewscheduler.exception.UserAlreadyExistsException;
import com.sba3.interviewscheduler.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/user")
    public String index() {
		 return "Welcome to User Dashboard";
    }
	
	//Add user
	@PostMapping("/user/create")
    public User create(@RequestBody Map<String, String> body){  
		String id = body.get("userid");
    	String firstName  = body.get("firstName");
    	String lastName = body.get("lastName");
    	String email = body.get("email");
    	String mobile = body.get("mobile");
    	
    	//System.out.println("User = "+userService.getUserById(Integer.parseInt(id)));
    	if(id!=null) {
	    	if(userService.getUserById(Integer.parseInt(id))!=null) {
	    		throw new UserAlreadyExistsException("User already exists. User Id - "+id);
	    	}
    	}
    	User user = new User(firstName, lastName, email, mobile);
    	return userService.addUser(user);
    }
	
	//Delete User
	@DeleteMapping("/user/{id}")
    public boolean delete(@PathVariable String id){
        int userId = Integer.parseInt(id);
        userService.deleteById(userId);
        return true;
    }
	
	//display all users
	@GetMapping("/user/all")
    public List<User> getAll(){        
    	return userService.getAllUsers();
    }
}
