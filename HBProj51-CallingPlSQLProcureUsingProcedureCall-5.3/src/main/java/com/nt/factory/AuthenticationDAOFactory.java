package com.nt.factory;

import com.nt.dao.AuthenticationDAO;
import com.nt.dao.AuthenticationDAOImpl;

public class AuthenticationDAOFactory {
    public  static   AuthenticationDAO  getInstance() {
    	return  new AuthenticationDAOImpl();
    	
    }
}
