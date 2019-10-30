package com.nt.test;



import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class FilterTest3 {

	public static void main(String[] args) {
		Session ses=null;
		Filter filter=null;
	    CriteriaBuilder builder=null;
	    CriteriaQuery<Employee> ctQuery=null;
	    Query query=null;
	    Root<Employee> root=null;
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
		
		//use JPA Criteria
		builder=ses.getCriteriaBuilder();
		ctQuery=builder.createQuery(Employee.class);
		root=ctQuery.from(Employee.class);
		ctQuery.select(root);
		query=ses.createQuery(ctQuery);
		list=query.getResultList();
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
