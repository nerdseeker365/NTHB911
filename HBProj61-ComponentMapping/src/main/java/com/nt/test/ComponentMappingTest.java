package com.nt.test;

import com.nt.dao.ComponentMappingDAO;
import com.nt.dao.ComponentMappingDAOFactory;
import com.nt.utility.HibernateUtil;

public class ComponentMappingTest {

	public static void main(String[] args) {
		ComponentMappingDAO dao=null;
		//get DAO
		dao=ComponentMappingDAOFactory.getInstance();
		//invoke the method
		//dao.saveData();
		dao.loadData();
		//close session factory
		HibernateUtil.closeSessionFactory();

	}

}
