package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
	// Test DB

        try {
           // Connection conn = DriverManager.getConnection("jdbc:sqlite:D\\databases\\testJava.db");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:~/dev/web50/JAVA/Databases/testJava.db");

        }catch (SQLException e){
            System.out.println("Something is wrong " + e.getMessage());
        }

    }
}
