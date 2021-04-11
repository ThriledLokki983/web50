package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// Test DB

        // Connection conn = DriverManager.getConnection("jdbc:sqlite:D\\databases\\testJava.db");
        /* Using the Driver Manager */

        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ogidi/dev/web50/JAVA/Databases/testJava.db");
           // conn.setAutoCommit(false);
             Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts" +
                    "(name TEXT, phone INTEGER, email TEXT)");

 /*            statement.execute("DELETE FROM contacts WHERE name='Emmanuel' ");
         statement.execute("UPDATE contacts SET phone=89786848 WHERE name='Emmanuel' ");
            statement.execute("INSERT INTO contacts VALUES ('Emmanuel', 9876754321, 'ammatheboss@email.com' )");
            statement.execute("INSERT INTO contacts VALUES ('Benjamin', 9836746524, 'banthejoke@email.com' )");*/
/*            statement.execute("SELECT * FROM contacts");
            ResultSet result = statement.getResultSet();*/
            ResultSet result = statement.executeQuery("SELECT * FROM contacts");
            while (result.next()){
                System.out.println(result.getString("name") + "\t" +
                        result.getInt("phone") + "\t" +
                        result.getString("email"));
            }
            result.close();

            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("Something is wrong: " + e.getMessage());
        }

    }
}
