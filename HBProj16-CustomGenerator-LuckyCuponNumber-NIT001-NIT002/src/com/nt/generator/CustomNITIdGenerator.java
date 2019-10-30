package com.nt.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomNITIdGenerator implements IdentifierGenerator {
	private static final String  GET_SEQ_VALUE="SELECT NIT_SEQ.NEXTVAL FROM DUAL";
	public CustomNITIdGenerator() {
		System.out.println("CustomNITIdGenerator.0-param constructor");
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
		System.out.println("CustomNITIdGenerator.generate(-,-)");
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int val=0;
		try {
			//get JDBC con obj from HB session obj
			con=session.connection();
			//create JDBC PreparedStatement object
			ps=con.prepareStatement(GET_SEQ_VALUE);
			//execute the Query
			rs=ps.executeQuery();
			//get sequence value
			rs.next();
			val=rs.getInt(1);
		}//try
		catch(SQLException se) {
			System.out.println("Internal problem in Generating Id value-->"+se.getMessage());
		}
		catch(Exception e) {
			System.out.println("Unknow Internal problem in Generating Id value-->"+e.getMessage());
		}
		if(val<=9)
			return "NIT000"+val;
		else if(val<=99)
			return "NIT00"+val;
		else if(val<=999)
		   return "NIT0"+val;
		else
			return "NIT"+val;
	}//method
}//class
