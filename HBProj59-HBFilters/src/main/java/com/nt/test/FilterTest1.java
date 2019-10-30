package com.nt.test;



import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class FilterTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Filter filter=null;
		NativeQuery query=null;
		List<Employee> list=null;
		Object count=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		try {
		//get Filter objet
		filter=ses.enableFilter("UNOFFICIAL_EMPS");
		//set filter params
		filter.setParameter("min", 1000);
		filter.setParameter("max",2000);
		
		//prpeare Query
        query=ses.createNativeQuery("select * from Employee");
        query.addEntity(Employee.class);
        //execute query
        list=query.list();
        //process the results
        list.forEach(emp->{
        	System.out.println(emp);
        });
        //disable Filter 
        ses.disableFilter("UNOFFICIAL_EMPS");
      //prpeare Query
        query=ses.createNativeQuery("select count(*) from Employee");
        //execute query
       count=  query.getSingleResult();
        //process the results
       System.out.println("Emps count::"+count);
        
        
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
        
	}//main
}//class
