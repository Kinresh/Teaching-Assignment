package com.abc.model;

public class SubjectTermModel {
	
	private int stID;
	private int subjectID;
	private int web_termsID;
	private int syID;
	private String notes;
	private int active_flag;
	public SubjectTermModel() {
		super();
	}
	public SubjectTermModel(int subjectID, int web_termsID, int syID, String notes) {
		super();
		this.subjectID = subjectID;
		this.web_termsID = web_termsID;
		this.syID = syID;
		this.notes = notes;
	}
	public SubjectTermModel(int stID, int subjectID, int web_termsID, int syID, String notes, int active_flag) {
		super();
		this.stID = stID;
		this.subjectID = subjectID;
		this.web_termsID = web_termsID;
		this.syID = syID;
		this.notes = notes;
		this.active_flag = active_flag;
	}
	public int getStID() {
		return stID;
	}
	public int getSubjectID() {
		return subjectID;
	}
	public int getWeb_termsID() {
		return web_termsID;
	}
	public int getSyID() {
		return syID;
	}
	public String getNotes() {
		return notes;
	}
	public int getActive_flag() {
		return active_flag;
	}
	
	

}
