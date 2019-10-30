package com.nt.test;

import com.nt.dao.NGOOperationsDAO;
import com.nt.factory.NGODAOFactory;
import com.nt.utility.HibernateUtil;

public class HQLInsertTest {

	public static void main(String[] args) {
		NGOOperationsDAO dao=null;
		int count=0;
		//get DAO
		dao=NGODAOFactory.getInstance();
		//invoke method
			count=dao.transferEmpsToNGOs(5000,10000);
			System.out.println("Number of Employees  changed to NGOs ::"+count);
			
			//close SessionFactory
			HibernateUtil.closeSessionFactory();
	}//main
}//class
