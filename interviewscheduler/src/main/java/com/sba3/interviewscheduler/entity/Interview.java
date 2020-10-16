package com.sba3.interviewscheduler.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "interview")
public class Interview {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "interview_id")
	private int interviewid;
	
	@NotNull
	@Length(min=5,max=30)
	@Column(name = "interviewer_name")
	private String interviewerName;
	
	@NotNull
	@Length(min=3,max=30)
	@Column(name = "interview_name")
	private String interviewName;
	
	@NotNull
	@Length(min=5,max=30)
	@Column(name = "users_skills")
	private String usersSkills;
	
	@Column(name = "time")
	private String time;
	
	@Column(name = "date")
	private String date;
	
	@NotNull
	@Length(min=5,max=100)
	@Column(name = "interview_status")
	private String interviewStatus;
	
	@NotNull
	@Length(min=5,max=100)
	@Column(name = "remarks")
	private String remarks;
	
	@Column(name = "attendee")
	private String attendee;
	
	public Interview() {

		// TODO Auto-generated constructor stub
	}
	
	public Interview(String interviewName, String usersSkills, String time, String date,
			String intervsiewStatus, String remarks) {
		this.interviewName = interviewName;
		this.usersSkills = usersSkills;
		this.time = time;
		this.date = date;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
	}
	
	public Interview(int interviewId, String interviewName, String usersSkills, String time, String date,
			String interviewStatus, String remarks, String attendee) {
		this.interviewid = interviewid;
		this.interviewName = interviewName;
		this.usersSkills = usersSkills;
		this.time = time;
		this.date = date;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
		this.attendee = attendee;
	}
	
	public int getInterviewId() {
		return interviewid;
	}
	public void setInterviewId(int interviewId) {
		this.interviewid = interviewId;
	}
	public String getInterviewName() {
		return interviewName;
	}
	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}
	public String getUsersSkills() {
		return usersSkills;
	}
	public void setUsersSkills(String usersSkills) {
		this.usersSkills = usersSkills;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getInterviewStatus() {
		return interviewStatus;
	}
	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getAttendee() {
		return attendee;
	}

	public void setAttendee(String attendee) {
		this.attendee = attendee;
	}

	
}
