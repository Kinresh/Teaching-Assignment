package com.abc.model;

public class TermModel {
	
	private int web_termID;
	private String name;
	private int active_flag;
	public TermModel() {
		super();
	}
	public TermModel(String name) {
		super();
		this.name = name;
	}
	public TermModel(int web_termID, String name, int active_flag) {
		super();
		this.web_termID = web_termID;
		this.name = name;
		this.active_flag = active_flag;
	}
	public int getWeb_termID() {
		return web_termID;
	}
	public String getName() {
		return name;
	}
	public int getActive_flag() {
		return active_flag;
	}
	
	

}
