package com.nt.test;

import com.nt.dao.OneToManyDAO;
import com.nt.dao.OneToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToManyTest {

	public static void main(String[] args) {
		OneToManyDAO dao=null;
		//get DAO
		dao=OneToManyDAOFactory.getInstance();
		//save object
		//dao.saveDataUsingParents();
		dao.saveDataUsingChilds();
		
		//close SEssionFactory
		HibernateUtil.closeSessionFactory();
	}
}
