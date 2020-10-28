package com.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJDBC {

	public static void main(String[] args) {
		// Establish connection
		Connection connection = ConnectionHandling.establishConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1Playlego%");
		
		// Run all commands while connection is active
		SQLQueries.printQuery(SQLQueries.queryPlayerTable(connection, "select teamName, name, gender, contact, id from roc_revature.player"));
		
		// Close Connection when finished
		ConnectionHandling.closeConnection(connection);
	}
}
