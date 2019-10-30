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
	public List<Employee> getEmpsBySalaryRange(int start, int end) {
		Session ses=null;
		ProcedureCall call=null;
		List<Employee>  list=null;
		Output output=null;
		
		try {
		//get Session 
		ses=HibernateUtil.getSession();
		//Create ProcedureCall obj having PL/SQL Function
		call=ses.createStoredProcedureCall("fx_getEmpsBySalaryRange1");
		//register IN,OUT params with JDBC types and set values to IN params
		call.registerParameter(3,Employee.class,ParameterMode.REF_CURSOR);
		call.registerParameter(1,Integer.class,ParameterMode.IN).bindValue(start);;
		call.registerParameter(2,Integer.class,ParameterMode.IN).bindValue(end);
		//call Pl/SQL procedure by executing Query
		output=call.getOutputs().getCurrent();
		//get Results from OUt params
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
