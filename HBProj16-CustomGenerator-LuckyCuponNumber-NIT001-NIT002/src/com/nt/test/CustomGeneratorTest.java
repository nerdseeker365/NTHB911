package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.LuckyDrawCupon;
import com.nt.utility.HibernateUtil;

public class CustomGeneratorTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		LuckyDrawCupon cupon=null;
		String idVal=null;
	  //get Session
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
			//save obj
			cupon=new LuckyDrawCupon();
			cupon.setCustMobileNo(92999979L);
			cupon.setCustAddrs("hyd");
			cupon.setCustName("rajesh");
			idVal=(String) ses.save(cupon);
			System.out.println("Generated id value:::"+idVal);
			flag=true;
		}//try
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				tx.commit();
				System.out.println("Object saved");
			}
			else {
				tx.rollback();
				System.out.println("object is not saved");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally

	}//main
}//class
