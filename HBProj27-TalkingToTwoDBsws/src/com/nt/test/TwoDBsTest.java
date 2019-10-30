package com.nt.test;

import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOFactory;
import com.nt.utility.MySQLHibernateUtil;
import com.nt.utility.OracleHibernateUtil;

public class TwoDBsTest {

	public static void main(String[] args) {
		EmployeeDAO dao=null;
		//get DAO
		dao=EmployeeDAOFactory.getInstance();
		//invoke method
		dao.transferEmployee(1);
		
		//close SessionFactory objs
		OracleHibernateUtil.closeSessionFactory();
		MySQLHibernateUtil.closeSessionFactory();
	}//main
}//class

