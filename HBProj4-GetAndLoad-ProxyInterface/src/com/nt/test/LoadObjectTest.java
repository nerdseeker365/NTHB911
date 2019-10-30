package com.nt.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.IPolicy;
import com.nt.entity.InsurancePolicy;

public class LoadObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		IPolicy policy=null;
		//Bootstrap hibernate
		cfg=new Configuration();
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//create SessionFactory obj
		factory=cfg.buildSessionFactory();
		//open Session
		ses=factory.openSession();
		try {
		//Get object from DB s/w
		policy=ses.load(InsurancePolicy.class,101);
		System.out.println(policy.getClass());
			//System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getPolicyHolderName()+"  "+policy.getTenure()); 
		}//try
		catch(Exception he) {
			System.out.println("Record not found");
			he.printStackTrace();
		}
		finally {
			ses.close();
			factory.close();
		}

	}//main
}//class
