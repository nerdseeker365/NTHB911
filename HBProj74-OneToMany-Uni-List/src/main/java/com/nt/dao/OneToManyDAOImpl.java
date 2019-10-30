package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PhoneNumber;
import com.nt.entity.User;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	/*@Override
	public void insertData() {
		Session ses=null;
		User user=null;
		PhoneNumber ph1=null,ph2=null;
		List<PhoneNumber> list=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session 
		ses=HibernateUtil.getSession();
		//prepare Domain class objs
		//parent obj
		user=new User();
		user.setUserId(9811);
		user.setUsername("rama");
		
		//child objs
		ph1=new PhoneNumber();
		ph1.setPhone(889966555L);
		ph1.setNumberType("office");
		ph1.setProvider("airtel");
		
		ph2=new PhoneNumber();
		ph2.setPhone(444446666L);
		ph2.setNumberType("residence");
		ph2.setProvider("jio");
	   //Add PhoneNumbers to Set collection
		list=new ArrayList();	
	     list.add(ph1); list.add(ph2);
		//add childs to parent
		user.setPhones(list);
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
	*/
	/*@Override
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
				
	}//methdo */
	
	@Override
	public void removeOneChildFromCollectionOfChildsOfAParent() {
		Session ses=null;
		User user=null;
		Transaction tx=null;
		List<PhoneNumber> childs=null;
		PhoneNumber ph1=null;
		boolean flag=false;
		
		
		// Get Session
		ses=HibernateUtil.getSession();
		//Load parent obj
		user=ses.get(User.class,1);
		//get Childs of A parent
		childs=user.getPhones();
		
		//remove the above child from collection of childs beloging to a parent
		try {
			tx=ses.beginTransaction();
			   childs.remove(1);
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
	
/*	@Override
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
	
	@Override
	public void reAttachOrphanToParent() {
		Session ses=null;
		User user=null;
		Transaction tx=null;
		Set<PhoneNumber> childs=null;
		PhoneNumber ph=null;
		boolean flag=false;
		// Get Session
		ses=HibernateUtil.getSession();
		//Load parent
		user=ses.get(User.class,1);
		//get All childs of parent 
		childs=user.getPhones();
		//Load Orhan record child object
		ph=ses.get(PhoneNumber.class,8988888L);
		try {
			tx=ses.beginTransaction();
			  //reattach orphan child to parent
			childs.add(ph);
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Orphan record reattached ");
			}
			else {
				tx.rollback();
				System.out.println("Orphan record is not reattached ");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void addNewChildToAnExistingParent() {
		Session ses=null;
		User user=null;
		Transaction tx=null;
		Set<PhoneNumber> childs=null;
		PhoneNumber ph=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//Load parent
		user=ses.get(User.class,1);
		//get All childs of a parent
		childs=user.getPhones();
		//create new child class obj
		ph=new PhoneNumber();
		ph.setPhone(76666666L);
		ph.setNumberType("Personal");
		ph.setProvider("idea");
		try {
			tx=ses.beginTransaction();
			   //add new Child to collection
			childs.add(ph);
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
				System.out.println("new Child added");
			}
			else {
				tx.rollback();
				System.out.println("new Child is not added");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void transferChildFromOneParentToAnotherParent() {
		Session ses=null;
		User user1=null,user2=null;
		Transaction tx=null;
		Set<PhoneNumber> user1Childs=null,user2Childs=null;
		PhoneNumber ph=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//Load parent1
		user1=ses.get(User.class,1);
		//get parent1 childs
		user1Childs=user1.getPhones();
		//Load parent2
		user2=ses.get(User.class,2);
		//get Parent2 childs
		user2Childs=user2.getPhones();
		//Load child obj that u want to tranfer
		ph=ses.get(PhoneNumber.class,76666666L);
		try {
			tx=ses.beginTransaction();
			   user2Childs.add(ph);
			   user1Childs.remove(ph);
			  // ses.flush();
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
				System.out.println("Child is transfered");
			}
			else {
				tx.rollback();
				System.out.println("Child is not transfered");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//method
*/	
}//class
