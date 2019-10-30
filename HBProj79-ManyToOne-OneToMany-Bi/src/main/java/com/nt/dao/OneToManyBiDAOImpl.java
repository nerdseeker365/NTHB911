package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.BankAccount;
import com.nt.entity.Customer;
import com.nt.utility.HibernateUtil;

public class OneToManyBiDAOImpl implements OneToManyBiDAO {

	@Override
	public void saveDataUsingParent() {
		Session ses=null;
		Customer cust=null;
		Set<BankAccount> childs=null;
		BankAccount ac1=null,ac2=null;
		Transaction tx=null;
		boolean flag=false;
		
	    //get Session
		ses=HibernateUtil.getSession();
		//prpeare objs
		cust=new Customer();
		cust.setName("raja");
		cust.setAddrs("hyd");
		
		ac1=new BankAccount();
		ac1.setBranch("hyd");
		ac1.setBankName("SBI");
		ac1.setBalance(90000);
		
		ac2=new BankAccount();
		ac2.setBranch("hyd");
		ac2.setBankName("HDFC");
		ac2.setBalance(3000);
		 //add childs to parent
	   childs=new HashSet();
	   childs.add(ac1); childs.add(ac2);
	     cust.setAccounts(childs);
	     //add parent to childs
	     ac1.setCust(cust);
	     ac2.setCust(cust);
	   try {
		   tx=ses.beginTransaction();
		      ses.save(cust);
		   flag=true;
	   }//try
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
		Customer cust=null;
		Set<BankAccount> childs=null;
		BankAccount ac1=null,ac2=null;
		Transaction tx=null;
		boolean flag=false;
		
	    //get Session
		ses=HibernateUtil.getSession();
		//prpeare objs
		cust=new Customer();
		cust.setName("ravi");
		cust.setAddrs("delhi");
		
		ac1=new BankAccount();
		ac1.setBranch("delhi");
		ac1.setBankName("HDFC");
		ac1.setBalance(90000);
		
		ac2=new BankAccount();
		ac2.setBranch("delhi");
		ac2.setBankName("HDFC");
		ac2.setBalance(3000);
		 //add childs to parent
	   childs=new HashSet();
	   childs.add(ac1); childs.add(ac2);
	     cust.setAccounts(childs);
	     //add parent to childs
	     ac1.setCust(cust);
	     ac2.setCust(cust);
	   try {
		   tx=ses.beginTransaction();
		      ses.save(ac1);
		      ses.save(ac2);
		   flag=true;
	   }//try
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
	public void loadDataUsingParent() {
		Session ses=null;
		Query query=null;
		List<Customer> list=null;
		try {
	    //get Session
		ses=HibernateUtil.getSession();
		//prepare and execute HQL Query
		query=ses.createQuery("from Customer");
		list=query.list();
		list.stream().forEach(cust->{
			System.out.println("parent ::"+cust);
			Set<BankAccount> childs=cust.getAccounts();
			childs.stream().forEach(
					System.out::println
			);
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
		
	}
	
	
}//class
