package com.nt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Spliterator;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.PhoneNumber;
import com.nt.entity.User;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	/*@Override
	public void insertData() {
		Session ses = null;
		User user = null;
		PhoneNumber ph1 = null, ph2 = null;
		PhoneNumber childs[]=null;
		Transaction tx = null;
		boolean flag = false;
		// get Session
		ses = HibernateUtil.getSession();
		// prepare Domain class objs
		// parent obj
		user = new User();
		// user.setUserId(9811);
		user.setUsername("rama");

		// child objs
		ph1 = new PhoneNumber();
		ph1.setPhone(889966555L);
		ph1.setNumberType("office");
		ph1.setProvider("airtel");

		ph2 = new PhoneNumber();
		ph2.setPhone(444446666L);
		ph2.setNumberType("residence");
		ph2.setProvider("jio");
		// Add PhoneNumbers to Set collection
		childs =new PhoneNumber[] {ph1,ph2};
		// add childs to parent
		user.setPhones(childs);
		// save obj
		try {
			tx = ses.beginTransaction();
			ses.save(user);
			flag = true;
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Objects (parent-childs) are saved");
			} else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			// close Session
			HibernateUtil.closeSession(ses);
		} // finally
	}// method
*/
	@Override
	public void removeOneChildFromCollectionOfChildsOfAParent() {
		Session ses = null;
		User user = null;
		Transaction tx = null;
		PhoneNumber childs[] = null;
		PhoneNumber ph1 = null;
		boolean flag = false;

		// Get Session
		ses = HibernateUtil.getSession();
		// Load parent obj
		user = ses.get(User.class, 2);
		// get Childs of A parent
		childs = user.getPhones();
		//get Child object
		ph1=ses.get(PhoneNumber.class,444446666L);

		// remove the above child from collection of childs beloging to a parent
		try {
			tx = ses.beginTransaction();
			childs[0]=null;
			childs[0]=ph1;
			childs[1]=null;
			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("One child from collection of childs is deleted");
			} else {
				tx.rollback();
				System.out.println("One child from collection of childs is not deleted");
			}
			// close session
			HibernateUtil.closeSession(ses);
		} // finally
	}// method


	/*@Override
	public void loadAllData() {
		Session ses = null;
		List<User> list=null;
		
		Query query=null;
		// Get Session
		ses = HibernateUtil.getSession();
		try {
		//execute Query
		query=ses.createQuery("from User");
		list=query.getResultList();
		list.forEach(user->{
			System.out.println("Parent::"+user);
			PhoneNumber childs[]=user.getPhones();
			for(PhoneNumber ph:childs) {
				System.out.println("child::"+ph);
			}
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
		

	}
*/
}// class
