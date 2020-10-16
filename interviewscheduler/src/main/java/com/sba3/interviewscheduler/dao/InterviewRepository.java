package com.sba3.interviewscheduler.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sba3.interviewscheduler.entity.Interview;

@Transactional
public interface InterviewRepository extends JpaRepository<Interview, Integer>{
	
	@Modifying
	@Query(value = "Update interview Set interview_status = :status WHERE interview_id = :id", nativeQuery = true)
	public Interview updateInterviewStatus(int id, String status);
	
	@Query(value = "SELECT * FROM interview WHERE interview_name = :name", nativeQuery = true)
	public Interview getInterviewByName(String name);
	
	@Query(value = "SELECT * FROM interview WHERE interviewer_name = :name", nativeQuery = true)
	public Interview getInterviewByInterviewer(String name);

	@Query(value = "SELECT COUNT(*) FROM interview", nativeQuery = true)
	public int getTotalInterview();
	
	@Modifying
	@Query(value = "Update interview Set attendee= :userid where interview_id = :interviewid", nativeQuery = true)
	public int addAttendee(String userid, int interviewid);
	
	@Query(value = "Select attendee from interview where interview_id=:interviewid", nativeQuery = true)
	public String getAttendee(int interviewid);
	
	@Query(value = "Select interview_id from interview where attendee like %:userid%", nativeQuery = true)
	public List<Integer> getInterviewIdByUser(String userid);

	
}
