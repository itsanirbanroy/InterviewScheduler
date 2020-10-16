package com.sba3.interviewscheduler.service;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sba3.interviewscheduler.dao.InterviewRepository;
import com.sba3.interviewscheduler.entity.Interview;
import com.sba3.interviewscheduler.entity.User;
import com.sba3.interviewscheduler.exception.InterviewNotFoundException;
import com.sba3.interviewscheduler.exception.UserNotFoundException;

@Service
public class InterviewServiceImpl implements InterviewService{

	@Autowired
	InterviewRepository repository;

	@Override
	public Interview addInterview(Interview interview) {
		// TODO Auto-generated method stub
		return repository.save(interview);
	}

	@Override
	public Interview getInterviewById(int itemId) {
		// TODO Auto-generated method stub
		return repository.getOne(itemId);
	}

	@Override
	public List<Interview> getAllInterviews() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Interview updateInterviewStatus(int id, String status) {
		// TODO Auto-generated method stub
		return repository.updateInterviewStatus(id, status);
	}

	@Override
	public Interview getInterviewByName(String name) {
		// TODO Auto-generated method stub
		return repository.getInterviewByName(name);
	}
	
	@Override
	public Interview getInterviewByInterviewer(String name) {
		// TODO Auto-generated method stub
		return repository.getInterviewByInterviewer(name);
	}

	@Override
	public int getTotalInterview() {
		// TODO Auto-generated method stub
		return repository.getTotalInterview();
	}

	@Override
	public void addAttendee(String userid, int interviewid) {
		// TODO Auto-generated method stub
		String attendees = repository.getAttendee(interviewid);
		try {
			if(!attendees.isEmpty()) {
				String attendee = attendees+","+userid;
				repository.addAttendee(attendee, interviewid);
			}
			else
				repository.addAttendee(userid, interviewid);
		}
		catch(NullPointerException e) {
			repository.addAttendee(userid, interviewid);
		}
	}

	@Override
	public String getAllAttendee(int id) {
		// TODO Auto-generated method stub
		return repository.getAttendee(id);
	}


	@Override
	public void deleteAttendee(String userid, int interviewid) {
		if(repository.getOne(interviewid)!=null) {
			// TODO Auto-generated method stub
			String totalAttendee = repository.getAttendee(interviewid);
		    if(totalAttendee!=null) {
		    	String[] values = totalAttendee.split(",");
		    	TreeSet<String> set = new TreeSet<String>(Arrays.asList(values));
		    	
		    	for (String str : set) {
		    		  // possibly add to tsWithExtra
		    		if(str.equals(userid)) {
		    			set.remove(str);
		    		}
		    		else
		    			throw new UserNotFoundException(userid);
		    	}
		    	if(set.size()>0) {
		    		String attendeeNames = String.join(",", set);
		    		repository.addAttendee(attendeeNames, interviewid);
		    	}
		    	else
		    		repository.addAttendee(null, interviewid);	
		    }
	    }
		else {
			throw new InterviewNotFoundException(String.valueOf(interviewid));
		}
	}

	@Override
	public List<Integer> getInterviewIdsByUser(String userid) {
		// TODO Auto-generated method stub
		return repository.getInterviewIdByUser(userid);

	}
}
