package com.nt.test;

import com.nt.dao.OneToManyBiDAO;
import com.nt.dao.OneToManyBiDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToManyBiTest {

	public static void main(String[] args) {
		OneToManyBiDAO dao=null;
		//get DAO
		dao=OneToManyBiDAOFactory.getInstance();
		//invoke methods
		  //dao.loadDataUsingParentSideJoins();
		//dao.loadDataUsingParent();
		//dao.loadDataUsingQBC();
		dao.loadDataUsingJPAQBC();
		 
		 //close session factory
		 HibernateUtil.closeSessionFactory();

	}//main
}//class
