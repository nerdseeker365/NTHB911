package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class HQLSelectTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		List<Object[]> list=null;
		List<Object> list1=null;
		Iterator<Object[]> it=null;
		List<Project> list2=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		try {
		 /*//prepare HQL Select Query the gives partial values of the records
			query=ses.createQuery("select projName,teamSize from Project where projId>=:start and projId<=:end");
		 //set values to Query params
			query.setParameter("start",1000);
			query.setParameter("end",2000);
		 //execute the Query
			list=query.list();
			//process the Result
			for(Object[] row: list) {
				for(Object val:row) {
					System.out.print(val+"  ");
				}
				System.out.println();
			}
		
			list.forEach(row->{
				for(Object val:row) {
					System.out.print(val+" ");
				}
				System.out.println();
			});*/
			
			/* //prepare HQL Select Query the gives partial values of the records
			query=ses.createQuery("select projName,teamSize from Project where manager in(:mgnr1,:mgnr2)");
			//set values to Query params
			query.setParameter("mgnr1","raja");
			query.setParameter("mgnr2","ramesh");
			it=query.iterate();
			while(it.hasNext()) {
				Object row[]=it.next();
				for(Object val:row) {
					System.out.print(val+" ");
				}
				System.out.println();
			}
			*/
			
		/*	//executing HQL Select query that gives single col value
			query=ses.createQuery("select  projName  from Project where manager=:mgnr1");
			query.setParameter("mgnr1","raja");
			list1=query.list();
			list1.forEach(name->{
				System.out.println(name);
			});*/
			
			//executing HQL Select query having aggregate results
			/*query=ses.createQuery("select count(*) from Project");
			list1=query.list();
			System.out.println("Records count::"+list1.get(0));*/
			
			//executing HQL Sub queries
			query=ses.createQuery("from Project where teamSize=(select  max(teamSize) from Project)");
			list2=query.list();
			list2.forEach(proj->{
				System.out.println(proj);
			});
			
		
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}//main
}//class
