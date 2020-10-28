package com.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHandling {

	// Establish a connection with the database 
	public static Connection establishConnection(String url, String username, String password) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded Successfully");
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected Successfully");
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static void closeConnection(Connection connection) {
		try {
			// Step 6 - Close connection
			connection.close();
			System.out.println("Connection Closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
}
