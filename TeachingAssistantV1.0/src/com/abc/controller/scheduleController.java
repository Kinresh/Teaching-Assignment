package com.abc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.dao.dao;
import com.abc.daoImpl.daoImpl;
import com.abc.model.FacultySelectionModel;
import com.abc.model.ScheduleModel;
import com.abc.model.SubjectTermModel;


public class scheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String page="";

    public scheduleController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q = request.getParameter("q");
		switch (q) {

		default:
			break;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			
		String q = request.getParameter("q");
		dao d = new daoImpl();
		boolean b= false;
		switch (q) {
		case "addnewschedule":
			String scheduleName = request.getParameter("scheduleName");
			String year = request.getParameter("year");
			ScheduleModel s = new ScheduleModel(scheduleName,year);
			b = d.addSchedule(s);
			if (b) {
				page = "forward?q=displayallschedules&in=if";
			} else {
				page = "home";
			}
			break;
		case "addnewinputform":
			int subjectID=0,web_termsID=0;
			String note="";
			String[] splitresult = new String[5];
			SubjectTermModel stm = new SubjectTermModel();
			int scheduleID = Integer.parseInt(request.getParameter("schedule"));
			d.emptySchedule(scheduleID);
			String[] selection = request.getParameterValues("selection");
			for (int i = 0; i < selection.length; i++) {
				if (selection[i]!=null && !selection[i].equals("")) {
					note = request.getParameter("notes"+selection[i]);
					splitresult = selection[i].split(",");
					subjectID = Integer.parseInt(splitresult[0]);
					web_termsID = Integer.parseInt(splitresult[1]);
					stm = new SubjectTermModel(subjectID,web_termsID,scheduleID,note);
					b = d.addSubjectTerm(stm);
					if (!b) {
						page = "home";
						break;
					}
				}				
			}
			page = "forward?q=displayallschedules&in=if";
			break;

		case "facultyselection":
			
			FacultySelectionModel fs = null;
			int userID=0,stID=0;
			HttpSession ses = request.getSession(true);
			if (ses != null) {
				userID = Integer.parseInt(ses.getAttribute("id").toString());
			}
			int syID = Integer.parseInt(request.getParameter("syID"));
			selection = request.getParameterValues("selection");
			int priorityID = 0;
			b=d.deleteFacultySelection(userID);
			for (int i = 0; i < selection.length; i++) {
				//System.out.println(selection[i]);
				if (selection[i]!=null && !selection[i].equals("")) {
					priorityID = Integer.parseInt(request.getParameter("priority"+selection[i]));
					stID = Integer.parseInt(selection[i]);
					fs = new FacultySelectionModel(userID, syID,stID,priorityID);
					
					b = d.addNewFacultySelection(fs);
					if (!b) {
						page = "home";
						break;
					}
				}
			}
			page = "forward?q=displayallfacultyselections&scheduleID="+syID;
			break;
			
		default:
			break;
		}
		response.sendRedirect(page);
		
		} catch (Exception e) {
			System.out.println(e);
			response.sendRedirect("home");
		}
	}

}
