package com.nt.test;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.InsurancePolicy;

public class QueryCacheTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses1=null;
		List<InsurancePolicy> list=null;
		Query query=null;
		//Bootstrap hibernate
		cfg=new Configuration();
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//create SessionFactory obj
		factory=cfg.buildSessionFactory();
		//open Session
		ses1=factory.openSession();
		try {
		    query=ses1.createQuery("from InsurancePolicy");
		    query.setCacheable(true);
		    list=query.list();
		    list.forEach(p->{
		    	System.out.println(p);
		    });
		    System.out.println("...................................");
		    list=query.list();
		    list.forEach(p->{
		    	System.out.println(p);
		    });
		    
		    
			}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			ses1.close();
			factory.close();
		}

	}//main
}//class
