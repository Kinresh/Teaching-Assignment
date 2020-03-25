package com.abc.model;

import java.util.Date;

public class ScheduleModel {

	private int syID;
	private String name;
	private String year;
	private int active_flag;
	public ScheduleModel() {
		super();
	}
	public ScheduleModel(String name, String year) {
		super();
		this.name = name;
		this.year = year;
	}
	public ScheduleModel(int syID, String name, String year, int active_flag) {
		super();
		this.syID = syID;
		this.name = name;
		this.year = year;
		this.active_flag = active_flag;
	}
	public int getSyID() {
		return syID;
	}
	public String getName() {
		return name;
	}
	public String getYear() {
		return year;
	}
	public int getActive_flag() {
		return active_flag;
	}
	
	

}
