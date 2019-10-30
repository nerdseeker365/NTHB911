package com.nt.dao;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public List<Object[]> getEmpsByEIDRange(int start, int end) {
		Session ses=null;
		ProcedureCall call=null;
		//List<Object[]>  list=null;
		List<Object[]> list=null;
		try {
		//get Session 
		ses=HibernateUtil.getSession();
		//Create Procedure representing PL/SQL proedure
		call=ses.createStoredProcedureCall("p_getEmployees_By_EId_Range");
		//register IN ,OUT params and set values to IN params
		call.registerParameter(1, Class.class,ParameterMode.REF_CURSOR);
		call.registerParameter(2,Integer.class, ParameterMode.IN).bindValue(start);
		call.registerParameter(3,Integer.class, ParameterMode.IN).bindValue(end);
		//pagination..
		call.setFirstResult(0);
		call.setMaxResults(2);
		list=call.getResultList();
		 
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
