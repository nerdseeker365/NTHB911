package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.utility.HibernateUtil;

public class NonSelectHQLTest {

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
		   query=ses.createQuery("delete from Project where projId>=:start and projId<=:end");
		   //set parma values
		   query.setParameter("start",4000);
		   query.setParameter("end",5000);
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
				System.out.println(result+ " number of records are deleted");
			}
			else {
				tx.rollback();
				System.out.println("no records are deleted");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
