package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest1 {
	public static void main(String[] args) {
		Session ses=null;
		BankAccount account=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//create object (approach1)
		account=new BankAccount();
		account.setAcno(101);
		account.setHolderName("raja");
		account.setBalance(120000);
		account.setType("savings");
		try {
			tx=ses.beginTransaction();
			  ses.update(account);
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
		 
	}//main
}//class
