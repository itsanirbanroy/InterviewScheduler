package com.sba3.interviewscheduler.service;

import java.util.List;
import com.sba3.interviewscheduler.entity.Interview;
import com.sba3.interviewscheduler.entity.User;

public interface InterviewService {
	public Interview addInterview(Interview inteview);
	public void deleteById(int id);
	public Interview updateInterviewStatus(int id, String status);
	public Interview getInterviewByName(String name);
	public Interview getInterviewByInterviewer(String name);
	public Interview getInterviewById(int id);
	public int getTotalInterview();
	public List<Interview> getAllInterviews();
	public void addAttendee(String userid, int interviewid);
	public String getAllAttendee(int id);
	public void deleteAttendee(String userid, int interviewid);
	public List<Integer> getInterviewIdsByUser(String userid);
}
