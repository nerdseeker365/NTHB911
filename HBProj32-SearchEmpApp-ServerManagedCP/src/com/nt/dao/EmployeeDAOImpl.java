package com.nt.dao;

import org.hibernate.Session;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public Employee findEmployee(int eno) {
		Session ses=null;
		Employee emp=null;
	  //get Session 
		ses=HibernateUtil.getSession();
		System.out.println("ses obj hashCode ::"+ses.hashCode());
		//Load object
		emp=ses.get(Employee.class,eno);
		return emp;
	}

}
