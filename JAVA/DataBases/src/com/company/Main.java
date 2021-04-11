package com.company;

import java.sql.*;

public class Main {

    public static final String DB_NAME = "testJava_db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/ogidi/dev/web50/JAVA/Databases/" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";


    public static void main(String[] args) {


        try{
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             Statement statement = conn.createStatement();
             statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                    "(" + COLUMN_NAME + " text, " +
                    COLUMN_PHONE + " integer, " +
                    COLUMN_EMAIL + " text" + ")");

            insertContact(statement, "Gideon", 5689867, "gideon@gtech.nl");
            insertContact(statement, "Johnson", 49094578, "joseph@email.com");
            insertContact(statement, "Jane", 12345678, "jane@email.com");

/*            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    "(" + COLUMN_NAME + ", " + COLUMN_PHONE + ", " +
                    COLUMN_EMAIL + ")" +
                    "VALUES('Gideon', 5689867, 'gideon@gtech.nl')");*//*            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    "(" + COLUMN_NAME + ", " + COLUMN_PHONE + ", " +
                    COLUMN_EMAIL + ")" +
                    "VALUES('Johnson', 49094578, 'joseph@email.com')");*//*            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    "(" + COLUMN_NAME + ", " +
                    COLUMN_PHONE + ", " +
                    COLUMN_EMAIL + ")" +
                    "VALUES('Jane', 12345678, 'jane@email.com')");*/

            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    "(" + COLUMN_NAME + ", " +
                    COLUMN_PHONE + ", " +
                    COLUMN_EMAIL + ")" +
                    "VALUES('Fido', 4823467, 'fido@email.com')");

            statement.execute("UPDATE " + TABLE_CONTACTS +
                    " SET " + COLUMN_PHONE +
                    "= 12345678 " + " WHERE " + COLUMN_NAME + "='Jane");

            statement.execute("DELETE FROM " + TABLE_CONTACTS + " WHERE " + COLUMN_NAME + "='Johnson'");


            ResultSet result = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while (result.next()){
                System.out.println(result.getString(COLUMN_NAME) + "\t" +
                        result.getInt(COLUMN_PHONE) + "\t" +
                        result.getString(COLUMN_EMAIL));
            }
            result.close();

            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("Something is wrong: " + e.getMessage());
            e.printStackTrace();
        }

    }

    private static void insertContact(Statement statement, String name, int number, String email) throws SQLException{
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                "(" + COLUMN_NAME + ", " + COLUMN_PHONE + ", " +
                COLUMN_EMAIL + ")" +
                "VALUES('" + name + "', " + number + ", '" + email +"')");
    }
}