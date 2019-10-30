package com.nt.dao;

import java.util.List;

import org.dom4j.dom.DOMNodeHelper.EmptyNodeList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Department;
import com.nt.entity.EmpDetails;
import com.nt.utility.HibernateUtil;

public class ManyToOneDAOImpl implements ManyToOneDAO {

	public void saveData() {
		Session ses=null;
		Transaction tx=null;
		Department dept=null;
		EmpDetails emp1=null,emp2=null;
		boolean flag=false;
		//get Session 
		ses=HibernateUtil.getSession();
		//prepare objects
		dept=new Department();
		//parent object
		dept.setDeptName("IT");
		dept.setDeptLoc("hyd");
		//child objs
		emp1=new EmpDetails();
		emp1.setEmpName("raja");
		emp1.setSalary(9000);
		
		emp2=new EmpDetails();
		emp2.setEmpName("ravi");
		emp2.setSalary(8000);
		//map parent to childs
		emp1.setDept(dept);
		emp2.setDept(dept);
		
		try {
			tx=ses.beginTransaction();
			  ses.save(emp1);
			  ses.save(emp2);
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			 if(flag) {
				 tx.commit();
				 System.out.println("Objects are saved (Child - parent)");
			 }
			 else {
				 tx.rollback();
				 System.out.println("Object are not saved");
			 }
			//close  obj
			 HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	public void loadData() {
		Session ses=null;
		Query query=null;
		List<EmpDetails> list=null;
		//get Session 
		ses=HibernateUtil.getSession();
		try {
		//prepare and execute Query
		query=ses.createQuery("from EmpDetails");
		list=query.getResultList();
		list.forEach(emp->{
			System.out.println("child::"+emp);
			Department dept=emp.getDept();
			System.out.println("parent::"+dept+"   "+dept.getClass());
     	});
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void addNewChildToExistingParent() {
		Session ses=null;
		Transaction tx=null;
		Department dept=null;
		EmpDetails emp=null;
		boolean flag=false;
		//get Session 
		ses=HibernateUtil.getSession();
		//load existing parent
		dept=ses.get(Department.class,1);
		//create new child
		emp=new EmpDetails();
		emp.setEmpName("anil");
		emp.setSalary(8000);
		emp.setDept(dept);
		try {
			//begin Tx
			tx=ses.beginTransaction();
	          ses.save(emp);
		  flag=true;
	}
	catch(HibernateException he) {
		he.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		 if(flag) {
			 tx.commit();
			 System.out.println("child added to parent");
		 }
		 else {
			 tx.rollback();
			 System.out.println("Child not added to parent");
		 }
		//close session
		HibernateUtil.closeSession(ses);
	}//finally
		
	}//method
	
	@Override
	public void addExistingChildToNewParent() {
		Session ses=null;
		Transaction tx=null;
		Department dept=null;
		EmpDetails emp=null;
		boolean flag=false;
		//get Session 
		ses=HibernateUtil.getSession();
		//Load existing Child
		emp=ses.get(EmpDetails.class, 101);
		//create new Parent obj
		dept=new Department();
		dept.setDeptName("CS");
		dept.setDeptLoc("hyd");
		emp.setDept(dept);
		try {
			//begin Tx
			tx=ses.beginTransaction();
	          ses.update(emp);
		  flag=true;
	}
	catch(HibernateException he) {
		he.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		 if(flag) {
			 tx.commit();
			 System.out.println("child is moved new parent");
		 }
		 else {
			 tx.rollback();
			 System.out.println("Child not moved new parent");
		 }
		//close session
		HibernateUtil.closeSession(ses);
	}//finally
	}//method
	
     @Override
     	public void deleteOneChildOfAParent() {
    	/* Session ses=null;
 		Transaction tx=null;
 		EmpDetails emp=null;
 		boolean flag=false;
 		//get Session 
 		ses=HibernateUtil.getSession();
 		//get Child obj from DB s/w
 		emp=ses.get(EmpDetails.class,102);
 		try {
 			tx=ses.beginTransaction();
 			 ses.delete(emp);
 			flag=true;
 		}
 		catch(HibernateException he) {
 			he.printStackTrace();
 		}
 		catch(Exception e) {
 			e.printStackTrace();
 		}
 		finally {
 			if(flag) {
 				tx.commit();
 				System.out.println("Child-parent objs deleted");
 			}
 			else {
 				tx.rollback();
 				System.out.println("Child-parent Objs are not deleted");
 			}
 			//close Session
 			HibernateUtil.closeSession(ses);
 		}//finally
*/     		
    /*	 Session ses=null;
  		Transaction tx=null;
  		EmpDetails emp=null;
  		boolean flag=false;
  		//get Session 
  		ses=HibernateUtil.getSession();
  		//prepare Child obj
  		emp=new EmpDetails();
  		emp.setEmpNo(102);
  		try {
  			tx=ses.beginTransaction();
  			 ses.delete(emp);
  			flag=true;
  		}
  		catch(HibernateException he) {
  			he.printStackTrace();
  		}
  		catch(Exception e) {
  			e.printStackTrace();
  		}
  		finally {
  			if(flag) {
  				tx.commit();
  				System.out.println("Child-parent objs deleted");
  			}
  			else {
  				tx.rollback();
  				System.out.println("Child-parent Objs are not deleted");
  			}
  			//close Session
  			HibernateUtil.closeSession(ses);
  		}//finally
*/    	 
    	 
    	 Session ses=null;
   		Transaction tx=null;
   		EmpDetails emp=null;
   		boolean flag=false;
   		Query query=null;
   		//get Session 
   		ses=HibernateUtil.getSession();
   		//prepare and execute HQL query
   		query=ses.createQuery("delete from EmpDetails where empno=:no");
   		query.setParameter("no",100);
   		try {
  			tx=ses.beginTransaction();
  			 int result=query.executeUpdate();
  			flag=true;
  		}
  		catch(HibernateException he) {
  			he.printStackTrace();
  		}
  		catch(Exception e) {
  			e.printStackTrace();
  		}
  		finally {
  			if(flag) {
  				tx.commit();
  				System.out.println("Child-parent objs deleted");
  			}
  			else {
  				tx.rollback();
  				System.out.println("Child-parent Objs are not deleted");
  			}
  			//close Session
  			HibernateUtil.closeSession(ses);
  		}//finally
    	 
    	 
     	}	//method
}//class
