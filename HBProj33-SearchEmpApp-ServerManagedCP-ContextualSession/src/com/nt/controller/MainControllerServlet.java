package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;
import com.nt.service.EmployeeServiceFactory;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	private EmployeeService service;
	@Override
	public void init() throws ServletException {
	  service=EmployeeServiceFactory.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 int eno=0;
		 EmployeeDTO dto=null;
		 RequestDispatcher rd=null;
		//general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form data
		 eno=Integer.parseInt(req.getParameter("eno"));
		 //use SErvice
		 dto=service.searchEmployee(eno);
		 //keep dto obj in request scope
		 req.setAttribute("empData",dto);
		 //forward request to  show_emp.jsp
		 rd=req.getRequestDispatcher("/show_emp.jsp");
		 rd.forward(req,res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);	
	}

}
