package com.nt.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.InsurancePolicy;

public class L2CacheTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses1=null,ses2=null;
		InsurancePolicy policy=null;
		//Bootstrap hibernate
		cfg=new Configuration();
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//create SessionFactory obj
		factory=cfg.buildSessionFactory();
		//open Session
		ses1=factory.openSession();
		ses2=factory.openSession();
		try {
		//Gets object from DB s/w puts L2,L1 Caches
		policy=ses1.get(InsurancePolicy.class,101);
		System.out.println(policy);
		System.out.println("...................................");
		//Gets from  L1 Cache
		policy=ses1.get(InsurancePolicy.class,101);
		System.out.println(policy);
		System.out.println("...................................");
		ses1.clear();
		//Gets from  L2 Cache and puts L1 cache of ses1
		policy=ses1.get(InsurancePolicy.class,101);
		System.out.println(policy);
		ses1.evict(policy); //removes from L1 cache of ses1
		
		//Gets from  L2 Cache and puts L1 cache of ses2
				policy=ses2.get(InsurancePolicy.class,101);
				System.out.println(policy);
				ses2.clear();
				try {
					Thread.sleep(12000);
				}
				catch(InterruptedException iae) {
					iae.printStackTrace();
				}

				//Gets from  DB s/w puts in L2 cache and also in L1 cache of ses2
				policy=ses2.get(InsurancePolicy.class,101);
				System.out.println(policy);
		

		
		 
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			ses1.close();
			ses2.close();
			factory.close();
		}

	}//main
}//class
