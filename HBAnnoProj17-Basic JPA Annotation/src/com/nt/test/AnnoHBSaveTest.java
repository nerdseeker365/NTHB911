package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.College;
import com.nt.utility.HibernateUtil;

public class AnnoHBSaveTest {

	public static void main(String[] args) {
		Session ses=null;
		College clg=null;
		boolean flag=false;
		Transaction tx=null;
		int idVal=0;
		//get Session 
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
           clg=new College();
           clg.setId(44012);
           clg.setName("MfITTS");
           clg.setGrade("B");
           clg.setLocation("delhi");
           clg.setStrength(2000);
           //save obj
           idVal=(int) ses.save(clg);
           System.out.println("Generated id value::"+idVal);
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
				
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
