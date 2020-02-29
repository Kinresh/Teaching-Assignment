package com.abc.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class userModel implements Serializable {

	SimpleDateFormat sx = new SimpleDateFormat("yyyy-MM-dd");
	
	private int id;
	private String fname; 
	private long number;
	private String gender;
	private String hob;
	private int cid;
	private Date bdate;
	private byte active_flag;
	
	public int getCid() {
		return cid;
	}



	public userModel(String fname, long number,Date b, String gender, String hob, int cid) {
		super();
		this.fname = fname;
		this.number = number;
		this.gender = gender;
		this.hob = hob;
		this.cid = cid;
		this.bdate = b;
	}



	public userModel(String fname, long number,String gender,String hob) {
		this.fname = fname;
		this.hob = hob;
		this.gender = gender;
		this.number = number;
	}
	
	
	
	public userModel(int id,String fname, long number,String gender,String hob,byte active_flag,int c,String d) {
		this.fname = fname;
		this.hob = hob;
		this.id = id;
		this.gender = gender;
		this.number = number;
		this.active_flag = active_flag;
		this.cid = c;
		try
		{
		this.bdate = sx.parse(d);
		}
		catch (ParseException e) {
			System.out.println(e);
		}
		}
		
	
	public userModel(int id, String fname, long number, String gender, String hob) {
		super();
		this.id = id;
		this.fname = fname;
		this.number = number;
		this.gender = gender;
		this.hob = hob;
		
	}



	public userModel(String fname, long number, String gender, String hob, int cid) {
		super();
		this.fname = fname;
		this.number = number;
		this.gender = gender;
		this.hob = hob;
		this.cid = cid;
	}



	public byte getActive_flag() {
		return active_flag;
	}



	public String getHob() {
		return hob;
	}



	public String getGender() {
		return gender;
	}



	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public long getNumber() {
		return number;
	}
	public userModel() {
		super();
	}
	
	public Date getBdate() {
		
		java.sql.Date g = new java.sql.Date(bdate.getTime());
		System.out.println("aa le6 db ma add karva=="+g);
		return g;
	}



	public userModel(String fname, long number) {
		super();
		this.fname = fname;
		this.number = number;
	}



	public userModel(int id, String fname) {
		super();
		this.id = id;
		this.fname = fname;
	}
	
	
}
