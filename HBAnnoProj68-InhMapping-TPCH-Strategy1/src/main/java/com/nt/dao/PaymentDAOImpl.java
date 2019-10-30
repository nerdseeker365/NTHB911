package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.ChequePayment;
import com.nt.entity.CreditCardPayment;
import com.nt.entity.Payment;
import com.nt.utility.HibernateUtil;

public class PaymentDAOImpl implements PaymentDAO {

	@Override
	public void saveData() {
		Session ses=null;
		CreditCardPayment ccPayment=null;
		ChequePayment chPayment=null;
		Transaction tx=null;
		boolean flag=false;
		//get SEssion 
		ses=HibernateUtil.getSession();
		//create Objects
		ccPayment=new CreditCardPayment();
		ccPayment.setAmount(90000);
		ccPayment.setGateway("VISA");
		ccPayment.setCardNumber(9999999);
		ccPayment.setHolderName("raja");
		ccPayment.setRemarks("for table");
		
		chPayment=new ChequePayment();
		chPayment.setAmount(8000);
		chPayment.setRemarks("for  loan");
		chPayment.setChequeNumber(8889899);
		chPayment.setPayeeName("ravi");
		chPayment.setChequeType("Account Payee");
		//save objs
		try {
			tx=ses.beginTransaction();
			  ses.save(ccPayment);
			  ses.save(chPayment);
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
				System.out.println("Objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void loadData() {
		Session ses=null;
		Query query=null;
		List<CreditCardPayment> list1=null;
		List<ChequePayment> list2=null;
		List<Payment> list3=null;
		//get SEssion 
		ses=HibernateUtil.getSession();
		try {
		//prepare Query obj
		query=ses.createQuery("from CreditCardPayment");
		list1=query.list();
		list1.forEach(pay->{
			System.out.println(pay);
		});
		System.out.println(".........................................");
		query=ses.createQuery("from ChequePayment");
		list2=query.list();
		list2.forEach(pay->{
			System.out.println(pay);
		});
		System.out.println("............................................");
		query=ses.createQuery("from Payment");
		list3=query.list();
		list3.forEach(pay->{
			System.out.println(pay);
		});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
	}//method
}//class
