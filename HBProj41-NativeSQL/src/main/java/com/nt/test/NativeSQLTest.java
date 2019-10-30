package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class NativeSQLTest {

	public static void main(String[] args) {
		Session ses=null;
        NativeQuery query=null,query1=null,query2=null,query3=null,query4=null;
        List<Object[]> list=null;
        List<InsurancePolicy> list1=null;
        List<?> list2=null;
		//get Session
		ses=HibernateUtil.getSession();
		//create SQLQuery obj
		query=ses.createSQLQuery("SELECT * FROM  INSURANCEPOLICY");
		//execute Query
		list=query.list();
		//Iterator it=query.iterate();
		//process the List
		list.forEach(row->{
			for(Object val:row) {
				System.out.print(val+" ");
			}//for
			System.out.println();
		});//for
		System.out.println(".................................................");
		query1=ses.createSQLQuery("SELECT * FROM INSURANCEPOLICY");
		query1.addEntity(InsurancePolicy.class);
		list1=query1.list();
		list1.forEach(policy->{
			System.out.println(policy);
		});
		System.out.println("..............................................");
		//query2=ses.createSQLQuery("SELECT POLICYID,POLICYNAME FROM INSURANCEPOLICY WHERE POLICYID>=?1 AND POLICYID<=?2" );
		query2=ses.createSQLQuery("SELECT POLICYID,POLICYNAME FROM INSURANCEPOLICY WHERE POLICYID>=:start AND POLICYID<=:end" );
		//set param values
		//query2.setParameter(1,1000);
		//query2.setParameter(2,2000);
		query2.setParameter("start",1000);
		query2.setParameter("end",2000);

		//map results with hibenrate data types
		query2.addScalar("POLICYID",StandardBasicTypes.INTEGER);
		query2.addScalar("POLICYNAME",StandardBasicTypes.STRING);
		
		list=query2.list();
		list.forEach(row->{
			for(Object val:row) {
				System.out.print(val+"  " );
				System.out.print(val.getClass());
			}
			System.out.println();
		});
		System.out.println("....................................................");
		query4=ses.createSQLQuery("SELECT COUNT(*) FROM INSURANCEPOLICY");
		query4.addScalar("count(*)",StandardBasicTypes.INTEGER);
		list2=query4.list();
		System.out.println("Count of records"+list2.get(0)+"  type"+list2.get(0).getClass());
		
		//close objects
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}//main
}//class
