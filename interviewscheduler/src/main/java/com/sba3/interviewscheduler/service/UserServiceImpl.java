package com.sba3.interviewscheduler.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sba3.interviewscheduler.dao.InterviewRepository;
import com.sba3.interviewscheduler.dao.UserRepository;
import com.sba3.interviewscheduler.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	InterviewRepository interviewRepository;
	
	@Autowired
	InterviewService interviewService;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public User getUserById(int itemId) {
		// TODO Auto-generated method stub
		return repository.getUserById(itemId);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void deleteById(int userId) {
		// TODO Auto-generated method stub
		String user = String.valueOf(userId);
		List<Integer> list = interviewService.getInterviewIdsByUser(user);
		//System.out.println(list.size());
		try {
			for(int item:list) {
				//System.out.println("List item = "+item);
				interviewService.deleteAttendee(user, item);
			}
		}
		catch(Exception e) {
			
		}
		finally {
			repository.deleteById(userId);
		}
	}


}
