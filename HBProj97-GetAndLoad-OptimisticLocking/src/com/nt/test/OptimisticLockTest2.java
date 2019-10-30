package com.nt.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.InsurancePolicy;

public class OptimisticLockTest2 {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		InsurancePolicy policy=null;
		Transaction tx=null;
		boolean flag=false;
		//Bootstrap hibernate
		cfg=new Configuration();
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//create SessionFactory obj
		factory=cfg.buildSessionFactory();
		//open Session
		
		ses=factory.openSession();
		//Gets object from DB s/w puts L2,L1 Caches
		policy=ses.get(InsurancePolicy.class,101);
		System.out.println(policy);
		try {
			tx=ses.beginTransaction();
              policy.setTenure(60);
		      ses.update(policy);
		  flag=true; 
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
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
			ses.close();
			factory.close();
		}

	}//main
}//class
