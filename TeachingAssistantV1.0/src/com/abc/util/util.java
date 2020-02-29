package com.abc.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class util {

	private Connection con = null;
	
	public Connection getConnection() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");
		}
		catch (ClassNotFoundException e) {
			System.out.println("class ma error 6!!");
			System.out.println(e);
		}
		catch (SQLException e) {
			System.out.println("wrong database!!");
			System.out.println(e);
		}
		return con;
	}
	
}
