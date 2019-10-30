package com.nt.test;

import com.nt.dao.AuthenticationDAO;
import com.nt.factory.AuthenticationDAOFactory;
import com.nt.utility.HibernateUtil;

public class AuthenticationTest {

	public static void main(String[] args) {
		AuthenticationDAO dao=null;
		//get DAO
		dao=AuthenticationDAOFactory.getInstance();
		//invoke method
		System.out.println("Result is::"+dao.validate("raja1","rani"));
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	

	}

}
