package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Customer;
import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class PersonDAOImpl implements PersonDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Person per=null;
		Employee emp=null;
		Customer cust=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session 
		ses=HibernateUtil.getSession();
		//create objes
		 emp=new Employee();
		 emp.setPname("ravi");
		 emp.setCompany("Wipro");
		 emp.setDesg("SSE");
		 emp.setSalary(9000);
		 
		 cust=new Customer();
		 cust.setPname("rajesh");
		 cust.setCompany("InfoSys");
		 cust.setAddrs("ameepet");
		 cust.setBillAmt(9000);
		 try {
			 tx=ses.beginTransaction();
			   ses.save(emp);
			   ses.save(cust);
			   flag=true;
		 }//try
		 catch(HibernateException he) {
			 he.printStackTrace();
			 flag=false;
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 flag=false;
		 }
		 finally {
			 if(flag) {
				 tx.commit();
				 System.out.println("object are saved");
			 }
			 else {
				 tx.rollback();
				 System.out.println("object are not saved");
			 }
			 //close session
			 HibernateUtil.closeSession(ses);
		 }
	}//method
	
	@Override
	public void loadData() {
		Session ses=null;
		Query query=null;
		List<Employee> listEmps=null;
		List<Customer> listCusts=null;
		List<Person>  listPers=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
	   //create Quer obj
			query=ses.createQuery("from Employee");
			listEmps=query.list();
			listEmps.forEach(emp->{
				System.out.println(emp);
			});
			System.out.println("................................");
			query=ses.createQuery("from Customer");
			listCusts=query.list();
			listCusts.forEach(cust->{
				System.out.println(cust);
			});
			System.out.println("................................");
			query=ses.createQuery("from Person");
			listPers=query.list();
			listPers.forEach(per->{
				System.out.println(per);
			});
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
		
	}
	
}//class
