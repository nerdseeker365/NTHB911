package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Programmer;
import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class ManyToManyDAOImpl implements ManyToManyDAO {

		
	@Override
	public void saveDataUsingChild() {
		Session ses=null;
		Programmer prgmr1=null,prgmr2=null,prgmr3=null;
		Project proj1=null,proj2=null;
		Transaction tx=null;
		boolean flag=false;
		// Get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		prgmr1=new Programmer();
		prgmr1.setPname("rani");
		prgmr1.setSalary(60000);
		
		prgmr2=new Programmer();
		prgmr2.setPname("ravi");
		prgmr2.setSalary(74000);
		
		prgmr3=new Programmer();
		prgmr3.setPname("raghu");
		prgmr3.setSalary(5000);
		
		proj1=new Project();
		proj1.setProjName("proj3");
		proj1.setClientName("citiBank");
		
		proj2=new Project();
		proj2.setProjName("proj3");
		proj2.setClientName("SBI");
		
		//add childs  to parent and parent to childs
		prgmr1.getProjects().add(proj1);
		prgmr1.getProjects().add(proj2);
		
		prgmr2.getProjects().add(proj2);
		
		prgmr3.getProjects().add(proj1);
		prgmr3.getProjects().add(proj2);
		
		proj1.getProgrammers().add(prgmr1);
		proj1.getProgrammers().add(prgmr3);
		proj2.getProgrammers().add(prgmr1);
		proj2.getProgrammers().add(prgmr2);
		proj2.getProgrammers().add(prgmr3);
		
		try {
			tx=ses.beginTransaction();
          		ses.save(proj1); ses.save(proj2);
          		flag=true;
		}
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
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
		
}//class
