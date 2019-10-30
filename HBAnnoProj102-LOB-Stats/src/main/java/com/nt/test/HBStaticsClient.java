package com.nt.test;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.Statistics;

import com.nt.entity.EmployeeLOB;


public class HBStaticsClient {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		// Get Session stats
		 Statistics stats= factory.getStatistics();
		 stats.setStatisticsEnabled(true);
		Session ses1 = factory.openSession();
		Session ses2 = factory.openSession();
		Session ses3 = factory.openSession();
		Transaction tx=null;
		EmployeeLOB empLOB =  ses1.get(EmployeeLOB.class,144);
		 System.out.println(empLOB.getEid()+"  "+empLOB.getEname()+" "+empLOB.getSalary());
		try{
			tx=ses1.beginTransaction();
			  ses1.delete(empLOB);
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
		}
		 ses2.close();
		
		 
		 System.out.println("open sessions count: "+stats.getSessionOpenCount());
		 System.out.println("closed sessions count "+stats.getSessionCloseCount());
		 System.out.println("Tx count"+stats.getTransactionCount());
		 System.out.println("successful Tx count"+stats.getSuccessfulTransactionCount());
         System.out.println("session start time"+new Date(stats.getStartTime()));		 
         
         // Get Entity Stats
          EntityStatistics es=stats.getEntityStatistics("com.nt.entity.EmployeeLOB");
          
          System.out.println("deleted count::"+es.getDeleteCount());
          System.out.println("inserted count::"+es.getInsertCount());
          System.out.println("loaded count::"+es.getLoadCount());
          System.out.println("updated count::"+es.getUpdateCount());
          
          
		ses1.close();
	   factory.close();
	}// main

}// class
