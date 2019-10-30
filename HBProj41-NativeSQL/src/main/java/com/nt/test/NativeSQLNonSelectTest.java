package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.nt.utility.HibernateUtil;

public class NativeSQLNonSelectTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null; 
		boolean flag=false;
		NativeQuery query1=null;
		int result=0;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
			//prepare Query
			  query1=ses.createSQLQuery("INSERT INTO INSURANCEPOLICY VALUES(?,?,?,?)");
			  //set values to query params
			  query1.setParameter(1,8001);
			  query1.setParameter(2,"JS");
			  	query1.setParameter(3, "raja");
			  	query1.setParameter(4,10);
			  	//execute  Query
			  	result=query1.executeUpdate();
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
				System.out.println("Record inserted");
			}
			else {
				tx.rollback();
				System.out.println("Record not inserted");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	
	}//main
}//class
