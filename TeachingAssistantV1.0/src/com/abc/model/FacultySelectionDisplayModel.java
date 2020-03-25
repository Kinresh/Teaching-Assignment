package com.abc.model;

public class FacultySelectionDisplayModel {

	private int stID;
	private int userID;
	private String userName;
	private int subjectID;
	private String subjectName;
	private String subjectCode;
	private int web_termsID;
	private int priorityID;
	private String description;
	public FacultySelectionDisplayModel() {
		super();
	}
	public FacultySelectionDisplayModel(int stID, int userID, String userName, int subjectID, String subjectName,
			String subjectCode, int web_termsID, int priorityID, String description) {
		super();
		this.stID = stID;
		this.userID = userID;
		this.userName = userName;
		this.subjectID = subjectID;
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.web_termsID = web_termsID;
		this.priorityID = priorityID;
		this.description = description;
	}
	public int getStID() {
		return stID;
	}
	public int getUserID() {
		return userID;
	}
	public String getUserName() {
		return userName;
	}
	public int getSubjectID() {
		return subjectID;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public int getWeb_termsID() {
		return web_termsID;
	}
	public int getPriorityID() {
		return priorityID;
	}
	public String getDescription() {
		return description;
	}

	
	
		
}
