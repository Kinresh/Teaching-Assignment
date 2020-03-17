package com.abc.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SubjectModel implements Serializable {

	SimpleDateFormat sx = new SimpleDateFormat("yyyy-MM-dd");
	
	private int subjectID;
	private String subjectCode;
	private String subjectName;
	private String subjectDescription;
	private int maxInstructor;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	private int active_flag;
	

	public SubjectModel() {
		super();
	}

	public SubjectModel(String subjectCode, String subjectName, String subjectDescription, int maxInstructor) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.subjectDescription = subjectDescription;
		this.maxInstructor = maxInstructor;
	}

	public SubjectModel(int subjectID, String subjectCode, String subjectName, String subjectDescription,
			int maxInstructor) {
		super();
		this.subjectID = subjectID;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.subjectDescription = subjectDescription;
		this.maxInstructor = maxInstructor;
	}

	public SubjectModel(int subjectID, String subjectCode, String subjectName, String subjectDescription,
			int maxInstructor, String createdBy, Date createdDate, String updatedBy, Date updatedDate, int activeFlag) {
		super();
		this.subjectID = subjectID;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.subjectDescription = subjectDescription;
		this.maxInstructor = maxInstructor;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.active_flag = activeFlag;
	}

	public int getSubjectID() {
		return subjectID;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public String getSubjectDescription() {
		return subjectDescription;
	}

	public int getMaxInstructor() {
		return maxInstructor;
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

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public int getActive_flag() {
		return active_flag;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	

}
