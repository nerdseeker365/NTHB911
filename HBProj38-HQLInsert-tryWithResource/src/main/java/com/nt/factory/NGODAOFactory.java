package com.nt.factory;

import com.nt.dao.NGOOperationsDAO;
import com.nt.dao.NGOOperationsDAOImpl;

public class NGODAOFactory {
	
	public static NGOOperationsDAO getInstance() {
		return new NGOOperationsDAOImpl();
	}
	

}
