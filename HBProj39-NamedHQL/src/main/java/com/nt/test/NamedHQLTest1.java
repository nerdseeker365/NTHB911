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
		Transaction tx=null;
		int count=0;
		boolean flag=false;
		//get Sesssion
		ses=HibernateUtil.getSession();
		/*//get Access to Named HQL Query
		query=ses.getNamedQuery("GET_EMP_DETAILS");
		//set values to Query params
		query.setParameter("dmn","%yahoo.com");
		//execute the Query
		list=query.list();
		//process the results
		list.forEach(emp->{
			System.out.println(emp);
		});
		System.out.println("......................................");
		//get Access to Named HQL Query
				query1=ses.getNamedQuery("GET_EMP_DETAILS_BY_SAL_RANGE");
				//set values to Query params
				query1.setParameter("start",4000);
			//	query1.setParameter("end",10000);
				//execute the Query
				list1=query1.list();
				//process the results
				list1.forEach(emp->{
					System.out.println(emp);
				});
		 System.out.println("..........................................");	*/
		 
		//get Access to Named HQL Query
			query2=ses.getNamedQuery("DELETE EMPS_BY_EID_RANGE");
			//set values to Query params
			query2.setParameter("min",1);
			query2.setParameter("max",5);
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
					System.out.println(count+" records are deleted");
				}
				else {
					tx.rollback();
					System.out.println("records not founed for deletion");
				}
			}
		
		
		//close objs
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();

	}//main
}//class
