package com.abc.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProgramModel implements Serializable {

	SimpleDateFormat sx = new SimpleDateFormat("yyyy-MM-dd");
	
	private int programID;
	private String programName;
	private int totalTerms;
	private int winter;
	private int summer;
	private int fall;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	private int active_flag;
	public ProgramModel() {
		super();
	}
	public ProgramModel(int programID, String programName, int totalTerms, int winter, int summer, int fall,
			String createdBy, Date createdDate, String updatedBy, Date updatedDate, int active_flag) {
		super();
		this.programID = programID;
		this.programName = programName;
		this.totalTerms = totalTerms;
		this.winter = winter;
		this.summer = summer;
		this.fall = fall;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.active_flag = active_flag;
	}
	
	public ProgramModel(String programName, int totalTerms, int winter, int summer, int fall) {
		super();
		this.programName = programName;
		this.totalTerms = totalTerms;
		this.winter = winter;
		this.summer = summer;
		this.fall = fall;
	}
	public ProgramModel(int id, String programName, int totalTerms, int winter, int summer, int fall) {
		super();
		this.programID = id;
		this.programName = programName;
		this.totalTerms = totalTerms;
		this.winter = winter;
		this.summer = summer;
		this.fall = fall;
	}
	public ProgramModel(String programName, int totalTerms) {
		super();
		this.programName = programName;
		this.totalTerms = totalTerms;
	}
	public int getProgramID() {
		return programID;
	}
	public String getProgramName() {
		return programName;
	}
	public int getTotalTerms() {
		return totalTerms;
	}
	public int getWinter() {
		return winter;
	}
	public int getSummer() {
		return summer;
	}
	public int getFall() {
		return fall;
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
	public int getActive_flag() {
		return active_flag;
	}
	public void setWinter(int winter) {
		this.winter = winter;
	}
	public void setSummer(int summer) {
		this.summer = summer;
	}
	public void setFall(int fall) {
		this.fall = fall;
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
