package com.sba3.interviewscheduler.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sba3.interviewscheduler.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value = "SELECT * FROM user WHERE user_id = :id", nativeQuery = true)
	public User getUserById(int id);
}
