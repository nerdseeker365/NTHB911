package com.nt.test;

import com.nt.dao.ManyToManyDAO;
import com.nt.dao.ManyToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class ManyToManyTest {

	public static void main(String[] args) {
		ManyToManyDAO dao=null;
		  //get DAO 
		dao=ManyToManyDAOFactory.getInstance();
		//invoke method
		   //dao.saveDataUsingParent();
		   dao.saveDataUsingChild();
	
		  
		  //close SessionFactory
		  HibernateUtil.closeSessionFactory();
	}//main
}//class
