package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Event;
import com.nt.utility.HibernateUtil;

public class DeleteObjectTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Event event=null;
		//Get Session object
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
			  //create object for deletion
			  event=new Event();
			  event.setId(101);
			  ses.delete(event);
			flag=true;
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				 tx.commit();
				 System.out.println("Object Deleted");
			}
			else {
				tx.rollback();
				 System.out.println("Object not found");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
