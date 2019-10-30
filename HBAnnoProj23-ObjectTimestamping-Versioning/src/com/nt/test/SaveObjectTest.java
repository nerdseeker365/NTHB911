package com.nt.test;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.StockInfo;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		StockInfo info=null;
		int idVal=0;
		//get Session
		ses=HibernateUtil.getSession();
		//Save object
		try {
			tx=ses.beginTransaction();
			 //prepare object
			info=new StockInfo();
			info.setStockName("ICICI-Insurance");
			info.setCompany("ICICI");
			info.setPrice(9000);
			//save object
			idVal=(int) ses.save(info);
			System.out.println("Generated id vlaue::"+idVal);
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
				System.out.println("Object is saved at::"+info.getListingTime());
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved");
			}
			//close jdbc objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
