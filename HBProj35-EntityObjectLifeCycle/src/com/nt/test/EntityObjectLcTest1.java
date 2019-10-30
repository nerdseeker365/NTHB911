package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;

public class EntityObjectLcTest1 {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Employee emp=null,emp1=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		//Bootstraping hibernate
		cfg=new Configuration();
		//Hold Hibernate Cfg file and Hibernate mapping file
		cfg=cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//cfg=cfg.configure();
		//Build SessionFactory object
		factory=cfg.buildSessionFactory();
		//create Session
		ses=factory.openSession();
		//create Entiry class object
	
		//save object
		try {
			emp=ses.get(Employee.class,1); //persistent
			ses.evict(emp);
			emp1=ses.get(Employee.class, 1); //persitent
			tx=ses.beginTransaction();
			//ses.update(emp);
			 emp.setSalary(8000);
			 ses.merge(emp);
			tx.commit();
		}
		catch(HibernateException he) {
		
			  he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close objs
			 ses.close();
			 factory.close();
			}//finally */
				
		}//main
	}//class
