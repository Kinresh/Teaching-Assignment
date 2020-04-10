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

import org.apache.coyote.Request;

import com.abc.dao.dao;
import com.abc.daoImpl.daoImpl;
import com.abc.model.FacultySelectionDisplayModel;
import com.abc.model.FacultySelectionModel;
import com.abc.model.PriorityModel;
import com.abc.model.ProgramModel;
import com.abc.model.ProgramTimelineModel;
import com.abc.model.ScheduleModel;
import com.abc.model.SubjectModel;
import com.abc.model.SubjectTermModel;
import com.abc.model.TermModel;
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
		try{
			
		String q = request.getParameter("q");
		dao d = new daoImpl();
		int userid=0,id=0;
		switch (q) {
		case "displayallusers":
			// get all users
			HttpSession ses = request.getSession(true);
			if (ses != null) {
				if(ses.getAttribute("role").toString().equals("admin"))
				{
					List<UserDetailsModel> users = new ArrayList();
					users = d.getAllUsers();
					request.setAttribute("users", users);
					page = "home.jsp?p=DisplayAllUsers";
				}
				else
				{
					page = "home";
				}
			}
			
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
			//get the program
			id = Integer.parseInt(request.getParameter("id"));
			ProgramModel program = d.getProgram(id);
			request.setAttribute("program", program);
			page = "home.jsp?p=UpdateProgram";
			break;
		case "addnewprogram":
			page = "home.jsp?p=AddNewProgram";
			break;
			
		case "displayallprogramtimelines":
			List<ProgramTimelineModel> pts = d.getAllProgramTimelines();
			request.setAttribute("pts", pts);
			programs = d.getAllPrograms();
			request.setAttribute("programs", programs);
			page = "home.jsp?p=DisplayProgramTimelines";
			break;

		case "updateprogramtimeline":
			//get the subject
			id = Integer.parseInt(request.getParameter("id"));
			ProgramTimelineModel pt = d.getProgramTimeline(id);
			programs = d.getAllPrograms();
			request.setAttribute("programs", programs);
			request.setAttribute("pt", pt);
			page = "home.jsp?p=UpdateProgramTimeline";
			break;
		case "addnewprogramtimeline":
			programs = d.getAllPrograms();
			request.setAttribute("programs", programs);
			page = "home.jsp?p=AddNewProgramTimeline";
			break;
		case "addnewschedule":
			page = "home.jsp?p=AddNewSchedule";
			break;
		case "addnewinputform":
			List<ScheduleModel> schedules = d.getAllSchedules(); 
			request.setAttribute("schedules", schedules);
			subjects = d.getAllSubjects();
			request.setAttribute("subjects", subjects);
			List<TermModel> terms = d.getAllTerms();
			request.setAttribute("terms", terms);
			page = "home.jsp?p=AddNewInputForm";
			break;
		case "displayallschedules":
			String intent = request.getParameter("in");
			if (intent.equals("if")) {
				page = "home.jsp?p=DisplayAllSchedules";
			}
			else if(intent.equals("fs")){
				page = "home.jsp?p=DisplayAllSchedulesForFS";
			}
			schedules = d.getAllSchedules();
			request.setAttribute("schedules", schedules);
			break;
		case "displayinputform":
			int scheduleID = Integer.parseInt(request.getParameter("scheduleID"));
			request.setAttribute("syID", scheduleID);
			String scheduleName = d.getScheduleName(scheduleID);
			request.setAttribute("scheduleName", scheduleName);
			List<SubjectTermModel> stms = d.getSubjectTerms_scheduleID(scheduleID);
			request.setAttribute("stms", stms);
			subjects = d.getAllSubjects();
			request.setAttribute("subjects", subjects);
			terms = d.getAllTerms();
			request.setAttribute("terms", terms);
			List<PriorityModel> priorities = d.getAllPriorities();
			request.setAttribute("priorities", priorities);
			page = "home.jsp?p=DisplayInputForm";
			
			break;
			
		case "displayallfacultyselections":
			scheduleID = Integer.parseInt(request.getParameter("scheduleID"));
			request.setAttribute("syID", scheduleID);
			scheduleName = d.getScheduleName(scheduleID);
			request.setAttribute("scheduleName", scheduleName);
			List<FacultySelectionDisplayModel> fs = d.getAllFacultySelection_scheduleID(scheduleID);
			request.setAttribute("fs", fs);
			terms = d.getAllTerms();
			request.setAttribute("terms", terms);
			page = "home.jsp?p=DisplayFacultySelection";

			break;
		default:
			break;
		}

		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
		
		} catch (Exception e) {
			System.out.println(e);
			response.sendRedirect("home");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
