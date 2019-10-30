package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class GeneratorsTest_HILO {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Student st=null;
		int idVal=0;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			//begin Tx
			tx=ses.beginTransaction();
			for(int i=1;i<=10;++i) {
			   st=new Student();
			   st.setSname("Rajesh"+i);
			   st.setSadd("hyd");
			    if(i==5)
			    	Thread.sleep(30000);
			    
			  idVal=(int) ses.save(st);
			   System.out.println("Generated id value::"+idVal);
			flag=true;
		   }//for
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
			//commit or rollback Tx
			if(flag) {
				tx.commit();
				System.out.println("Object is saved");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved");
			}
			//close Session,SessionFactory objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally

	}//main
}//class
