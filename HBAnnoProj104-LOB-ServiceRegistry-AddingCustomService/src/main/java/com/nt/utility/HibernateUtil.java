package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.service.ServiceRegistry;

import com.nt.service.CustomJDBCConnectionService;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		Configuration cfg=null;
		StandardServiceRegistryBuilder builder=null;
		ServiceRegistry registry=null;
		ConnectionProvider provider=null;
		//create Configuration object
		cfg=new Configuration();
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//create ServiceRegistryBuilder
		builder=new StandardServiceRegistryBuilder();
		//add Service Builder
		provider=new CustomJDBCConnectionService();
		builder.addService(ConnectionProvider.class,provider);
		//create ServiceRegstry
		registry=builder.applySettings(cfg.getProperties()).build();
		//create SessionFActory object
		factory=cfg.buildSessionFactory(registry);
	}
	
	public  static  Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses=factory.openSession();
		return ses;
	}
	
	public static  void closeSession(Session ses) {
	     if(ses!=null)
	    	 ses.close();
	}
	
	public  static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
	

}
