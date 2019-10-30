package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Bank;
import com.nt.entity.Customer;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Customer cust1=null,cust2=null;
		Bank bank=null;
		Set<Customer> childs=null;
		boolean flag=false;
		Transaction tx=null;
	   //get Session 
		ses=HibernateUtil.getSession();
		//prepare objects
		bank=new Bank();
		bank.setIfscCode("SBI0088");
		bank.setBankName("SBI");
		bank.setLocation("hyd");
		
		cust1=new Customer();
		cust1.setName("raja");
		cust1.setBalance(90000);
		
		cust2=new Customer();
		cust2.setName("rani");
		cust2.setBalance(30000);
		childs=new HashSet();
		childs.add(cust1);
		childs.add(cust2);
		//set childs to parent
		bank.setCustomers(childs);
		try {
			tx=ses.beginTransaction();
			//save objs
			   ses.save(bank);
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
				System.out.println("Objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void loadData() {
		Session ses=null;
		List<Bank> list=null;
		Query query=null;
		try {
 	   //get Session 
		ses=HibernateUtil.getSession();
		//prepare and execute Query
		query=ses.createQuery("from Bank");
		list=query.list();
		list.parallelStream().forEach(bank->{
			System.out.println("parent:::"+bank);
			Set<Customer> childs=bank.getCustomers();
			 childs.size();
			childs.parallelStream().forEach(child->{
				System.out.println("child::"+child);
			});
		});
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close Session
			HibernateUtil.closeSession(ses);
		}
	}//method
	
	@Override
	public void loadDataUsingQBC() {
		Session ses=null;
		List<Bank> list=null;
		 Criteria criteria=null;
		try {
 	   //get Session 
		ses=HibernateUtil.getSession();
		//prepare and execute Query
		criteria=ses.createCriteria(Bank.class);
		list=criteria.list();
		list.parallelStream().forEach(bank->{
			System.out.println("parent:::"+bank);
			Set<Customer> childs=bank.getCustomers();
			 childs.size();
			childs.parallelStream().forEach(child->{
				System.out.println("child::"+child);
			});
		});
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close Session
			HibernateUtil.closeSession(ses);
		}
		
	}
	
	@Override
	public void deletingOneChildFromCollectionOfChilds() {
		Session ses=null;
		Bank bank=null;
		Set<Customer> childs=null;
		Customer cust=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//Load parent object
		bank=ses.get(Bank.class,"SBI0088");
		//get Childs of a parent
		childs=bank.getCustomers();
		//Load child object
		cust=ses.get(Customer.class,82L);
		try {
			tx=ses.beginTransaction();
			    childs.remove(cust);
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
				System.out.println("one child of collection of childs is removed");
			}
			else {
				tx.rollback();
				System.out.println("one child of collection of childs is not removed");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}
	}//method
}//class
