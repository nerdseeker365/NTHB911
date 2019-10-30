package com.nt.test;

import com.nt.dao.PersonDAO;
import com.nt.dao.PersonDAOFactory;
import com.nt.utility.HibernateUtil;

public class InheritenceMappingTest {

	public static void main(String[] args) {
		PersonDAO  dao=null;
		//get DAO
		dao=PersonDAOFactory.getInstance();
		//invoke methods
		//dao.saveData();
		dao.loadData();
		//close SessionFactory
		HibernateUtil.closeSessionFactory();

	}

}
