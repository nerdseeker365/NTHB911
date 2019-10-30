package com.nt.provider;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;

public class ApacheDBCPConnectionProvider extends UserSuppliedConnectionProviderImpl {
    private Connection con;
    private BasicDataSource bds;
    
    public ApacheDBCPConnectionProvider() {
    	bds=new BasicDataSource();
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setPassword("manager");
		bds.setUsername("system");
	}
    
	@Override
	public Connection getConnection() throws SQLException {
		return bds.getConnection();
	}
	
	@Override
	public void closeConnection(Connection con) throws SQLException {
	    con.close();
	}
	
}
