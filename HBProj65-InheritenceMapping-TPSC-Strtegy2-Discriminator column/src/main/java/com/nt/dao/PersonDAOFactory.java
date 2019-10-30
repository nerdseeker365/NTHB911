package com.nt.dao;

public class PersonDAOFactory {
	public static  PersonDAO  getInstance(){
		return  new PersonDAOImpl();
	}

}
