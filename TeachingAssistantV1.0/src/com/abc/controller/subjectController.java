package com.abc.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.dao.dao;
import com.abc.daoImpl.daoImpl;
import com.abc.model.ProgramModel;
import com.abc.model.SubjectModel;

public class subjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public subjectController() {
		super();
	}

	private String page;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String q = request.getParameter("q");
		dao d = new daoImpl();
		int userid = 0, id = 0;
		boolean b = false;
		switch (q) {
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
			String ids = request.getParameter("ids");
			String h[] = ids.split(",");
			for (int c = 0; c < h.length; c++) {
				b = d.deleteSubject(Integer.parseInt(h[c]));
				if (!b)
					break;
			}
			if (b) {
				response.sendRedirect("forward?q=displayallsubjects");
			} else {
				response.sendRedirect("error.jsp");
			}
			break;
		case "deleteprogram":
			id = Integer.parseInt(request.getParameter("id"));
			b = d.deleteProgram(id);
			if (b) {
				response.sendRedirect("forward?q=displayallprograms");
			} else {
				response.sendRedirect("error.jsp");
			}
			break;
		case "enableprogram":
			id = Integer.parseInt(request.getParameter("id"));
			b = d.enableProgram(id);
			if (b) {
				response.sendRedirect("forward?q=displayallprograms");
			} else {
				response.sendRedirect("error.jsp");
			}
			break;
		case "disableprogram":
			id = Integer.parseInt(request.getParameter("id"));
			b = d.disableProgram(id);
			if (b) {
				response.sendRedirect("forward?q=displayallprograms");
			} else {
				response.sendRedirect("error.jsp");
			}
			break;
		case "multipledeleteprograms":
			ids = request.getParameter("ids");
			h = ids.split(",");
			for (int c = 0; c < h.length; c++) {
				b = d.deleteProgram(Integer.parseInt(h[c]));
				if (!b)
					break;
			}
			if (b) {
				response.sendRedirect("forward?q=displayallprograms");
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

		String q = request.getParameter("q");
		dao d = new daoImpl();
		// int userid=0;
		boolean b = false;
		switch (q) {
		case "addnewsubject":
			String subjectCode = request.getParameter("subjectCode");
			String subjectName = request.getParameter("subjectName");
			String subjectDescription = request.getParameter("subjectDescription");
			int maxInstructor = Integer.parseInt(request.getParameter("maxInstructor"));
			SubjectModel subject = new SubjectModel(subjectCode, subjectName, subjectDescription, maxInstructor);
			subject.setCreatedDate(new Date());
			HttpSession ses = request.getSession(true);
			if (ses != null) {
				subject.setCreatedBy(ses.getAttribute("name").toString());
			}
			b = d.inserNewSubject(subject);
			if (b) {
				page = "forward?q=displayallsubjects";
			} else {
				page = "error.jsp";
			}
			break;
		case "updatesubject":
			int id = Integer.parseInt(request.getParameter("subjectID"));
			subjectCode = request.getParameter("subjectCode");
			subjectName = request.getParameter("subjectName");
			subjectDescription = request.getParameter("subjectDescription");
			maxInstructor = Integer.parseInt(request.getParameter("maxInstructor"));
			subject = new SubjectModel(id, subjectCode, subjectName, subjectDescription, maxInstructor);
			subject.setUpdatedDate(new Date());
			ses = request.getSession(true);
			if (ses != null) {
				subject.setUpdatedBy(ses.getAttribute("name").toString());
			}
			b = d.updateSubject(subject);
			if (b) {
				page = "forward?q=displayallsubjects";
			} else {
				page = "error.jsp";
			}
			break;
		case "addnewprogram":
			String programName = request.getParameter("programName");
			int totalTerms = Integer.parseInt(request.getParameter("totalTerms"));
			String offeredTerms[] = request.getParameterValues("offeredterm");

			ProgramModel program = new ProgramModel(programName, totalTerms, 0, 0, 0);
			for (String s : offeredTerms) {
				System.out.println("sssssssss: "+s);
				if (s.equals("winter")) {
					program.setWinter(1);
				}
				if (s.equals("summer")) {
					program.setSummer(1);
				}
				if (s.equals("fall")) {
					program.setFall(1);
				}
			}
			program.setCreatedDate(new Date());
			ses = request.getSession(true);
			if (ses != null) {
				program.setCreatedBy(ses.getAttribute("name").toString());
			}
			b = d.inserNewProgram(program);
			if (b) {
				page = "forward?q=displayallprograms";
			} else {
				page = "error.jsp";
			}
			break;
		case "updateprogram":

			id = Integer.parseInt(request.getParameter("programID"));
			programName = request.getParameter("programName");
			totalTerms = Integer.parseInt(request.getParameter("totalTerms"));
			offeredTerms = request.getParameterValues("offeredterm");

			program = new ProgramModel(id,programName, totalTerms, 0, 0, 0);
			for (String s : offeredTerms) {
				if (s.equals("winter")) {
					program.setWinter(1);
				}
				if (s.equals("summer")) {
					program.setSummer(1);
				}
				if (s.equals("fall")) {
					program.setFall(1);
				}
			}
			program.setUpdatedDate(new Date());
			ses = request.getSession(true);
			if (ses != null) {
				program.setUpdatedBy(ses.getAttribute("name").toString());
			}
			b = d.updateProgram(program);
			if (b) {
				page = "forward?q=displayallprograms";
			} else {
				page = "error.jsp";
			}
			break;

		default:
			break;
		}
		response.sendRedirect(page);
	}

}
