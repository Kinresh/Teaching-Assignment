package com.abc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.dao.dao;
import com.abc.daoImpl.daoImpl;
import com.abc.model.UserDetailsModel;
import com.abc.model.userModel;

public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// register.php
	public registerController() {
		super();

	}

	private String page = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String q = request.getParameter("q");
		switch (q) {
		case "signup":
			page = "RegisterUser.jsp";
			break;
		case "login":
			page = "UserLogin.jsp";
			break;
		default:
			break;
		}

		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession ses = request.getSession();
			String q = request.getParameter("q");
			q = (q==null) ? "Login" : q;
			dao d = new daoImpl();
			SimpleDateFormat sx = new SimpleDateFormat("yyyy-MM-dd");
			switch (q) {
			case "SignUp":
				String username = request.getParameter("username");
				String emailID = request.getParameter("emailID");
				String contact = request.getParameter("contact");
				String gender = request.getParameter("gender");
				String country = request.getParameter("country");
				String password = request.getParameter("password");
				String confirmPassword = request.getParameter("confirmPassword");
				if (username == null || emailID == null || contact == null || gender == null || password == null || confirmPassword == null) {
					System.out.println("Data entry problem");
					page="register.php?q=signup";
					break;
				}
				if (!password.equals(confirmPassword)) {
					page="register.php?q=signup";
					break;
				}
				UserDetailsModel userDetails = new UserDetailsModel(username, emailID, password, contact, country,
						gender);
				if (ses.getAttribute("name") == null) {
					userDetails.setCreatedBy("registration");
				} else {
					userDetails.setCreatedBy(ses.getAttribute("name").toString());
				}
				userDetails.setCreatedDate(new Date());
				boolean isSuccess = d.insert(userDetails);
				if (isSuccess) {

					UserDetailsModel u = new UserDetailsModel(username,password);
					List dataList = d.VerifyUser(u);
					u = (UserDetailsModel) dataList.get(1);
					ses.setAttribute("id", u.getUserID());
					ses.setAttribute("name", u.getUserName());
					ses.setAttribute("email", u.getUserEmail());
					ses.setAttribute("role", u.getUserRole());
					page="home";
					//response.sendRedirect("home");								
					// page= "success.jsp";
				} else {
					page="register.php?q=signup";
				}
				
				//response.sendRedirect(page);
				break;

			case "Login":
				username = request.getParameter("username");
				password = request.getParameter("password");

				UserDetailsModel u = new UserDetailsModel(username,password);
				List dataList = d.VerifyUser(u);
				switch ((String) dataList.get(0)) {
				case "success":
					u = (UserDetailsModel) dataList.get(1);
					ses.setAttribute("id", u.getUserID());
					ses.setAttribute("name", u.getUserName());
					ses.setAttribute("email", u.getUserEmail());
					ses.setAttribute("role", u.getUserRole());
					page="home";
					//response.sendRedirect("home");
					break;
				case "unauthorized":
					ses.setAttribute("msg", "You are Unauthorized by admin to login");
					page="register.php?q=login";
					//response.sendRedirect("register.php?q=login");
					break;
				case "nouserfound":
					ses.setAttribute("msg", "Incorrect Username or Password");
					page="register.php?q=login";
					//response.sendRedirect("register.php?q=login");
					break;
				default:
					break;
				}

				break;

			case "updateaccount":
				username = request.getParameter("username");
				emailID = request.getParameter("emailID");
				contact = request.getParameter("contact");
				int userid = Integer.parseInt(request.getParameter("userid"));
				String role = request.getParameter("role");
				
				if (userid==0 | username == null || emailID == null || contact == null || role == null) {
					page = "home.jsp?p=UpdateUser";
					break;
				}
				userDetails = new UserDetailsModel(userid, username, emailID, contact, role);
				if (ses.getAttribute("name") == null) {
					userDetails.setUpdatedBy("registration");
				} else {
					userDetails.setUpdatedBy(ses.getAttribute("name").toString());
				}
				userDetails.setLastUpdated(new Date());
				isSuccess = d.updateUser(userDetails);
				if (isSuccess) {
					page = "forward?q=displayallusers";
				} else {
					page = "error.jsp";
				}
				
				//response.sendRedirect(page);
				break;
				
			default:
				break;
			}
			response.sendRedirect(page);
			// RequestDispatcher r = request.getRequestDispatcher(page);
			// r.forward(request, response);

		} catch (Exception e) {
			response.sendRedirect("register.php?q=login");
			// TODO: handle exception
		}
	}

}
