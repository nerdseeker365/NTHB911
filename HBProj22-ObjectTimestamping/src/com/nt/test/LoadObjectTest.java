package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.StockInfo;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		boolean flag=false;
		StockInfo info=null;
		int idVal=0;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load and modify object
		info=ses.get(StockInfo.class,9);
	    if(info==null) {
	    	System.out.println("Object not found");
	      return;
	    }
		try {
			tx=ses.beginTransaction();
		  
			//modify the object
		  info.setPrice(10000);
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
				System.out.println("Object updated at   "+info.getLastUpdated());
			}
			else {
				tx.rollback();
				System.out.println("Object is not updated");
			}
			//close jdbc objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
