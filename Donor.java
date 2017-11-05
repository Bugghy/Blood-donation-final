package com.proiect.Proiect; /**
 * Created by Bugghy on 10/30/2017.
 */
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * Created by Buggy on 23.10.2017.
 */
public class Donor {
    int id;
    String firstName;
    String lastName;
    int dateofDonation;
    int nextDonation;
    String bloodType;
    String bloodCompatibility;

    public Donor(int id, String firstName, String lastName, int dateofDonation,
                 int nextDonation, String bloodType, String bloodCompatibility) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateofDonation = dateofDonation;
        this.nextDonation = nextDonation;
        this.bloodType = bloodType;
        this.bloodCompatibility = bloodCompatibility;
    }

    public void saveDonor(Statement myStmt) {
        String insertDb = "insert into blooddonationlist"
                + "(id,firstname,lastname,dateofdonation,nextdonation,bloodtype,bloodcompatibility)"
                + "values(" + this.id + ", '" + this.firstName + "', '" + this.lastName + "', " +
                this.dateofDonation + ", " + this.nextDonation + ", '" + this.bloodType + "', '" + this.bloodCompatibility + "')";


        try {
            myStmt.executeUpdate(insertDb);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
