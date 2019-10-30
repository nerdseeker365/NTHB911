package com.nt.test;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class FilterTest2 {

	public static void main(String[] args) {
		Session ses=null;
		Filter filter=null;
	    Criteria criteria=null;
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
        criteria=ses.createCriteria(Employee.class);
        //execute query
        list=criteria.list();
        //process the results
        list.forEach(emp->{
        	System.out.println(emp);
        });
        
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
