package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;

public class SaveObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Employee emp=null;
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
		emp=new Employee();
		emp.setEid(5249);
		emp.setEname("tarun");
		emp.setSalary(99109);
		emp.setEmail("ramesh3@gmail.com");
		
		//save object
		try {
			tx=ses.beginTransaction(); //begins Tx by calling con.setAutoCommit(false)
			  idVal=(int)ses.save(emp);
			  System.out.println("Generated Id value::"+idVal);
			flag=true;
		}
		catch(HibernateException he) {
			  flag=false;
			  he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				tx.commit(); //commits Tx by calling con.commit()
				System.out.println("Object saved(Record inserted)");
			}
			else {
				tx.rollback(); //rollbacks Tx by calling con.rolloback()
				System.out.println("Object is not saved(Record not inserted)");
			}	
			//close objs
			 ses.close();
			 factory.close();
			}//finally */
				
		}//main
	}//class
