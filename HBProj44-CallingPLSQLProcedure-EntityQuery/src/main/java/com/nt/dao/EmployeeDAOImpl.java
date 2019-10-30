package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public List<Employee> getEmpsByEIDRange(int start, int end) {
		Session ses=null;
		NativeQuery query=null;
		List<Employee>  list=null;
		try {
		//get Session 
		ses=HibernateUtil.getSession();
		//get Access to Named Query
		query=ses.getNamedNativeQuery("CALL_PRO");
		//set query param values
		query.setParameter("min",start);
		query.setParameter("max",end);
		//call Pl/SQL procedure by executing Query
		list=query.list();
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close session
			HibernateUtil.closeSession(ses);
		}
		
		return list;
	}//method

}//class
