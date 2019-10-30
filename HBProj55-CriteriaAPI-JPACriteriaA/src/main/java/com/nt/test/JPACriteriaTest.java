package com.nt.test;


import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class JPACriteriaTest {

	public static void main(String[] args) {
		Session ses=null;
		List<InsurancePolicy> list=null;
		CriteriaBuilder builder=null;
		CriteriaQuery<InsurancePolicy> ctQuery=null;
		Root<InsurancePolicy> root=null;
		Query query=null;
		ParameterExpression<Integer> param1=null;
		ParameterExpression<Integer> param2=null;
		
		/*ParameterExpression<String> param1=null;
		ParameterExpression<String> param2=null;*/
		
		 //get Session 
		ses=HibernateUtil.getSession();
		try {
	       //create CriteriaBuilder object
			builder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
			ctQuery=builder.createQuery(InsurancePolicy.class);
			//create Root object
			root=ctQuery.from(InsurancePolicy.class);
			//add root object
			ctQuery.select(root);
			//prepare JPA Query object
			query=ses.createQuery(ctQuery);
			//perform pagination
			query.setFirstResult(4);
			query.setMaxResults(2);
			//execuste the Query
			list=query.getResultList();
			//process the results
			list.forEach(policy->{
				System.out.println(policy);
			});
			
		/*	 //create CriteriaBuilder object
				builder=ses.getCriteriaBuilder();
				//create CriteriaQuery object
				ctQuery=builder.createQuery(InsurancePolicy.class);
				//create Root object
				root=ctQuery.from(InsurancePolicy.class);
				ctQuery.select(root);
				// prepare parameters
				param1=builder.parameter(Integer.class);
				param2=builder.parameter(Integer.class);
				//create Conditions(Predicates)
				Predicate pcd1=builder.ge(root.get("policyId"),param1);
				Predicate pcd2=builder.le(root.get("policyId"),param2);
				Predicate andPcd=builder.and(pcd1,pcd2);
				//add conditions
				ctQuery.where(andPcd);
				//prepare and add Order
				Order order=builder.desc(root.get("policyName"));
				ctQuery.orderBy(order);
				  
				  //execute query
				  query=ses.createQuery(ctQuery);
				  //set param values
				  query.setParameter(param1,4000);
				  query.setParameter(param2,5000);
				  //execute the Query
				  list=query.getResultList();
				//process the results
					list.forEach(policy->{
						System.out.println(policy);
					});  
			*/
			
		/*	 //create CriteriaBuilder object
			builder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
			ctQuery=builder.createQuery(InsurancePolicy.class);
			//create Root object
			root=ctQuery.from(InsurancePolicy.class);
			ctQuery.select(root);
			// prepare parameters
			param1=builder.parameter(String.class);
			param2=builder.parameter(String.class);
			//prepare conditions(Predicates)
			Predicate pcd1=builder.equal(root.get("policyName"), param1);
			Predicate pcd2=builder.equal(root.get("policyName"), param2);
			Predicate orPcd=builder.or(pcd1,pcd2);
			ctQuery.where(orPcd);
			  //execute query
			  query=ses.createQuery(ctQuery);
			  //set param values
			  query.setParameter(param1,"JA");
			  query.setParameter(param2,"JS");
			  //execute the Query
			  list=query.getResultList();
			//process the results
				list.forEach(policy->{
					System.out.println(policy);
				});  */
			
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
