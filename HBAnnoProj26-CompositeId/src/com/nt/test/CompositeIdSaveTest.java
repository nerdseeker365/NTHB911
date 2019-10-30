package com.nt.test;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PrgmrProjId;
import com.nt.entity.ProgrammerProjectInfo;
import com.nt.utility.HibernateUtil;

public class CompositeIdSaveTest {

	public static void main(String[] args) {
		Session ses=null;
		PrgmrProjId id=null,idVal=null;
		ProgrammerProjectInfo info=null;
		Transaction tx=null;
		boolean flag=false;
		 //get Session
		ses=HibernateUtil.getSession();
		//prepre Entity class object
		id=new PrgmrProjId();
		id.setPid(1002); id.setProjId(102);
		info=new ProgrammerProjectInfo();
		info.setId(id); info.setPname("Raja"); info.setProjName("proj1");
		try {
			tx=ses.beginTransaction();
			   idVal=(PrgmrProjId) ses.save(info);
			   System.out.println("Generated Id value::"+idVal);
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
				System.out.println("Object is saved with composite Id");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved");
			}
			//close objects
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
