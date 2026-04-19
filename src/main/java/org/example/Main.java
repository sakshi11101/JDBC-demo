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
            final String sql = "select name from student where sid = 104";
            final String sqlPrintAllData = "select * from student";

            //Class.forName("org.postgresql.Driver"); //this is load and register - this is optional now as mentioned it's automatically done after java 6.
            Connection con = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected to the PostgreSQL server successfully");

            //create statement
            Statement st = con.createStatement();

            /*
            This part explains how to create, execute statement and process the results.

            //execute statement
            ResultSet resultSet = st.executeQuery(sql);

            //process the results
            boolean isDataExist = resultSet.next(); //next needs to be called as pointer to data is not at row 0 but before it, so to fetch even first row, have to first do next.
            String printSt = isDataExist ? "Data exist" : "Data not exist";
            System.out.println(printSt);

            //Printing one student name based on given sid in sql query.
            String name = resultSet.getString("name");
            System.out.println("Name of student with Id 104 is : " + name);

            */

            //Print All Data as mentioned in sql query;
            ResultSet rs = st.executeQuery(sqlPrintAllData);
            while(rs.next()) {    //a loop to get to all data.
                System.out.print(rs.getInt(1) + " - ");   //1, 2, 3 represnts column index and should be in same order as in table.
                System.out.print(rs.getString(2) + " - ");
                System.out.println(rs.getInt(3));
            }


            //close the connection
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}