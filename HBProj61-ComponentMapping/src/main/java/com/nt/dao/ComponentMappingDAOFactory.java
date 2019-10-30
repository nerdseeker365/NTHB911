package com.nt.dao;

public class ComponentMappingDAOFactory {
	public static  ComponentMappingDAO  getInstance() {
		return new ComponentMappingDAOImpl();
	}

}
