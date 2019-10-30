package com.nt.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class CustomJDBCConnectionService implements ConnectionProvider {
    
	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection con=null;
		System.out.println("CustomJDBCConnectionService.getConnection()");
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		return con;
	}

	@Override
	public void closeConnection(Connection conn) throws SQLException {
		System.out.println("CustomJDBCConnectionService.closeConnection(-)");
         conn.close();        

	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
