package br.univel.bancotads;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection openConnection() throws SQLException {
		
		SoftwareProperties sp = new SoftwareProperties();

		// Open the connection
		String url = "jdbc:h2:" + sp.getProperty("DBIP").toString() + "/" + sp.getProperty("DBname").toString();
		String user = sp.getProperty("DBusername").toString();
		String pass = sp.getProperty("DBpassword").toString();
		Connection c = DriverManager.getConnection(url, user, pass);
		return c;
	
	}
}
