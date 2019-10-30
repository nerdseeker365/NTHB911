package com.nt.test;

import com.nt.dao.PaymentDAO;
import com.nt.dao.PaymentDAOFactory;
import com.nt.utility.HibernateUtil;

public class InhMappingTest {

	public static void main(String[] args) {
		PaymentDAO dao=null;
	   //get DAO object
		dao=PaymentDAOFactory.getInstance();
		dao.saveData();
		//dao.loadData();
		
		//close session fActory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
