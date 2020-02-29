package com.abc.model;

import java.io.Serializable;

public class countryModel implements Serializable 
{
	private int cid;
	private String cname;
	public int getCid() {
		return cid;
	}
	public String getCname() {
		return cname;
	}
	public countryModel(String cname) {
		super();
		this.cname = cname;
	}
	public countryModel(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public countryModel() {
		super();
	} 
	
	

}
