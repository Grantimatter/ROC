package com.app.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import static com.app.main.SQLQueries.queryPrintPlayerTable;

public class HelloJDBC {

	public static void main(String[] args) {
		// Establish connection
		Connection connection = ConnectionHandling.establishConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1Playlego%");
		
		// Run all commands while connection is active
        // Query table as is
        queryPrintPlayerTable(connection);

        test1(connection);
        test2(connection);

		// Close Connection when finished
		ConnectionHandling.closeConnection(connection);
	}

	// First test, just call method to try it out
	public static void test1(Connection connection){
	    System.out.println("Editing table and printing results!\n");
        // Apply random age to everyone on the team "braves"
        ModifyDatabase.sendCommand(connection, "update roc_revature.player set age="+RandomData.generateRandomAge(18, 48)+ " where teamName=\'Braves\'");
        // Query the table again to examine changes
        queryPrintPlayerTable(connection);
    }

    public static void test2(Connection connection){
        System.out.println("Input SQL Command...\n");
        ResultSet rs = SQLQueries.sendQuery(connection, new Scanner(System.in).nextLine());
        if(rs != null)
            SQLQueries.printQuery(SQLQueries.sendQuery(connection, new Scanner(System.in).nextLine()));
        else
            queryPrintPlayerTable(connection);
    }
}