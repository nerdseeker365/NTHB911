package com.nt.test;

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
		//BootStrap Hibernate 
		 cfg=new Configuration();
		 
		 //Locate and read cfg file,mapping files
		 cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		 //build SessionFactory
		/* factory=cfg.buildSessionFactory();
		 //Open Session
		 ses=factory.openSession();
		 //create Entity class obj with Data
		 emp=new Employee();
		 emp.setEno(1009); emp.setEname("raja");
		 emp.setDesg("CLERK"); emp.setSalary(9000);
		 try {
			 //begin Transaction
			 tx=ses.beginTransaction();
			   //save object
			 ses.save(emp);
			 flag=true;
		 }//try
		 catch(Exception e) {
			 flag=false;
			 e.printStackTrace();
		 }
		 finally {
			 //perform Tx Mgmt
			 if(flag) {
				 tx.commit();
				 System.out.println("Object is saved");
			 }
			 else {
				 tx.rollback();
				 System.out.println("Object is rolleback");
			 }
			 //close HB ses,SessionFactory objs
			 ses.close();
			 factory.close();
		 }//finally */
	}//main
}//class
