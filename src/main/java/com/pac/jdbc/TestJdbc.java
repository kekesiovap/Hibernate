package com.pac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3308/hb_student_tracker";
        String user = "hbstudent";
        String pass = "hbstudent";
        try{
            System.out.println("Connecting: " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Success.");
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
    }
}
