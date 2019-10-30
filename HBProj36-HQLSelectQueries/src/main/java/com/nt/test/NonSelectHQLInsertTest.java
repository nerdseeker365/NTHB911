package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.utility.HibernateUtil;

public class NonSelectHQLInsertTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
		int result=0;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
     		//prepare HQL non-select Query
		   query=ses.createQuery("insert into Project values(?1,?2,?3,?4,?5)");
		   //set parma values
		   query.setParameter("1",401);
		   query.setParameter("2","proj1");
		   query.setParameter("3",10);
		   query.setParameter("4","raja");
		   query.setParameter("5","HCL");
		   //execute the query
		   result=query.executeUpdate();
		   flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("record inserted");
			}
			else {
				tx.rollback();
				System.out.println("record not inserted");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
