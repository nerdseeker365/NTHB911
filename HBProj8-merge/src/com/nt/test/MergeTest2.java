package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BrandFactory;
import com.nt.utility.HibernateUtil;

public class MergeTest2 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		BrandFactory factory=null,factory1=null,factory3=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
			 factory=new BrandFactory();
			 factory.setCustMobileNo(777668L);
			 factory.setCustName("bigB");
			 factory.setCustAddrs("anderi-west");
			 factory.setRewardPoints(1000);
			 ses.save(factory);
			 System.out.println("after save");
			 factory1=new BrandFactory();
			 factory1.setCustMobileNo(777668L);
			 factory1.setCustName("smallB");
			 factory1.setCustAddrs("bandra-east");
			factory3=(BrandFactory) ses.merge(factory1);
			System.out.println(factory3);
			
			 System.out.println("after update");
			
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
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
