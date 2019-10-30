package com.nt.test;



import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.InsurancePolicy;

public class FirstLevelCacheTest2 {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		InsurancePolicy policy=null,policy1=null;
		Transaction tx=null;
		boolean flag=false;
		//Bootstrap hibernate
		cfg=new Configuration();
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//create SessionFactory obj
		factory=cfg.buildSessionFactory();
		//open Session
		ses=factory.openSession();
		//Get object from DB s/w
		policy=ses.get(InsurancePolicy.class,1001);
		if(policy==null) {
			System.out.println("No Record found");
			return;
		}
		else {
			System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getPolicyHolderName()+"  "+policy.getTenure());
			try {
				tx=ses.beginTransaction();
				   policy.setTenure(881);
				   ses.update(policy);
				   policy.setPolicyHolderName("ramesh1");
				   ses.update(policy);
				flag=true;
			}//try
			catch(HibernateException he) {
				he.printStackTrace();
				flag=false;
			}
			catch(Exception e) {
				e.printStackTrace();
				flag=false;
			}
		finally {
			
		    if(flag) {
		    	tx.commit();
		    	System.out.println("Object updated");
		    }
			ses.close();
			factory.close();
		   }//finally
		}//else

	}//main
}//class
