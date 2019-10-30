package com.nt.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class NamedHQLTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		List<Employee> list=null;
		//get Sesssion
		ses=HibernateUtil.getSession();
		//get Access to Named HQL Query
		query=ses.getNamedQuery("GET_EMP_DETAILS");
		//set values to Query params
		query.setParameter("dmn","%gmail.com");
		//execute the Query
		list=query.list();
		//process the results
		list.forEach(emp->{
			System.out.println(emp);
		});
		
		//close objs
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();

	}//main
}//class
