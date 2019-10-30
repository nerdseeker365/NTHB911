package com.nt.test;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class Criteria_ProjectionTest {

	public static void main(String[] args) {
		Session ses=null;
		Criteria  criteria=null;
		Projection p1=null,p2=null,p3=null;
		ProjectionList pList=null;
		List<Object[]> list=null;
		Criterion cond1=null,cond2=null;
		Order order=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			
			/*//create Criteria object
			criteria=ses.createCriteria(InsurancePolicy.class);
			//prepare conditions
			cond1=Restrictions.between("policyId",1000,2000);
			//add condition
			criteria.add(cond1);
			//Create Projection objs
			p1=Projections.property("policyId");
			p2=Projections.property("policyName");
			pList=Projections.projectionList();
			pList.add(p1); pList.add(p2);
			//set ProjectionList to criteria obj
			criteria.setProjection(pList);
			
			
			//add Order 
			order=Order.desc("policyId");
			criteria.addOrder(order);
			//execute logics
			list=criteria.list();
			//process the results
			list.forEach(row->{
				for(Object val:row) {
					System.out.print(val+"  ");
				}
				System.out.println();
			});*/
			
			/*//create Criteria object
			 criteria=ses.createCriteria(InsurancePolicy.class);
			 //prepare Projection
			 p1=Projections.rowCount();
			 //add Projection Criteria
			 criteria.setProjection(p1);
			 //execute Logics
			 list=criteria.list();
			 //process the results
			 System.out.println("Records count::"+list.get(0));*/
			
			//Working with mulitple aggragate  Results
			//create Criteria object
			 criteria=ses.createCriteria(InsurancePolicy.class);
			 //prepare Projections
			 p1=Projections.avg("tenure");
			 p2=Projections.max("tenure");
			 p3=Projections.min("tenure");
			 //add Projections to ProjectionList
			 pList=Projections.projectionList();
			 pList.add(p1); pList.add(p2); pList.add(p3);
			
			 //add ProjectionList to Criteria
			 criteria.setProjection(pList);
			 //execute Logics
			 list=criteria.list();
			 //process the results
			 Object row[]=list.get(0);
			 System.out.println("avg value of tenure col::"+row[0]);
			 System.out.println("max value of tenure col::"+row[1]);
			 System.out.println("min value of tenure col::"+row[2]);
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
