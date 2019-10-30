package com.nt.test;

import com.nt.dao.OneToManyDAO;
import com.nt.dao.OneToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToManyTest {

	public static void main(String[] args) {
		OneToManyDAO dao=null;
	   //get DAO
		dao=OneToManyDAOFactory.getInstance();
		//invoke methods
		//dao.insertData();
		//dao.loadData();
		//dao.loadAllData();
		//dao.removeParentAndChild();
		//dao.removeOneChildFromCollectionOfChildsOfAParent();
		dao.removeAllChildsOfAParent();
		//close SessionFactory
		HibernateUtil.closeSessionFactory();

	}

}
