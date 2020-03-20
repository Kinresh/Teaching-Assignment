package com.abc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.Request;

import com.abc.dao.dao;
import com.abc.daoImpl.daoImpl;
import com.abc.model.ProgramModel;
import com.abc.model.SubjectModel;
import com.abc.model.UserDetailsModel;

public class forwardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//forward
	public forwardController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String page = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String q = request.getParameter("q");
		dao d = new daoImpl();
		int userid=0,id=0;
		switch (q) {
		case "displayallusers":
			// get all users
			List<UserDetailsModel> users = new ArrayList();
			users = d.getAllUsers();
			request.setAttribute("users", users);
			page = "home.jsp?p=DisplayAllUsers";
			break;
			
		case "updateaccount":
			//get one user
			userid = Integer.parseInt(request.getParameter("userid"));
			UserDetailsModel user = d.getUser(userid);
			request.setAttribute("user", user);
			page = "home.jsp?p=UpdateUser";
			break;
			
		case "displayallsubjects":
			List<SubjectModel> subjects = d.getAllSubjects();
			request.setAttribute("subjects", subjects);
			page = "home.jsp?p=DisplaySubjects";
			break;
		
		case "updatesubject":
			//get the subject
			id = Integer.parseInt(request.getParameter("id"));
			SubjectModel subject = d.getSubject(id);
			request.setAttribute("subject", subject);
			page = "home.jsp?p=UpdateSubject";
			break;
		case "addnewsubject":
			page = "home.jsp?p=AddNewSubject";
			break;
		case "displayallprograms":
			List<ProgramModel> programs = d.getAllPrograms();
			request.setAttribute("programs", programs);
			page = "home.jsp?p=DisplayPrograms";
			break;
		
		case "updateprogram":
			//get the subject
			id = Integer.parseInt(request.getParameter("id"));
			ProgramModel program = d.getProgram(id);
			request.setAttribute("program", program);
			page = "home.jsp?p=UpdateProgram";
			break;
		case "addnewprogram":
			page = "home.jsp?p=AddNewProgram";
			break;

		default:
			break;
		}

		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
