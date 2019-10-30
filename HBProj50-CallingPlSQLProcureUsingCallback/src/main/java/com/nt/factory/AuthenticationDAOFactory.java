package com.nt.factory;

import com.nt.dao.AuthenticationDAO;
import com.nt.dao.AuthenticationDAOImpl2;

public class AuthenticationDAOFactory {
    public  static   AuthenticationDAO  getInstance() {
    	//return  new AuthenticationDAOImpl();
    	//return  new AuthenticationDAOImpl1();
    	return  new AuthenticationDAOImpl2();
    }
}
