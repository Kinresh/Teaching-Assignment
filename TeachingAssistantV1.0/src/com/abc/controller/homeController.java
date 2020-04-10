package com.abc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dao.dao;
import com.abc.daoImpl.daoImpl;
import com.abc.model.countryModel;
import com.abc.model.hobbieModel;

public class homeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String h="";
    public homeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		dao d = new daoImpl();
		List<countryModel> l11 = d.disc();
		request.setAttribute("kin", l11);

		List<hobbieModel> l22 = d.dish();
		request.setAttribute("list2", l22);

		h="home.jsp";
		
		RequestDispatcher rd1 = request.getRequestDispatcher(h);
		rd1.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
