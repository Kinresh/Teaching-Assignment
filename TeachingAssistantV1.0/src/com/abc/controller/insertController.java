package com.abc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.dao.dao;
import com.abc.daoImpl.daoImpl;
import com.abc.model.childModel;
import com.abc.model.countryModel;
import com.abc.model.hobbieModel;
import com.abc.model.masterModel;
import com.abc.model.userModel;


public class insertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public insertController() {
        super();
        
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			
		int a =Integer.parseInt(request.getParameter("a"));
		//System.out.println("This is Case a in insertcontroller get::"+a);
		dao d=new daoImpl();
		boolean b = false;
		int counter=-1;
		int id = 0;
		switch (a) {
		case 4:
			String array12 = request.getParameter("b");
			String h[] = array12.split(",");
			//System.out.println("ddd=="+h.length);
			for(int c=0 ; c<h.length ; c++)
			{
				b=d.delete(Integer.parseInt(h[c]));
				
			}
			if(b)
			{
				response.sendRedirect("papa.php?a=3");
			}
			else{
				response.sendRedirect("home");
			}
			break;
		case 1:
			id = Integer.parseInt(request.getParameter("id"));
			b =  d.delete(id);
			if(b)
			{
				response.sendRedirect("papa.php?a=3");
			}
			else{
				response.sendRedirect("home");
			}
			break;
		case 2:
			id = Integer.parseInt(request.getParameter("id"));
			b =  d.deleted(id);
			if(b)
			{
				response.sendRedirect("papa.php?a=4");
			}
			else{
				response.sendRedirect("home");
			}
			break;
		case 3:
			id = Integer.parseInt(request.getParameter("id"));
			b =  d.deletee(id);
			if(b)
			{
				response.sendRedirect("papa.php?a=3");
			}
			else{
				response.sendRedirect("home");
			}
			break;
		case 61:
			HttpSession session=request.getSession();
			session.invalidate();
			HttpSession ses=request.getSession();
			
			ses.setAttribute("msg","Successfully Logged Out");
			response.sendRedirect("register.php?q=login");
			
			break;
		default:
			break;
		}
		}
		catch (Exception e) {
			System.out.println(e);
			response.sendRedirect("error.jsp");
		}
		
    }
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
		
		HttpSession ses = request.getSession();
		String a = request.getParameter("action");
		//System.out.println("This is action in insertcontroller post::"+a);
		SimpleDateFormat vf = new SimpleDateFormat("yyyy-MM-dd");
		dao d=new daoImpl();
		boolean b = false;
		switch (a) {

		case "hb":
			String hname = request.getParameter("hname");
			hobbieModel h= new hobbieModel(hname);
			b = d.insert(h);
			if(b==true)
			{
				response.sendRedirect("success.jsp");
			}
			else{
				response.sendRedirect("error.jsp");
			}
			break;
		
		case "fg":
			String cname = request.getParameter("cname");
			countryModel c = new countryModel(cname);
			b = d.insert(c);
			if(b==false)
			{
				response.sendRedirect("success.jsp");
			}
			else{
				response.sendRedirect("error.jsp");
			}
			break;
		
		case "a":
			String fname = request.getParameter("fname");
			Date bdate = vf.parse(request.getParameter("bdate"));
			
			//System.out.println("kinreshpatel after parse=="+bdate);
			
			String gender = request.getParameter("gender");
			long number = Long.parseLong(request.getParameter("number"));
			String hob[] = request.getParameterValues("hob");
			int cid = Integer.parseInt(request.getParameter("cid"));
			
			String bv = hob[0];
			for (int i = 1; i < hob.length; i++) {
				bv = bv+","+hob[i];
			}
			
			
			userModel m = new userModel(fname, number,bdate,gender,bv,cid);
			
			b = d.insert(m);
			if(b)
			{
				response.sendRedirect("success.jsp");
			}
			else{
				response.sendRedirect("error.jsp");
			}
			break;
		case "uu":
			int id = Integer.parseInt(request.getParameter("hid"));
			 fname = request.getParameter("fname");
			 bdate = vf.parse(request.getParameter("bdate"));
			
			//System.out.println("sdfg=="+bdate);
			
			 gender = request.getParameter("gender");
			 number = Long.parseLong(request.getParameter("number"));
			 hob = request.getParameterValues("hob");
			 cid = Integer.parseInt(request.getParameter("cid"));
			
			 bv = hob[0];
			for (int i = 1; i < hob.length; i++) {
				bv = bv+","+hob[i];
			}
			
			
			 m = new userModel(fname, number,bdate,gender,bv,cid);
			
			b = d.update(m,id);
			if(b)
			{
				response.sendRedirect("papa.php?a=4");
			}
			else{
				response.sendRedirect("error.jsp");
			}
			break;
		case "b":
			 fname = request.getParameter("fname");
			 gender = request.getParameter("gender");
			 number = Long.parseLong(request.getParameter("number"));
			 hob = request.getParameterValues("hob");
			
			for (int i = 0; i < hob.length; i++) {
			
			 m = new userModel(fname, number,gender,hob[i]);
			
			  d.insert(m);
			}
			 
				response.sendRedirect("success.jsp");
			break;
		case "c":
			 fname = request.getParameter("fname");
			 gender = request.getParameter("gender");
			 number = Long.parseLong(request.getParameter("number"));
			 hob = request.getParameterValues("hob");
			
			 masterModel nb = new masterModel(fname, number, gender);
			b = d.insert(nb);
			if(b){ 
			 id = d.getId();
			for (int i = 0; i < hob.length; i++) {
			
		    childModel ch = new childModel(id,hob[i]);
			
			  d.insert(ch);
			}
			response.sendRedirect("papa.php?a=4");
			}
			else{
				response.sendRedirect("error.jsp");
			}
			break;
		case "mdel":
			//System.out.println("mdel");
			String[] abc = request.getParameterValues("abc");
			for (int i = 0; i < abc.length; i++) {
				
			 d.deletee(Integer.parseInt(abc[i]));
			}
			response.sendRedirect("papa.php?a=4");
			break;
			
		case "Login":
			 fname = request.getParameter("fname");
			 number = Long.parseLong(request.getParameter("number"));
			 
			 userModel jn = new userModel(fname, number);
			List l =  d.checkk(jn);
			//System.out.println(l.get(0));
			switch ((String)l.get(0)) {
			case "sa":
				jn = (userModel)l.get(1);
				ses.setAttribute("id",jn.getId());
				ses.setAttribute("name",jn.getFname());
				response.sendRedirect("papa.php?a=0");
				break;
			case "wa":
				ses.setAttribute("msg","You are Unauthorized by admin to login!!");
				
				response.sendRedirect("papa.php?a=40");
				break;
			case "wp":
				ses.setAttribute("msg","Incorrect Password!!");
				
				response.sendRedirect("papa.php?a=40");
				break;
			case "wu":
				ses.setAttribute("msg","Incorrect Username!!");
				
				response.sendRedirect("papa.php?a=40");
				break;
                      
			default:
				break;
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

}
