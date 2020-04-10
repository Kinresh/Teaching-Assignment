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
import com.abc.model.*;

public class subjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public subjectController() {
		super();
	}

	private String page;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

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
					response.sendRedirect("home");
				}
				break;
			case "enablesubject":
				id = Integer.parseInt(request.getParameter("id"));
				b = d.enableSubject(id);
				if (b) {
					response.sendRedirect("forward?q=displayallsubjects");
				} else {
					response.sendRedirect("home");
				}
				break;
			case "disablesubject":
				id = Integer.parseInt(request.getParameter("id"));
				b = d.disableSubject(id);
				if (b) {
					response.sendRedirect("forward?q=displayallsubjects");
				} else {
					response.sendRedirect("home");
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
					response.sendRedirect("home");
				}
				break;
			case "deleteprogram":
				id = Integer.parseInt(request.getParameter("id"));
				b = d.deleteProgram(id);
				if (b) {
					response.sendRedirect("forward?q=displayallprograms");
				} else {
					response.sendRedirect("home");
				}
				break;
			case "enableprogram":
				id = Integer.parseInt(request.getParameter("id"));
				b = d.enableProgram(id);
				if (b) {
					response.sendRedirect("forward?q=displayallprograms");
				} else {
					response.sendRedirect("home");
				}
				break;
			case "disableprogram":
				id = Integer.parseInt(request.getParameter("id"));
				b = d.disableProgram(id);
				if (b) {
					response.sendRedirect("forward?q=displayallprograms");
				} else {
					response.sendRedirect("home");
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
					response.sendRedirect("home");
				}
				break;
			case "deleteprogramtimeline":
				id = Integer.parseInt(request.getParameter("id"));
				b = d.deleteProgramTimeline(id);
				if (b) {
					response.sendRedirect("forward?q=displayallprogramtimelines");
				} else {
					response.sendRedirect("home");
				}
				break;
			case "enableprogramtimeline":
				id = Integer.parseInt(request.getParameter("id"));
				b = d.enableProgramTimeline(id);
				if (b) {
					response.sendRedirect("forward?q=displayallprogramtimelines");
				} else {
					response.sendRedirect("home");
				}
				break;
			case "disableprogramtimeline":
				id = Integer.parseInt(request.getParameter("id"));
				b = d.disableProgramTimeline(id);
				if (b) {
					response.sendRedirect("forward?q=displayallprogramtimelines");
				} else {
					response.sendRedirect("home");
				}
				break;
			case "multipledeleteprogramtimelines":
				ids = request.getParameter("ids");
				h = ids.split(",");
				for (int c = 0; c < h.length; c++) {
					b = d.deleteProgramTimeline(Integer.parseInt(h[c]));
					if (!b)
						break;
				}
				if (b) {
					response.sendRedirect("forward?q=displayallprogramtimlines");
				} else {
					response.sendRedirect("home");
				}
				break;
			case "programtimelineterms":
				id = Integer.parseInt(request.getParameter("id"));
				// b = d.getTermsFromPtID(id);
				if (b) {
					response.sendRedirect("forward?q=displayallprogramtimelines");
				} else {
					response.sendRedirect("home");
				}
				break;

			default:
				break;
			}

		} catch (Exception e) {
			System.out.println(e);
			response.sendRedirect("home");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

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
					page = "home";
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
					page = "home";
				}
				break;
			case "addnewprogram":
				String programName = request.getParameter("programName");
				int totalTerms = Integer.parseInt(request.getParameter("totalTerms"));
				String offeredTerms[] = request.getParameterValues("offeredterm");

				ProgramModel program = new ProgramModel(programName, totalTerms, 0, 0, 0);
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
				program.setCreatedDate(new Date());
				ses = request.getSession(true);
				if (ses != null) {
					program.setCreatedBy(ses.getAttribute("name").toString());
				}
				b = d.inserNewProgram(program);
				if (b) {
					page = "forward?q=displayallprograms";
				} else {
					page = "home";
				}
				break;
			case "updateprogram":

				id = Integer.parseInt(request.getParameter("programID"));
				programName = request.getParameter("programName");
				totalTerms = Integer.parseInt(request.getParameter("totalTerms"));
				offeredTerms = request.getParameterValues("offeredterm");

				program = new ProgramModel(id, programName, totalTerms, 0, 0, 0);
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
					page = "home";
				}
				break;

			case "addnewprogramtimeline":
				int programID = Integer.parseInt(request.getParameter("programID"));
				String startingTerm = request.getParameter("startingTerm");
				String startingYear = request.getParameter("startingYear");

				ProgramTimelineModel pt = new ProgramTimelineModel(programID, startingTerm, startingYear);

				pt.setCreatedDate(new Date());
				ses = request.getSession(true);
				if (ses != null) {
					pt.setCreatedBy(ses.getAttribute("name").toString());
				}
				b = d.inserNewProgramTimeline(pt);
				if (b) {
					page = "forward?q=displayallprogramtimelines";
				} else {
					page = "home";
				}
				break;

			case "updateprogramtimeline":

				int ptID = Integer.parseInt(request.getParameter("ptID"));
				programID = Integer.parseInt(request.getParameter("programID"));
				startingTerm = request.getParameter("startingTerm");
				startingYear = request.getParameter("startingYear");

				pt = new ProgramTimelineModel(ptID, programID, startingTerm, startingYear);

				pt.setUpdatedDate(new Date());
				ses = request.getSession(true);
				if (ses != null) {
					pt.setUpdatedBy(ses.getAttribute("name").toString());
				}
				b = d.updateProgramTimeline(pt);
				if (b) {
					page = "forward?q=displayallprogramtimelines";
				} else {
					page = "home";
				}
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
