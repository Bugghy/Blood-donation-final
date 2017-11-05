package com.proiect.Proiect;

import java.sql.*;

/**
 * Created by Bugghy on 10/30/2017.
 */
public class MainApp {
    static int donorCount = 1;
    public static void main(String[] args) {
        String dbUrl = "jdbc:postgresql:postgres";
        String user = "postgres";
        String password = "Vidraru57";


        try {
            Connection myConn = DriverManager.getConnection(dbUrl, user, password);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from blooddonationlist");
            while (myRs.next()) {
                donorCount++;
            }
            new WelcomeGUI(myStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

