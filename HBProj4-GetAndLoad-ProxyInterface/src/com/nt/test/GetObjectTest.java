package com.nt.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.InsurancePolicy;

public class GetObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		InsurancePolicy policy=null;
		//Bootstrap hibernate
		cfg=new Configuration();
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//create SessionFactory obj
		factory=cfg.buildSessionFactory();
		//open Session
		ses=factory.openSession();
		try {
		//Get object from DB s/w
		policy=ses.get(InsurancePolicy.class,101);
		System.out.println(policy.getClass());
		if(policy==null)
			System.out.println("No Record found");
		//else
			//System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getPolicyHolderName()+"  "+policy.getTenure()); 
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			ses.close();
			factory.close();
		}

	}//main
}//class
