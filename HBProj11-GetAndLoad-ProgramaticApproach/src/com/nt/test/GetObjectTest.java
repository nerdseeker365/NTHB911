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
		//specify  hibernate properties
		cfg.setProperty("hibernate.connection.driver_class","oracle.jdbc.driver.OracleDriver");
		cfg.setProperty("hibernate.connection.url","jdbc:oracle:thin:@localhost:1521:xe");
		cfg.setProperty("hibernate.connection.username","system");
		cfg.setProperty("hibernate.connection.password","manager2");
		
		cfg.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		cfg.setProperty("hibernate.show_sql","true");
		cfg.setProperty("hibernate.format_sql","true");
		cfg.setProperty("hibernate.hbm2ddl.auto","update");
		
		
		
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
