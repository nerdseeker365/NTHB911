package com.nt.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.License;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class OneToOneFKDAOImpl implements OneToOneFKDAO {

	public int saveDataUsingChild() {
		 //get Session  obj
		Session ses=null;
		Person per=null,per1=null;
		License lic1=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		ses=HibernateUtil.getSession();
		//prepare objs
		per=new Person();
		per.setPname("raja");
		per.setAddrs("hyd");
		
		per1=new Person();
		per1.setPname("ravi");
		per1.setAddrs("vizag");
		
		lic1=new License();
		lic1.setType("2-wheeler");
		lic1.setValidFrom(new Date());
		lic1.setValidTo(new Date(148,10,29));
		lic1.setLicenseHolder(per1);
		//save objs
		try {
			tx=ses.beginTransaction();
			idVal=(Integer)ses.save(lic1);
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
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
		return idVal;
	}//method
	
	
}//class
