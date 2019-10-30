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

public class JPACriteriaTest1 {

	public static void main(String[] args) {
		Session ses=null;
		List<InsurancePolicy> list=null;
		List<Object[]> list1=null;
		CriteriaBuilder builder=null;
		CriteriaQuery<InsurancePolicy> ctQuery=null;
		CriteriaQuery<Object[]> ctQuery1=null;
		Root<InsurancePolicy> root=null;
		Query query=null;
		/*ParameterExpression<Integer> param1=null;
		ParameterExpression<Integer> param2=null;*/
		
		ParameterExpression<String> param1=null;
		ParameterExpression<String> param2=null;
		
		 //get Session 
		ses=HibernateUtil.getSession();
		try {
			/*//prepare QueryBuilder
			builder=ses.getCriteriaBuilder();
			//prepare CriteriaQuery object
			ctQuery=builder.createQuery(InsurancePolicy.class);
			//prepare Root obj specifying range
			root=ctQuery.from(InsurancePolicy.class);
			//sepcify col names
			ctQuery.multiselect(root.get("policyId"),root.get("policyName"));
			//prepare Parameter obj
			param1=builder.parameter(String.class);
			//prepare predicates (conditions)
			Predicate pcd1=builder.like(root.get("policyName"), param1);
			ctQuery.where(pcd1);
			//execute Query
			query=ses.createQuery(ctQuery);
			//set param values
			query.setParameter(param1,"%A");
			list=query.getResultList();
			list.forEach(policy->{
				System.out.println(policy.getPolicyId()+" "+policy.getPolicyName());
			});*/
			
			
			/*//prepare QueryBuilder
			builder=ses.getCriteriaBuilder();
			//prepare CriteriaQuery object
			ctQuery1=builder.createQuery(Object[].class);
			//prepare Root obj specifying range
			root=ctQuery1.from(InsurancePolicy.class);
			//sepcify col names
			ctQuery1.multiselect(root.get("policyId"),root.get("policyName"));
			//prepare Parameter obj
			param1=builder.parameter(String.class);
			//prepare predicates (conditions)
			Predicate pcd1=builder.like(root.get("policyName"), param1);
			ctQuery1.where(pcd1);
			//execute Query
			query=ses.createQuery(ctQuery1);
			//set param values
			query.setParameter(param1,"%A");
			list1=query.getResultList();
			list1.forEach(row->{
				for(Object val:row) {
					System.out.print(val+"    ");
				}
				System.out.println();
			});*/
			
			
			/*//prepare QueryBuilder
			builder=ses.getCriteriaBuilder();
			//prepare CriteriaQuery object
			ctQuery1=builder.createQuery(Object[].class);
			//prepare Root obj specifying range
			root=ctQuery1.from(InsurancePolicy.class);
			//specify aggragate results
			ctQuery1.multiselect(builder.count(root.get("policyId")));
			//Execute Query
			query=ses.createQuery(ctQuery1);
			list1=query.getResultList();
			System.out.println("record count::"+list1.get(0));*/
			
			//prepare QueryBuilder
			builder=ses.getCriteriaBuilder();
			//prepare CriteriaQuery object
			ctQuery1=builder.createQuery(Object[].class);
			//prepare Root obj specifying range
			root=ctQuery1.from(InsurancePolicy.class);
			//specify aggragate results
			ctQuery1.multiselect(builder.min(root.get("tenure")),
					                                  builder.sum(root.get("tenure")),
			                                		  builder.max(root.get("tenure")));
			//Execute Query
			query=ses.createQuery(ctQuery1);
			list1=query.getResultList();
			Object[] results=list1.get(0);
			System.out.println("min of tenure ::"+results[0]);
			System.out.println("sum of tenure ::"+results[1]);
			System.out.println("max of tenure ::"+results[2]);
			
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
