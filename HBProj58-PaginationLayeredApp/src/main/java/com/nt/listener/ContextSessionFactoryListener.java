package com.nt.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.nt.utility.HibernateUtil;

/**
 * Application Lifecycle Listener implementation class ContextSessionFactoryListener
 *
 */
@WebListener
public class ContextSessionFactoryListener implements ServletContextListener {


    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("ContextSessionFactoryListener::contextDestroyed()");
    	HibernateUtil.closeSessionFactory();
    }

    public void contextInitialized(ServletContextEvent sce)  {
    	System.out.println("ContextSessionFactoryListener.contextInitialized()");
    	try {
    		Class.forName("com.nt.utility.HibernateUtil");
    	}
    	catch(ClassNotFoundException cnf) {
    		cnf.printStackTrace();
    	}
    	
    }
	
}
