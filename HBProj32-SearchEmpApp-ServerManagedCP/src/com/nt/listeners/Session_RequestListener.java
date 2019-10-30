package com.nt.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.nt.utility.HibernateUtil;

@WebListener
public class Session_RequestListener implements ServletRequestListener {
	
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest req=null;
		System.out.println("Session_RequestListener.requestDestroyed()");
		//get Request obj
		req=(HttpServletRequest)sre.getServletRequest();
		if(req.getServletPath().equalsIgnoreCase("/controller")) {
			System.out.println("request to servlet");
	          HibernateUtil.closeSession();
		}
	}

}
