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
	public void saveDataUsingParents() {
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
		
		//set parent to childs
				cust1.setBank(bank); cust2.setBank(bank);
		//set childs to parent		
		childs=new HashSet();
		childs.add(cust1);
		childs.add(cust2);
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
	public void saveDataUsingChilds() {
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
		bank.setIfscCode("HDFC0088");
		bank.setBankName("HDFC");
		bank.setLocation("hyd");
		
		cust1=new Customer();
		cust1.setName("raja");
		cust1.setBalance(90000);
		
		
		cust2=new Customer();
		cust2.setName("rani");
		cust2.setBalance(30000);
		//add parent to childs
		 cust1.setBank(bank); cust2.setBank(bank);
		//set childs to parent
		childs=new HashSet();
		childs.add(cust1);
		childs.add(cust2);
		bank.setCustomers(childs);
		try {
			tx=ses.beginTransaction();
			//save objs
			 ses.save(cust1); ses.save(cust2);
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

		
	}
	
	}//class
