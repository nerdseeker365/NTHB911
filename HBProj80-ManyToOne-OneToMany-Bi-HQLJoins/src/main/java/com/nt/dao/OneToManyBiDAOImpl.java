package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.BankAccount;
import com.nt.entity.Customer;
import com.nt.utility.HibernateUtil;

public class OneToManyBiDAOImpl implements OneToManyBiDAO {

	
	@Override
	public void loadDataUsingParentSideJoins() {
		Session ses=null;
		Query query=null;
		List<Object[]> list=null;
		try {
	    //get Session
		ses=HibernateUtil.getSession();
		//prepare and execute HQL Query
		//query=ses.createQuery("select c.aadharNo,c.name,ac.acno,ac.bankName,ac.balance from Customer c full join c.accounts ac");;
		query=ses.createQuery("select c.aadharNo,c.name,c.addrs,ac.acno,ac.bankName,ac.balance,ac.branch from Customer c inner join c.accounts ac");;
		list=query.list();
		list.stream().forEach(row->{
			for(Object val:row) {
				System.out.print(val+" ");
			}
			System.out.println();
		});
		
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//closes session
			HibernateUtil.closeSession(ses);
			
		}//finally
		
	}//method
	
	@Override
	public void loadDataUsingChild() {
		Session ses=null;
		Query query=null;
		List<BankAccount> list=null;
		try {
	    //get Session
		ses=HibernateUtil.getSession();
		//prepare and execute HQL Query
		query=ses.createQuery("from BankAccount");
		list=query.list();
		list.stream().forEach(ac->{
			System.out.println("child ::"+ac);
			Customer cust=ac.getCust();
			System.out.println("parent::"+cust);
		});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//closes session
			HibernateUtil.closeSession(ses);
			
		}//finally
		
	}//method
	
	@Override
	public void loadDataUsingParent() {
		Session ses=null;
		Query query=null;
		List<Customer> list=null;
		
		try {
	    //get Session
		ses=HibernateUtil.getSession();
		//prepare and execute HQL Query
		query=ses.createQuery("from Customer");;
		//query=ses.createQuery("select c from  Customer c inner join fetch c.accounts ac");
		list=query.list();
		list.stream().forEach(cust->{
			System.out.println("parent"+cust);
			Set<BankAccount> childs=cust.getAccounts();
			childs.stream().forEach(ac->{
				System.out.println("child ::"+ac);	
			});
		}); 
		
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//closes session
			HibernateUtil.closeSession(ses);
			
		}//finally
		
	}//method
	
	@Override
	public void loadDataUsingQBC() {
		Session ses=null;
		Criteria criteria=null;
		List<Customer> list=null;
		try {
	    //get Session
		ses=HibernateUtil.getSession();
		//prepare CRiteria obj
		criteria=ses.createCriteria(Customer.class);
		criteria.setFetchMode("accounts", FetchMode.SELECT);
		list=criteria.list();
		list.stream().forEach(cust->{
			System.out.println("parnet::"+cust);
			Set<BankAccount> childs=cust.getAccounts();
			childs.stream().forEach(ac->{
				System.out.println("child::"+ac);
			});
		});
		}//try
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
	public void loadDataUsingJPAQBC() {
		Session ses=null;
		CriteriaBuilder builder=null;
		List<Customer> list=null;
		CriteriaQuery<Customer> ctQuery=null;
		Root<Customer> root=null;
		Query query=null;
		try {
	    //get Session
		ses=HibernateUtil.getSession();
		//use JPAQBC 
		builder=ses.getCriteriaBuilder();
		ctQuery=builder.createQuery(Customer.class);
		root=ctQuery.from(Customer.class);
		root.fetch("accounts");
		ctQuery.select(root);
		query=ses.createQuery(ctQuery);
		list=query.list();
		list.stream().forEach(cust->{
			System.out.println("parnet::"+cust);
			Set<BankAccount> childs=cust.getAccounts();
			childs.stream().forEach(ac->{
				System.out.println("child::"+ac);
			});
		});
		}//try
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
		
	
	
}//class
