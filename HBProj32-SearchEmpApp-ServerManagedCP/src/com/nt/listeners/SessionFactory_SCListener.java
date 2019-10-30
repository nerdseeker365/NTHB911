package com.nt.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.nt.utility.HibernateUtil;

@WebListener
public class SessionFactory_SCListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("........SessionFactory_SCListener.contextInitialized().........");
	    try {
	    	Class.forName("com.nt.utility.HibernateUtil");
	    }
	    catch(ClassNotFoundException cnf) {
	    	cnf.printStackTrace();
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println(".....SessionFactory_SCListener.contextDestroyed().....");
		HibernateUtil.closeSessionFactory();
	}
	
}
