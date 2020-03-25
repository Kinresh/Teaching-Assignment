package com.abc.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProgramTimelineModel implements Serializable {

	SimpleDateFormat sx = new SimpleDateFormat("yyyy-MM-dd");
	
	private int ptID;
	private int programID;
	private String startingTerm;
	private String startingYear;
	private int active_flag;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	public ProgramTimelineModel() {
		super();
	}
	public ProgramTimelineModel(int programID, String startingTerm, String startingYear) {
		super();
		this.programID = programID;
		this.startingTerm = startingTerm;
		this.startingYear = startingYear;
	}
	public ProgramTimelineModel(int ptID, int programID, String startingTerm, String startingYear) {
		super();
		this.ptID = ptID;
		this.programID = programID;
		this.startingTerm = startingTerm;
		this.startingYear = startingYear;
	}
	public ProgramTimelineModel(int ptID, int programID, String startingTerm, String startingYear, int active_flag,
			String createdBy, Date createdDate, String updatedBy, Date updatedDate) {
		super();
		this.ptID = ptID;
		this.programID = programID;
		this.startingTerm = startingTerm;
		this.startingYear = startingYear;
		this.active_flag = active_flag;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}
	public int getPtID() {
		return ptID;
	}
	public int getProgramID() {
		return programID;
	}
	public String getStartingTerm() {
		return startingTerm;
	}
	public String getStartingYear() {
		return startingYear;
	}
	public int getActive_flag() {
		return active_flag;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public Date getCreatedDate() {
		java.sql.Date d = new java.sql.Date(createdDate.getTime());
		return d;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public Date getUpdatedDate() {
		java.sql.Date d = new java.sql.Date(updatedDate.getTime());
		return d;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	
}
