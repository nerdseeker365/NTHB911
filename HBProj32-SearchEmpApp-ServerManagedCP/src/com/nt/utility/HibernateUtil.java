package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	private static ThreadLocal<Session> threadLocal=new ThreadLocal();
	static {
		Configuration cfg=null;
		//create Configuration object
		cfg=new Configuration();
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//create SessionFActory object
		factory=cfg.buildSessionFactory();
	}
	
	public  static  Session getSession() {
		Session ses=null;
		if(factory!=null) {
			ses=threadLocal.get();
			 if(ses==null) {
				 ses=factory.openSession();
				 threadLocal.set(ses);
			 }
		}
		return ses;
	}
	
	public static  void closeSession() {
		 Session ses=null;
		 ses=threadLocal.get();
	     if(ses!=null) {
	    	 ses.close();
	    	 threadLocal.remove();
	     }
	}
	
	public  static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
	

}
