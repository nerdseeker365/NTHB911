package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.EmployeeLOB;
import com.nt.utility.FileUtility;
import com.nt.utility.HibernateUtil;

public class LOBRetriveTest {

	public static void main(String[] args) {
		Session ses=null;
		java.sql.Blob blob=null;
		java.sql.Clob clob=null;
		EmployeeLOB empLOB=null;
		try {
		//get SEssion session 
		ses=HibernateUtil.getSession();
		  //Load object
		empLOB=ses.get(EmployeeLOB.class,142);
		System.out.println(empLOB.getEid()+"  "+empLOB.getEname()+empLOB.getSalary());
		blob=empLOB.getEphoto();
		clob=empLOB.getEresume();
		//convert blob,clob values to files....
		System.out.println(FileUtility.createFileFromBlob(blob, "superStar.jpg"));
		System.out.println(FileUtility.createFileFromClob(clob, "myResume.txt"));
		
		
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
		
	}//main
}//class
