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
		Properties props=null;
		try {
		//Load hb.properties file info to java.util.Properties class object
		is=new FileInputStream("src/com/nt/commons/hb.properties");
		props=new Properties();
		props.load(is);
		}
		catch(FileNotFoundException fnf) {
			fnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//Bootstrap hibernate
		cfg=new Configuration();
		//specify  hibernate properties
		cfg.setProperties(props);
		
		//specify mapping file name
		cfg.addFile("src/com/nt/entity/InsurancePolicy.hbm.xml");
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
		else
			System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getPolicyHolderName()+"  "+policy.getTenure()); 
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
