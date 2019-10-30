package com.nt.test;


import java.util.List;

import javax.persistence.Parameter;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class JPACriteriaUpdateTest {

	public static void main(String[] args) {
		Session ses=null;
		List<InsurancePolicy> list=null;
		CriteriaBuilder builder=null;
		CriteriaUpdate<InsurancePolicy> ctUpdate=null;
		Root<InsurancePolicy> root=null;
		Query query=null;
		Predicate  pdc1=null;
		int count=0;
		Transaction tx=null;
		boolean flag=false;
		
		
		 //get Session 
		ses=HibernateUtil.getSession();
		try {
			//create CriteriaBuilder obj
			builder=ses.getCriteriaBuilder();
			//create CriterUpdate obj
			ctUpdate=builder.createCriteriaUpdate(InsurancePolicy.class);
			//create Root object
			root=ctUpdate.from(InsurancePolicy.class);
			//update specific col vlaues
			 ctUpdate.set("tenure",90);
			//write condition
			pdc1=builder.equal(root.get("policyName"), "JA");
			ctUpdate.where(pdc1);
			//execute Query
			query=ses.createQuery(ctUpdate);
			//set param values
			tx=ses.beginTransaction();
			 count=query.executeUpdate();
			flag=true;
		}
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
				System.out.println(count+" no.of records are updated");
			}
			else {
				tx.rollback();
				System.out.println("records not found");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
