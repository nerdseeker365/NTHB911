package com.nt.dao;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;

import com.nt.utility.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public List<Object[]> getEmpsBySalaryRange(int start, int end) {
		Session ses=null;
       ProcedureCall call=null;
		List<Object[]>list=null;
		Output output=null;
		try {
		//get Session 
		ses=HibernateUtil.getSession();
		//create PrcoedureCall obj
		call=ses.createStoredProcedureCall("p_getEmpsBySalaryRange2");
		//register BOTH OUT,IN Params and set values IN params
		call.registerParameter(1,Integer.class,ParameterMode.IN).bindValue(start);
		call.registerParameter(2,Integer.class,ParameterMode.IN).bindValue(end);
		call.registerParameter(3,Class.class,ParameterMode.REF_CURSOR);
		//execute PL/SQL procedure
		output=call.getOutputs().getCurrent();
		//Get results from OutParmas
		list=((ResultSetOutput)output).getResultList();
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close session
			HibernateUtil.closeSession(ses);
		}
		return list;
	}//method

}//class
