package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;

public class SaveObjectTestWithOutTx {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Employee emp=null;
		Transaction tx=null;
		boolean flag=false;
		//Bootstraping hibernate
		cfg=new Configuration();
		//Hold Hibernate Cfg file and Hibernate mapping file
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//Build SessionFactory object
		factory=cfg.buildSessionFactory();
		System.out.println("SessionFactory obj class name::"+factory.getClass());
		//create Session
		ses=factory.openSession();
		System.out.println("Session obj class name::"+ses.getClass());
		//create Entiry class object
		emp=new Employee();
		emp.setEid(1056);
		emp.setEname("BigB");
		emp.setSalary(90000);
		emp.setEmail("BigB@gmail.com");
		//save object
			  ses.save(emp);
            //flush the session
			  ses.flush();
			//close objs
			 ses.close();
			 factory.close();
				
		}//main
	}//class
