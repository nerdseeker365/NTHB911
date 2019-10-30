package com.nt.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class InsuranceDAOImpl implements InsurancePolicyDAO {

	public List<InsurancePolicy> getPageData(int startPos, int pageSize) {
		Session ses=null;
		CriteriaBuilder builder=null;
		CriteriaQuery<InsurancePolicy> ctQuery=null;
		Root<InsurancePolicy> root=null;
		Query query=null;
		List<InsurancePolicy>  list=null;
		Transaction  tx=null;
		//get Session session
		ses=HibernateUtil.getSession();
		tx=ses.beginTransaction();
		//Use JPACriteria for Pagination
		builder=ses.getCriteriaBuilder();
		ctQuery=builder.createQuery(InsurancePolicy.class);
		root=ctQuery.from(InsurancePolicy.class);
		ctQuery.select(root);
		query=ses.createQuery(ctQuery);
		//for pagination
		query.setFirstResult(startPos);
		query.setMaxResults(pageSize);
		list=query.getResultList();
		System.out.println(list.size());
		return list;
	}
	
	public int getRecordsCount() {
		Session ses=null;
		CriteriaBuilder builder=null;
		CriteriaQuery<Object> ctQuery=null;
		Root<InsurancePolicy> root=null;
		Query query=null;
		long count=0;
		//get Session session
		ses=HibernateUtil.getSession();
		//Use JPACriteria for rowCount
		builder=ses.getCriteriaBuilder();
		ctQuery=builder.createQuery(Object.class);
		root=ctQuery.from(InsurancePolicy.class);
		ctQuery.multiselect(builder.count(root.get("policyId")));
		query=ses.createQuery(ctQuery);
		count=(Long) query.getSingleResult();
		return (int)count;
	}

}
