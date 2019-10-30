package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class HQLSelectTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		List<Project> list=null;
		Iterator<Project> it=null;
		Project proj=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
		/*//prepare Query obj	
			query=ses.createQuery(" from Project as p ");
			//execute the Query
			list=query.list();
			//process the Result
			list.forEach(proj->{
				System.out.println(proj.getProjId()+"  "+proj.getProjName()+" "+proj.getTeamSize()+" "+proj.getManager()+" "+proj.getCompany());
			});*/
			//preparing HQL Query with positional params(?)
		/*	query=ses.createQuery("from Project where projId>=?3 and projId<=?2");
			query.setParameter(3,1000);
			query.setParameter(2,1500);
			list=query.list();
			list.forEach(proj->{
				System.out.println(proj.getProjId()+"  "+proj.getProjName()+" "+proj.getTeamSize()+" "+proj.getManager()+" "+proj.getCompany());
			});
		*/
			 //prepare HQL Query with named params (:<name>)
		/*	 query=ses.createQuery("from Project where teamSize>=:start and teamSize<=:end");
			 //set named param values
			 query.setParameter("start",10);
			 query.setParameter("end",20);
			 //execute the Query
			 list=query.list();
			 //process the ResultSet
			 list.forEach(proj1->{
				 System.out.println(proj1.getClass());
				 System.out.println(proj1.getProjId()+" "+proj1.getProjName()+" "+proj1.getCompany()+" "+proj1.getManager()+" "+proj1.getTeamSize());
			 });*/
			 
			/*//executing HQL Query using iterate() method
			 query=ses.createQuery("from Project where manager in(:name1,:name2) order  by manager");
			 //set param values
			 query.setParameter("name1","raja");
			 query.setParameter("name2","ramesh");
			 //execute the query
			 it=query.iterate();
			while(it.hasNext()) {
				 proj=it.next();
				 System.out.println(proj.getClass());
			     System.out.println(proj.getProjId()+" "+proj.getProjName()+" "+proj.getTeamSize()+" "+proj.getManager()+" "+proj.getCompany());
			     
			 }*/
			
		
			
			
			 
			 
			 
			
			
		
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
