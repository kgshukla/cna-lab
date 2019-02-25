package com.example.gateway.model;

public class FreelancersData {
	private String guid;
	private String firstName;
	private String lastName;
	private String skills;
	private String emailId;
	
	public FreelancersData () {}
	
	public FreelancersData(String guid, String firstName, String lastName, String skills, String emailId) {
		super();
		this.guid = guid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.skills = skills;
		this.emailId = emailId;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

}
