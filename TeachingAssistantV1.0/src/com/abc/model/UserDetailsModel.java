package com.abc.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDetailsModel implements Serializable {

	SimpleDateFormat sx = new SimpleDateFormat("yyyy-MM-dd");

	private int userID;
	private String userName;
	private String userEmail;
	private String userPassword;
	private Date userDob;
	private String userContact;
	private String userRole;
	private byte active;
	private String userCountry;
	private String userAddress;
	private Date lastUpdated;
	private String updatedBy;
	private Date createdDate;
	private String createdBy;
	private String userDepartment;
	private String gender;

	public UserDetailsModel() {
		super();
	}

	public UserDetailsModel(String userName, String userEmail, String userPassword, String userContact,
			String userCountry, String gender) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userContact = userContact;
		this.userCountry = userCountry;
		this.gender = gender;
	}

	public UserDetailsModel(int userID, String userName, String userEmail, String userPassword, Date userDob,
			String userContact, String userRole, byte active, String userCountry, String userAddress, Date lastUpdated,
			String updatedBy, Date createdDate, String createdBy, String userDepartment, String gender) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userDob = userDob;
		this.userContact = userContact;
		this.userRole = userRole;
		this.active = active;
		this.userCountry = userCountry;
		this.userAddress = userAddress;
		this.lastUpdated = lastUpdated;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.userDepartment = userDepartment;
		this.gender = gender;
	}

	public UserDetailsModel(String username, String password) {
		this.userName = username;
		this.userPassword = password;
	}

	public UserDetailsModel(int id, String name, String email, String role) {
		this.userID = id;
		this.userName = name;
		this.userEmail = email;
		this.userRole = role;
	}

	public UserDetailsModel(int id, String name, String email, String contact, String role) {
		
		this.userID = id;
		this.userName = name;
		this.userEmail = email;
		this.userContact = contact;
		this.userRole = role;
	}

	public int getUserID() {
		return userID;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public Date getUserDob() {
		return userDob;
	}

	public String getUserContact() {
		return userContact;
	}

	public String getUserRole() {
		return userRole;
	}

	public byte getActive() {
		return active;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public Date getLastUpdated() {
		java.sql.Date d = new java.sql.Date(lastUpdated.getTime());
		return d;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public Date getCreatedDate() {
		java.sql.Date d = new java.sql.Date(createdDate.getTime());
		return d;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getUserDepartment() {
		return userDepartment;
	}

	public String getGender() {
		return gender;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
