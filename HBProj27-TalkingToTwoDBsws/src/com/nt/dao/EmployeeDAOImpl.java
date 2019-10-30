package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.MySQLHibernateUtil;
import com.nt.utility.OracleHibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void transferEmployee(int eno) {
		Session oraSes=null;
		Session mysqlSes=null;
		Employee emp=null;
		Transaction tx=null,tx1=null;
		boolean flag=false;
		//get Session objs
		oraSes=OracleHibernateUtil.getSession();
		mysqlSes=MySQLHibernateUtil.getSession();
		//Load object from oracle
		emp=oraSes.get(Employee.class, eno);
		if(emp==null) {
			System.out.println("Object is not found ");
			return;
		}
		//save object into mysql
		try {
			tx=mysqlSes.beginTransaction();
			tx1=oraSes.beginTransaction();
			  mysqlSes.save(emp); //save to mysql
			  oraSes.delete(emp); //delete from oracle
			flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				tx1.commit();
				System.out.println("Object copied");
			}
			else {
				tx.rollback();
				System.out.println("Object is not copied");
			}
			//close objs
			OracleHibernateUtil.closeSession(oraSes);
			MySQLHibernateUtil.closeSession(mysqlSes);
		}//finally
	}//method
}//class
