package com.nt.test;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class CriteriaTest {

	public static void main(String[] args) {
		Session ses=null;
		Criteria criteria=null;
		List<InsurancePolicy> list=null;
		Criterion cond1=null,cond2=null,cond3=null,orCond=null,andCond=null;
		Order order=null;
		 //get Session 
		ses=HibernateUtil.getSession();
		try {
		/*//create Criteria object
		criteria=ses.createCriteria(InsurancePolicy.class);
		//execute QBC
		list=criteria.list();
		//process the Result
		list.forEach(policy->{
			System.out.println(policy);
		});*/
			
			/*//create Criteria obj having and clause condition
			criteria=ses.createCriteria(InsurancePolicy.class);
			//prepare Condition (Criterion obj)
			criterion1=Restrictions.ge("tenure",10);
			criterion2=Restrictions.le("tenure",50);
			
			//add Criterion obj
			criteria.add(criterion1);
			criteria.add(criterion2);
			//execute Criteria obj
			list=criteria.list();
			//process the result
			list.forEach(policy->{
				System.out.println(policy);
			});*/
			
			
		/*	//create Criteria obj having and clause condition
			criteria=ses.createCriteria(InsurancePolicy.class);
			//prepare Condition (Criterion obj)
			criterion1=Restrictions.eq("policyName","JA");
			criterion2=Restrictions.eq("policyName","JS");
			orCriterion=Restrictions.or(criterion1,criterion2);
			//add Criterion obj
			criteria.add(orCriterion);
			//execute Criteria obj
			list=criteria.list();
			//process the result
			list.forEach(policy->{
				System.out.println(policy);
			});
			*/
			/*//Create Criteria object
			criteria=ses.createCriteria(InsurancePolicy.class);
			//prepare Criterion objects
			cond1=Restrictions.ilike("policyName","j%");
			cond2=Restrictions.in("policyHolderName","raja","ravi");
			andCond=Restrictions.and(cond1,cond2);
			cond3=Restrictions.between("policyId", 100, 200);
			orCond=Restrictions.or(andCond,cond3);
			//add conditions
			criteria.add(orCond);
			//execute logics
			list=criteria.list();
			//process the results
			list.forEach(policy->{
				System.out.println(policy);
			});
			*/
		/*	//create Criteria object
			criteria=ses.createCriteria(InsurancePolicy.class);
			//prepare condition
			cond1=Restrictions.sqlRestriction(" tenure>=:min and tenure<=:max",
					                                                        new Object[] {5,20},
					                                                        new Type[] {new IntegerType(),new IntegerType()});
			//add condition
			criteria.add(cond1)	;
			//execute QBC logic
			list=criteria.list();
			//process the reuslt
			list.forEach(policy->{
				System.out.println(policy);
			});*/
			
/*			//create Criteria object
			criteria=ses.createCriteria(InsurancePolicy.class);
			//perform pagination
			criteria.setFirstResult(0);
			criteria.setMaxResults(2);
			//execute QBC
			list=criteria.list();
		
			//process the Result
			list.forEach(policy->{
				System.out.println(policy);
			});
*/			
			//create Criteria object
			criteria=ses.createCriteria(InsurancePolicy.class);
			//Create Order object
			order=Order.asc("policyName");
			//add Order obj
			criteria.addOrder(order);
			//execute QBC
			list=criteria.list();
		
			//process the Result
			list.forEach(policy->{
				System.out.println(policy);
			});
				
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		

	}

}
