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
import com.abc.model.countryModel;
import com.abc.model.hobbieModel;
import com.abc.model.userModel;

public class fileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//papa.php
	public fileController() {
		super();

	}

	private String h = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<userModel> l = null;
		short a = Short.parseShort(request.getParameter("a"));
		//System.out.println("This is Case a in filecontroller get::"+a);
		dao d = new daoImpl();
		switch (a) {
		case 0:
			List<countryModel> l11 = d.disc();
			request.setAttribute("kin", l11);

			List<hobbieModel> l22 = d.dish();
			request.setAttribute("list2", l22);

			h = "home.jsp";

			break;
		
		case 40:
			h = "login.jsp";

			break;
		case 56:
			List<countryModel> l1 = d.disc();
			request.setAttribute("kin", l1);

			List<hobbieModel> l2 = d.dish();
			request.setAttribute("list2", l2);

			int id = Integer.parseInt(request.getParameter("id"));
			userModel m = d.dise(id);
			request.setAttribute("li", m);

			List<String> hb = new ArrayList<String>();
			String jn[] = m.getHob().split(",");
			for (int i = 0; i < jn.length; i++) {
				hb.add(jn[i]);
			}
			request.setAttribute("liq",hb);
			h = "formu.jsp";
			break;
		case 1:
			l1 = d.disc();
			request.setAttribute("kin", l1);

			l2 = d.dish();
			request.setAttribute("list2", l2);

			h = "home.jsp?p=form";

			break;
		case 2:
			List<hobbieModel> l3 = d.dish();
			request.setAttribute("list2", l3);

			h = "triji.jsp";
			break;
		case 5:
			h = "home.jsp?p=country";
			break;
		case 6:
			h = "home.jsp?p=hobbie";
			break;
		case 3:
			//view all users
			l = d.dis();
			request.setAttribute("list", l);
			h = "home.jsp?p=view";
			break;
		case 4:
			//view only active users
			l = d.diss();
			request.setAttribute("list", l);
			h = "home.jsp?p=eview";
			break;
		case 101:
			h = "UserLogin.jsp";
			break;
		default:
			break;
		}

		RequestDispatcher rd1 = request.getRequestDispatcher(h);
		rd1.forward(request, response);

	}

}
