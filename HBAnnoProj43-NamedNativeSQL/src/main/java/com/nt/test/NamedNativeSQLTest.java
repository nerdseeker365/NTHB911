package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class NamedNativeSQLTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null,query1=null;
		List<InsurancePolicy> list=null;
		List<Object[]> list1=null;
	//get SEssion
		ses=HibernateUtil.getSession();
		try {
		//get Access to NamedNativeSQL Query
		query=ses.getNamedQuery("GET_ALL_POLICIES_BY_TENURE_RANGE");
		//((NativeQuery)query).addEntity(InsurancePolicy.class);
		//set values to query params
		query.setParameter(1,5);
		query.setParameter(2,20);
		//execute the Query
		list=query.list();
		//process the List Collection
		list.forEach(policy->{
			System.out.println(policy);
		});
		System.out.println("..........................");
		//get Access NamedNativeSQL query and execute it
		query1=ses.getNamedQuery("GET_POLICY_DETAILS_BY_NAMES");
		
		query1.setParameter("name1","raja");
		query1.setParameter("name2","ramesh");
		query1.setParameter("name3","mahesh");
		
		list1=query1.getResultList();
		list1.forEach(row->{
			for(Object val:row) {
				System.out.print(val+"  "+val.getClass());
			}
			System.out.println();
		});
		
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		
	}//main
}//class
