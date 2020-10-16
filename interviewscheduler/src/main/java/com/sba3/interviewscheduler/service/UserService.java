package com.sba3.interviewscheduler.service;

import java.util.List;

import com.sba3.interviewscheduler.entity.User;

public interface UserService {
	public User addUser(User user);
	public User getUserById(int itemId);
	public List<User> getAllUsers();
	public void deleteById(int blogId);
}
 