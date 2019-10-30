package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.JobDetails;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class ComponentMappingDAOImpl implements ComponentMappingDAO {
  private static final   String HQL_ALL_PERSONS="from Person";
  private static final String HQL_ALL_PERSONS_BY_DESG="from Person where details.desg=:dsg";
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
		job.setDesg("MANAGER");
		job.setSalary(70000);
		job.setCompany("TCS");
		per=new Person();
		per.setPname("rajesh");
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
	
	@Override
	public void loadAllData() {
		Session ses=null;
		Query query=null;
		List<Person> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
		 //execute HQL Query
			query=ses.createQuery(HQL_ALL_PERSONS);
			list=query.getResultList();
			list.forEach(per->{
				System.out.println(per.getPid()+"  "+per.getPname());
				System.out.println(per.getDetails().getDesg()+"  "+per.getDetails().getCompany()+" "+per.getDetails().getSalary());
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
		} //finally
	}//method
	
	@Override
		public void loadDataByDesg(String desg) {
		Session ses=null;
		Query query=null;
		List<Person> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
		 //execute HQL Query
			query=ses.createQuery(HQL_ALL_PERSONS_BY_DESG);
			query.setParameter("dsg", desg);
			list=query.getResultList();
			list.forEach(per->{
				System.out.println(per);
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
		}//method
}//class
