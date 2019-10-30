package com.nt.test;

import java.util.List;

import com.nt.dao.OneToOneFKDAO;
import com.nt.dao.OneToOneFKDAOFactory;
import com.nt.entity.License;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class OneToOneFKTest {

	public static void main(String[] args) {
		OneToOneFKDAO dao=null;
		List<License> list=null;
		int id=0;
		//get DAO
		dao=OneToOneFKDAOFactory.getInstance();
		//invoke method
		dao.saveDataUsingChild();
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
