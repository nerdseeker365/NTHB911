package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dto.InsurancePolicyDTO;
import com.nt.service.InsurancePolicyService;
import com.nt.service.InsurancePolicyServiceFactory;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
           int pageNo=0;
           int pageSize=0;
           String  type=null;
           List<InsurancePolicyDTO> listDTO=null;
           InsurancePolicyService  service=null;
           HttpSession ses=null;
           int pagesCount=0;
           RequestDispatcher rd=null;
           //get Session
            ses=req.getSession();
         
		//Decide wheather request has come form page or hyperlink
           type=req.getParameter("type");
           if(type.equalsIgnoreCase("getReport")) {  //from submit button
        	   //get Page no,pageSize
        	   pageNo=Integer.parseInt(req.getParameter("pageNo"));
        	   pageSize=Integer.parseInt(req.getParameter("pageSize"));
        	   //keep pageSize in session scope
        	   ses.setAttribute("pageSize",pageSize);
           }
           else {
        	   //get PageNo,PageSize
        	   pageNo=Integer.parseInt(req.getParameter("pageNo"));
        	   pageSize=(Integer)ses.getAttribute("pageSize");
           }
           //get SErvice class obj
           service=InsurancePolicyServiceFactory.getInstance();
           //use service
           try {
        	   //get report Dat
        	   listDTO=service.fetchPageData(pageNo, pageSize);
        	   System.out.println(listDTO.size());
        	   //get pagesCount
        	   pagesCount=service.getPageCount(pageSize);
        	   //keep in request scope
        	   req.setAttribute("pageData",listDTO);
        	   req.setAttribute("pageCount",pagesCount);
        	   //forward to policy_report.jsp
        	   rd=req.getRequestDispatcher("/policy_report.jsp");
        	   rd.forward(req,res);
           }
           catch(Exception e) {
        	   rd=req.getRequestDispatcher("/error.jsp");
        	   rd.forward(req,res);
        	   e.printStackTrace();
           }
           
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
