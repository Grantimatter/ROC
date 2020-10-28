package com.app.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLQueries {
	public static ResultSet queryPlayerTable(Connection connection, String query) {
		try {
			// Step 3 - Create statement
			Statement statement = connection.createStatement();
			System.out.println("Statement Created");

			// Step 4 - Execute Query
			ResultSet rs = statement.executeQuery(query);
			System.out.println("Query Executed\n");

			return rs;

			// Step 5 - Process Results
			/*
			 * while (rs.next()) { System.out.print("ID = " + rs.getInt("id"));
			 * System.out.print(" | NAME = " + rs.getString("name"));
			 * System.out.print(" | GENDER = " + rs.getString("gender"));
			 * System.out.print(" | TEAM = " + rs.getString("teamName"));
			 * System.out.print(" | CONTACT = " + rs.getString("contact"));
			 * System.out.println(); } System.out.println("\nResults Processed");
			 */

		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	public static void printQuery(ResultSet rs) {
		try {
			System.out.println("Beginning query print\n");
			ResultSetMetaData metadata = rs.getMetaData();
			int columnCount = metadata.getColumnCount();
			System.out.println("Column Count : " + columnCount);
			List<String> columns = new ArrayList<String>();

			for (int i = 1; i < columnCount; i++) {
				columns.add(metadata.getColumnName(i));
			}

			while (rs.next()) {
				for (String columnName : columns) {
					String value = rs.getString(columnName);
					System.out.print("| " + columnName.toUpperCase() + " : " + value+ " ");
				}
				System.out.println();
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
