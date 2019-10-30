package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.MNCustomer;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		boolean flag=false;
		MNCustomer cust=null;
		int idVal=0;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load and modify object
		cust=ses.get(MNCustomer.class,8);
	    if(cust==null) {
	    	System.out.println("Object not found");
	      return;
	    }
		try {
			tx=ses.beginTransaction();
		  
			//modify the object
		  //cust.setCallerTune("pakka local");
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
				System.out.println("Object updated for   "+cust.getTuneChangeCount()+" times");
			}
			else {
				tx.rollback();
				System.out.println("Object is not update");
			}
			//close jdbc objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
