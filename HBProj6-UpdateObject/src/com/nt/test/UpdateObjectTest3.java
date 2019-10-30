package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest3 {
	public static void main(String[] args) {
		Session ses=null;
		BankAccount account=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//load and moodify  object (approach2)
		  account=ses.get(BankAccount.class,101);
		  if(account!=null) {
		try {
			tx=ses.beginTransaction();
			  account.setBalance(120000);
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
				System.out.println("Object updated");
			}
			else {
				tx.rollback();
				System.out.println("Object not updated");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	  }
		  else {
			  System.out.println("record not found");
		  }
		 
	}//main
}// class
