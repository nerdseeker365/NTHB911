package com.nt.test;

import java.util.List;

import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOFactory;
import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class CallingPLSQLProcedureTest {

	public static void main(String[] args) {
		EmployeeDAO dao=null;
		List<Employee> list=null;
		//get DAO
		dao=EmployeeDAOFactory.getInstance();
		//invoke method
		list=dao.getEmpsByEIDRange(100,200);
	    //process the results
		list.forEach(emp->{
			System.out.println(emp);
		});
		//close SEssion Factory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
