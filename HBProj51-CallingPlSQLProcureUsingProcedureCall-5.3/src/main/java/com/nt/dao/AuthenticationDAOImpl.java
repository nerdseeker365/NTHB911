package com.nt.dao;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;

import com.nt.utility.HibernateUtil;

public class AuthenticationDAOImpl implements AuthenticationDAO {

	@Override
	public String validate(String username, String password) {
		Session ses=null;
		String result=null;
		ProcedureCall call=null;
		Output output=null;
		List<String> list=null;
		try {
		//get Session
		ses=HibernateUtil.getSession();
		//create Procedure Call obj
		call=ses.createStoredProcedureCall("p_Authentication");
		//register IN,OUT params and also set values to IN Params
		call.registerParameter(1, String.class,ParameterMode.IN).bindValue(username);
		call.registerParameter(2, String.class,ParameterMode.IN).bindValue(password);
		call.registerParameter(3,String.class,ParameterMode.OUT);
		//call Procedure
		result=(String) call.getOutputParameterValue(3);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
		return result;
	}//metohod
}//class
