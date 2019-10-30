package com.nt.dao;

public class OneToManyBiDAOFactory {
    public static OneToManyBiDAO  getInstance() {
    	return new OneToManyBiDAOImpl();
    }
}
