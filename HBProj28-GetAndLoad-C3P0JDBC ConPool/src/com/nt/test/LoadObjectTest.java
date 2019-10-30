package com.nt.test;



import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.InsurancePolicy;

public class LoadObjectTest {

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
		policy=ses.load(InsurancePolicy.class,101);
		//System.out.println(policy.getClass()+"     "+policy.getClass().getSuperclass());
		/*Method methods[]=policy.getClass().getDeclaredMethods();
		for(Method m:methods) {
			System.out.println(m.getName());
		}
		System.out.println("......");*/
		System.out.println(policy.getClass());
		//policy.getPolicyId();
		policy.getPolicyName();
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
