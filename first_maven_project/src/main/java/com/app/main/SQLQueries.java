package com.app.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLQueries {
	public static ResultSet sendQuery(Connection connection, String query) {
		try {
			// Step 3 - Create statement
			Statement statement = connection.createStatement();
			System.out.println("Statement Created");

			// Step 4 - Execute Query
			ResultSet rs = statement.executeQuery(query);
			System.out.println("Query Executed\n");

			return rs;
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
				System.out.print(" |\n");
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
