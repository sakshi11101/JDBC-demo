package org.example;

import java.sql.*; //step 1. done


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
            Steps for JDBC Connection:
            1. import package
            2. load and register - automatically done after java 6
            3. create connection - means connect your application to database
            4. create statement
            5. execute statement
            6. process the results
            7. close connection
         */

        try {
            final String url = "jdbc:postgresql://localhost:5432/spring-boot-jdbc";
            final String userName = "postgres";
            final String password = "0000";

            //Class.forName("org.postgresql.Driver"); //this is load and register - this is optional now as mentioned it's automatically done after java 6.
            Connection con = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected to the PostgreSQL server successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}