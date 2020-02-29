package com.abc.model;

import java.io.Serializable;

public class masterModel implements Serializable {
	
	private int mid;
	private String fname; 
	private long number;
	private String gender;
	public masterModel(String fname, long number, String gender) {
		super();
		this.fname = fname;
		this.number = number;
		this.gender = gender;
	}
	public int getId() {
		return mid;
	}
	public String getFname() {
		return fname;
	}
	public long getNumber() {
		return number;
	}
	public String getGender() {
		return gender;
	}
	
	

}
