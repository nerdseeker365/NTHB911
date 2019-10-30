package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BrandFactory;
import com.nt.utility.HibernateUtil;

public class DirtyStateCheck {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		BrandFactory factory=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load obj
		factory=ses.get(BrandFactory.class, 888888888L);
		System.out.println(factory);
		System.out.println("is dirtry?"+ses.isDirty());
		factory.setCustAddrs("delhi");
		System.out.println("is dirtry?"+ses.isDirty());
		
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}//main

}//class
