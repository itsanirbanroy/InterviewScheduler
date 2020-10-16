package com.sba3.interviewscheduler.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sba3.interviewscheduler.entity.Interview;
import com.sba3.interviewscheduler.service.InterviewService;

@RestController
public class InterviewController {
	@Autowired
	InterviewService interviewService;

	@RequestMapping("/interview")
    public String index() {
        return "Welcome to Interview Dashboard";
    }
	
	@PostMapping("/interview/create")
    public Interview create(@RequestBody Map<String, String> body){        
		String interviewName = body.get("interviewName");
		String usersSkills = body.get("usersSkills");
		String time = body.get("time");
		String date = body.get("date");
		String interviewStatus = body.get("interviewStatus");
		String remarks = body.get("remarks");
		
    	Interview interview = new Interview(interviewName, usersSkills, time, date, interviewStatus, remarks);
    	return interviewService.addInterview(interview);
    }
	
	//Delete Interview
	@DeleteMapping("/interview/{id}")
	public void delete(@PathVariable String id){
	     int interviewId = Integer.parseInt(id);
	     interviewService.deleteById(interviewId);
	}
		
	//display all interview
	@GetMapping("/interview/all")
	public List<Interview> getAll(){        
	  	return interviewService.getAllInterviews();
	}	
	
	//add new attendee
	@PostMapping("/interview/addattendee")
    public void addattendee(@RequestBody Map<String, String> body){        
		String addattendee = body.get("attendee");
		int interviewid = Integer.parseInt(body.get("interviewid"));
		//System.out.println("user="+addattendee+"interview="+interviewid);
		interviewService.addAttendee(addattendee, interviewid);
    }
	
	//display all attendee
	@GetMapping("/interview/attendee/{id}")
	public String getAllAttendee(@PathVariable String id){        
	  	return interviewService.getAllAttendee(Integer.parseInt(id));
	}	
	
	//delete attendee
	@PostMapping("/interview/deleteattendee")
	public void deleteAttendee(@RequestBody Map<String, String> body){
		String attendee = body.get("attendee");
	    int interviewId = Integer.parseInt(body.get("interviewid"));
	    interviewService.deleteAttendee(attendee, interviewId);
	}   
}
