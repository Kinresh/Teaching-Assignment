package com.abc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dao.dao;
import com.abc.daoImpl.daoImpl;
import com.abc.model.UserDetailsModel;

public class actionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//action
	public actionController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String q = request.getParameter("q");
		dao d = new daoImpl();
		int userid=0,id=0;
		boolean b = false;
		switch (q) {
		case "deleteaccount":
			userid = Integer.parseInt(request.getParameter("userid"));
			b = d.deleteAccount(userid);
			if (b) {
				response.sendRedirect("forward?q=displayallusers");
			} else {
				response.sendRedirect("error.jsp");
			}
			break;
		case "enableaccount":
			userid = Integer.parseInt(request.getParameter("userid"));
			b = d.enableAccount(userid);
			if (b) {
				response.sendRedirect("forward?q=displayallusers");
			} else {
				response.sendRedirect("error.jsp");
			}
			break;
		case "disableaccount":
			userid = Integer.parseInt(request.getParameter("userid"));
			b = d.disableAccount(userid);
			if (b) {
				response.sendRedirect("forward?q=displayallusers");
			} else {
				response.sendRedirect("error.jsp");
			}
			break;
		case "multipledeleteaccounts":
			String ids = request.getParameter("ids");
			String h[] = ids.split(",");
			for(int c=0 ; c<h.length ; c++)
			{
				b=d.deleteAccount(Integer.parseInt(h[c]));
				if(!b)
					break;
			}
			if (b) {
				response.sendRedirect("forward?q=displayallusers");
			} else {
				response.sendRedirect("error.jsp");
			}
			break;
		case "deletesubject":
			id = Integer.parseInt(request.getParameter("id"));
			b = d.deleteSubject(id);
			if (b) {
				response.sendRedirect("forward?q=displayallsubjects");
			} else {
				response.sendRedirect("error.jsp");
			}
			break;
		case "enablesubject":
			id = Integer.parseInt(request.getParameter("id"));
			b = d.enableSubject(id);
			if (b) {
				response.sendRedirect("forward?q=displayallsubjects");
			} else {
				response.sendRedirect("error.jsp");
			}
			break;
		case "disablesubject":
			id = Integer.parseInt(request.getParameter("id"));
			b = d.disableSubject(id);
			if (b) {
				response.sendRedirect("forward?q=displayallsubjects");
			} else {
				response.sendRedirect("error.jsp");
			}
			break;
		case "multipledeletesubjects":
			ids = request.getParameter("ids");
			h = ids.split(",");
			for(int c=0 ; c<h.length ; c++)
			{
				b=d.deleteSubject(Integer.parseInt(h[c]));
				if(!b)
					break;
			}
			if (b) {
				response.sendRedirect("forward?q=displayallsubjects");
			} else {
				response.sendRedirect("error.jsp");
			}
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

}
