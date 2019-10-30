package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class NamedHQLTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null,query1=null,query2=null;
		List<Employee> list=null,list1=null;
		List<Object[]>list2=null;
		Transaction tx=null;
		int count=0;
		boolean flag=false;
		//get Sesssion
		ses=HibernateUtil.getSession();
		//get Access to Named HQL Query
		query=ses.getNamedQuery("GET_EMPDETAILS");
		//set values to Query params
		query.setParameter("start",6000.0f);
		query.setParameter("end",99000.0f);
		//execute the Query
		list2=query.list();
		//process the results
		list2.forEach(row->{
			for(Object val:row) {
				System.out.print(val+" ");
			}
			System.out.println();
		});
		System.out.println("......................................");
		
		 
		//get Access to Named HQL Query
			query2=ses.getNamedQuery("UPDATE_EMAIL");
			//set values to Query params
			query2.setParameter("newEmail","raja@gmail.com");
			query2.setParameter("no",567);
			//execute the Query
			try {
				tx=ses.beginTransaction();
				  count=query2.executeUpdate();
				 flag=true; 
			}
			catch(HibernateException he) {
				he.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				if(flag) {
					tx.commit();
					System.out.println(count+" records are upated");
				}
				else {
					tx.rollback();
					System.out.println("records not founed for updation");
				}
			}
		//close objs
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();

	}//main
}//class
