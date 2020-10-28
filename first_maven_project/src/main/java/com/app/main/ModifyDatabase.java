package com.app.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ModifyDatabase {
	public static void sendCommand(Connection connection, String command) {
		// Step 7 - Modify Table
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate("update roc_revature.player set age = 21 where teamName='Braves' ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
