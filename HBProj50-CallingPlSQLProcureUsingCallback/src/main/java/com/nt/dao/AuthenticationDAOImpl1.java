package com.nt.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;

import com.nt.utility.HibernateUtil;

public class AuthenticationDAOImpl1 implements AuthenticationDAO {
	private static final  String  AUTH_CALL_QUERY="{ call p_authentication(?,?,?)}";

	@Override
	public String validate(String username, String password) {
		Session ses=null;
		String result=null;
		try {
		//get Session
		ses=HibernateUtil.getSession();
		//call Pl/sql Procedure
		result=ses.doReturningWork(new ReturningWork<String>() {

			@Override
			public String execute(Connection con) throws SQLException {
				CallableStatement  cs=null;
				String result=null;
				//create CallableStatement obj
				cs=con.prepareCall(AUTH_CALL_QUERY);
				//register OUT pararams with JDBC type
				cs.registerOutParameter(3,Types.VARCHAR);
				//set in param values
				cs.setString(1,username);
				cs.setString(2,password);
				//call PL/sQL procedure
				cs.execute();
				//gather results from OUT params
				result=cs.getString(3);
			return result;
			}//execute
     	  }//anonymous inner class
		);//method call
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
		return result;
	}
}
