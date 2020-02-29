package com.abc.model;

import java.io.Serializable;

public class hobbieModel implements Serializable{

	private int hid;
	private String hname;
	
	public hobbieModel(int hid, String hname) {
		super();
		this.hid = hid;
		this.hname = hname;
	}
	public int getHid() {
		return hid;
	}
	public String getHname() {
		return hname;
	}
	public hobbieModel(String hname) {
		super();
		this.hname = hname;
	}
	public hobbieModel() {
		super();
	}
	
	
}
