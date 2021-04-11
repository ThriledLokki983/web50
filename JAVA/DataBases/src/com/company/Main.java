package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
	// Test DB

        // Connection conn = DriverManager.getConnection("jdbc:sqlite:D\\databases\\testJava.db");
        /* Using the Driver Manager */

        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ogidi/dev/web50/JAVA/Databases/testJava.db");
            conn.setAutoCommit(false);
             Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts" +
                    "(name TEXT, phone INTEGER, email TEXT)");

            statement.execute("INSERT INTO contacts VALUES ('Joseph', 0249094578, 'joelbasket@email.com' )");

            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("Something is wrong: " + e.getMessage());
        }

    }
}
