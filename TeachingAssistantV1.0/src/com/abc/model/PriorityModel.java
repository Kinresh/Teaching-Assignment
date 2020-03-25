package com.abc.model;

public class PriorityModel {

	private int priorityID;
	private String description;
	private int active_flag;
	public PriorityModel() {
		super();
	}
	public PriorityModel(int priorityID, String description, int active_flag) {
		super();
		this.priorityID = priorityID;
		this.description = description;
		this.active_flag = active_flag;
	}
	public int getPriorityID() {
		return priorityID;
	}
	public String getDescription() {
		return description;
	}
	public int getActive_flag() {
		return active_flag;
	}
	
}
