package com.nt.test;

import com.nt.dao.ManyToOneDAO;
import com.nt.dao.ManyToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class ManyToOneTest {

	public static void main(String[] args) {
		ManyToOneDAO dao=null;
		 //get DAO
		dao=ManyToOneDAOFactory.getInstance();
		//invoke methods
		//dao.saveData();
		 dao.loadData();
		//close sessionFactory
		HibernateUtil.closeSessionFactory();

	}

}
