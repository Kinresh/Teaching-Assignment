package com.abc.model;

public class FacultySelectionModel {

	private int fsID;
	private int userID;
	private int syID;
	private int stID;
	private int priorityID;
	public FacultySelectionModel() {
		super();
	}
	public FacultySelectionModel(int userID, int syID, int stID, int priorityID) {
		super();
		this.userID = userID;
		this.syID = syID;
		this.stID = stID;
		this.priorityID = priorityID;
	}
	public FacultySelectionModel(int fsID, int userID, int syID, int stID, int priorityID) {
		super();
		this.fsID = fsID;
		this.userID = userID;
		this.syID = syID;
		this.stID = stID;
		this.priorityID = priorityID;
	}
	public int getFsID() {
		return fsID;
	}
	public int getUserID() {
		return userID;
	}
	public int getSyID() {
		return syID;
	}
	public int getStID() {
		return stID;
	}
	public int getPriorityID() {
		return priorityID;
	}
	
}
