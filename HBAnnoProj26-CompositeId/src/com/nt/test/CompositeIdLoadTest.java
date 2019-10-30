package com.nt.test;


import org.hibernate.Session;

import com.nt.entity.PrgmrProjId;
import com.nt.entity.ProgrammerProjectInfo;
import com.nt.utility.HibernateUtil;

public class CompositeIdLoadTest {

	public static void main(String[] args) {
		Session ses=null;
		PrgmrProjId id=null;
		ProgrammerProjectInfo info=null;
	    
		 //get Session
		ses=HibernateUtil.getSession();
		//prepare id value
		id=new PrgmrProjId();
		id.setPid(1002);id.setProjId(102);
		try {
			//get/load the object
			info=ses.get(ProgrammerProjectInfo.class, id);
			if(info!=null)
			   System.out.println(info);
			else
				System.out.println("record not found");
		}
		finally {
			//close objects
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
