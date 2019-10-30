package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.PhoneNumber;
import com.nt.entity.User;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	@Override
	public void insertData() {
		Session ses=null;
		User user=null;
		PhoneNumber ph1=null,ph2=null;
		Set<PhoneNumber> set=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session 
		ses=HibernateUtil.getSession();
		//prepare Domain class objs
		//parent obj
		user=new User();
		user.setUsername("raja");
		
		//child objs
		ph1=new PhoneNumber();
		ph1.setPhone(97799999L);
		ph1.setNumberType("office");
		ph1.setProvider("airtel");
		
		ph2=new PhoneNumber();
		ph2.setPhone(8988888L);
		ph2.setNumberType("residence");
		ph2.setProvider("jio");
	   //Add PhoneNumbers to Set collection
		set=new HashSet();
		set.add(ph1); set.add(ph2);
		//add childs to parent
		user.setPhones(set);
		//save obj
		try {
			tx=ses.beginTransaction();
			  ses.save(user);
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
				System.out.println("Objects (parent-childs) are saved");
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
		User user=null;
		Set<PhoneNumber> childs=null;
		// Get Session object
		ses=HibernateUtil.getSession();
		try {
			//load Object
			user=ses.get(User.class,1);
			//get Childs
			childs=user.getPhones();
			System.out.println("parent::"+user);
			childs.isEmpty();
			childs.forEach(ph->{
				System.out.println("child::"+ph);
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
	}//method
	
	@Override
	public void loadAllData() {
		Session ses=null;
		Query query=null;
		List<User> list=null;
		// Get Session
		ses=HibernateUtil.getSession();
		//prepare Query obj
		query=ses.createQuery("from User");
		//execute the Query
		list=query.getResultList();
		//processs the collection
		list.forEach(user->{
			System.out.println("parent ::"+user);
			Set<PhoneNumber>childs=user.getPhones();
			childs.forEach(ph->{
				System.out.println("child::"+ph);
			});//for
		});
	}//method
	
	@Override
	public void removeParentAndChild() {
		Session ses=null;
		User user=null;
		Transaction tx=null;
		boolean flag=false;
		// Get Session
		ses=HibernateUtil.getSession();
		//Load parent obj
		user=ses.get(User.class,1);
		try {
			tx=ses.beginTransaction();
			   ses.delete(user);
			 flag=true;  
		}
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
				System.out.println("Parent and associated child objs are deleted");
			}
			else {
				tx.rollback();
				System.out.println("Parent and associated child objs are not deleted");
			}
			HibernateUtil.closeSession(ses);
		}//finally
				
	}//methdo
	
	@Override
	public void removeOneChildFromCollectionOfChildsOfAParent() {
		Session ses=null;
		User user=null;
		Transaction tx=null;
		Set<PhoneNumber> childs=null;
		PhoneNumber ph1=null;
		boolean flag=false;
		
		
		// Get Session
		ses=HibernateUtil.getSession();
		//Load parent obj
		user=ses.get(User.class,4);
		//get Childs of A parent
		childs=user.getPhones();
		//Load 1 Child object
		ph1=ses.get(PhoneNumber.class, 8988888L);
		//remove the above child from collection of childs beloging to a parent
		try {
			tx=ses.beginTransaction();
			   childs.remove(ph1);
			flag=true;
		}
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
				System.out.println("One child from collection of childs is deleted");
			}
			else {
				tx.rollback();
				System.out.println("One child from collection of childs is not deleted");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void removeAllChildsOfAParent() {
		Session ses=null;
		User user=null;
		Transaction tx=null;
		Set<PhoneNumber> childs=null;
		boolean flag=false;
		// Get Session
		ses=HibernateUtil.getSession();
		//Load parent
		user=ses.get(User.class,1);
		//Load  all childs..
		childs=user.getPhones();
		try {
			tx=ses.beginTransaction();
			   childs.clear();
			 flag=true;  
		}
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
				System.out.println("All childs of parent are deleted");
			}
			else {
				tx.rollback();
				System.out.println("All childs of parent are not deleted");
			}
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//method
	
}//class
