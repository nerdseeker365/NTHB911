package com.nt.test;

import com.nt.dao.OneToOneDAO;
import com.nt.dao.OneToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToOneTest {

	public static void main(String[] args) {
		OneToOneDAO dao=null;
		  //get DAO
		dao=OneToOneDAOFactory.getInstance();
		//invoke method
		dao.saveData();
		  //close SessionFactory
		  HibernateUtil.closeSessionFactory();
	}

}
