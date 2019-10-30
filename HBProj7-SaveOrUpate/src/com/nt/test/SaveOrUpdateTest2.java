package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BrandFactory;
import com.nt.utility.HibernateUtil;

public class SaveOrUpdateTest2 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		BrandFactory factory=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
			 factory=new BrandFactory();
			 factory.setCustMobileNo(5L);
			 factory.setCustName("ramesh");
			 factory.setCustAddrs("hyd");
			 factory.setRewardPoints(99);
			 //save or update the object
			 ses.saveOrUpdate(factory);
			flag=true;
		}
		catch(HibernateException he) {
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Obj is saved or updated");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved or updated");
			}
				//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally

	}//main
}//class
