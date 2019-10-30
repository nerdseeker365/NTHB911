package com.nt.test;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class DbTableRowToObjectSync {

	public static void main(String[] args) {
		Session ses=null;
		BankAccount account=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load object
		try {
		account=ses.get(BankAccount.class, 101);
		System.out.println(account);
		
			Thread.sleep(30000); //modify 101 record from DB table during this sleep period
		 ses.refresh(account);
			System.out.println(account);
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
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
		}
		

	}//main
}//class
