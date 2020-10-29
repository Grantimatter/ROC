package com.app.jdbc_demo.jdbutil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLCommands {
	public static void sendCommand(Connection connection, String command) {
		// Step 7 - Modify Table
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(command);
			System.out.println("Database updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
