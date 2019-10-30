package com.nt.test;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.InsurancePolicy;

public class GetObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		InsurancePolicy policy=null;
		InputStream is=null;
		cfg=new Configuration();
		cfg=cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//create SessionFactory obj
		factory=cfg.buildSessionFactory();
		try {
			System.out.println("check for db table creation...");
		Thread.sleep(30000);
		}
		catch(InterruptedException iae) {
			iae.printStackTrace();
		}
		//open Session
		ses=factory.openSession();
		try {
		//Get object from DB s/w
		policy=ses.get(InsurancePolicy.class,101);
		if(policy==null)
			System.out.println("No Record found");
		else
			System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getPolicyHolderName()+"  "+policy.getTenure()); 
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			ses.close();
			factory.close();
			System.out.println("check for db table deletion");
		}

	}//main
}//class
