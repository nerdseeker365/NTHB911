package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.College;
import com.nt.utility.HibernateUtil;

public class AnnoHBLoadTest {

	public static void main(String[] args) {
		Session ses=null;
		College clg=null;
		//get Session 
		ses=HibernateUtil.getSession();
		try {
         clg=ses.get(College.class,3455);
         System.out.println(clg);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
