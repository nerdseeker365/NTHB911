package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.JobDetails;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class ComponentMappingDAOImpl implements ComponentMappingDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Person per=null;
		JobDetails job=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		job=new JobDetails();
		job.setDesg("CLERK");
		job.setSalary(90000);
		job.setCompany("HCL");
		per=new Person();
		per.setPname("raja");
		per.setDetails(job);
		//save object
		try {
			tx=ses.beginTransaction();
			  ses.save(per);
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
				System.out.println("Data saved");
			}
			else {
				tx.rollback();
				System.out.println("Data not saved");
			}
			//close objs
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void loadData() {
		Session ses=null;
		Person per=null;
		JobDetails job=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
		//Load object
		per=ses.get(Person.class,1);
		System.out.println(per.getPid()+" "+per.getPname());
		job=per.getDetails();
		System.out.println(job.getDesg()+"  "+job.getSalary()+"  "+job.getCompany());
		}
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
	
	
}//class
