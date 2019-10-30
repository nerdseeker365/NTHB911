package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public Employee findEmployee(int eno) {
		Session ses=null,ses1=null;
		Employee emp=null;
		Transaction tx=null;
	  //get Session
		
		ses=HibernateUtil.getSession();
		ses1=HibernateUtil.getSession();
		try {
		tx=ses.beginTransaction();
		System.out.println("ses,ses1 objs hashCodes ::"+ses.hashCode()+"  "+ses1.hashCode());
		//Load object
		emp=ses.get(Employee.class,eno);
		}
		catch(HibernateException he) {
			throw he;
		}
		catch(Exception e) {
			throw e;
		}
		return emp;
	}

}
