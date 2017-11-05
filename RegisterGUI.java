package com.proiect.Proiect; /**
 * Created by Bugghy on 10/30/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

/**
 * Created by Bugghy on 10/28/2017.
 */
public class RegisterGUI extends JFrame {
    JButton exitButton, registerButton;
    JLabel firstNameLabel, lastNameLabel, dateOfDonationLabel, nextDonationLabel, bloodTypeLabel, bloodCompatibilityLabel;
    JTextField firstNameField, lastNameField, dateOfDonationField, nextDonationField, bloodTypeField, bloodCompatilibityField;
    JList anJList;
    DefaultListModel aniList = new DefaultListModel();
    Statement myStmt;

    public  RegisterGUI(Statement myStmt) {
        this.myStmt = myStmt;
        this.setTitle("Blood Donation List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,650);
        this.setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.RED);
        JPanel regPanel = new JPanel();
        regPanel.setBackground(Color.RED);
        regPanel.setLayout(new FlowLayout(FlowLayout.LEFT,15,20));
        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(firstNameLabel);
        firstNameField = new JTextField(30);
        firstNameField.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(firstNameField);
        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(lastNameLabel);
        lastNameField = new JTextField(30);
        lastNameField.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(lastNameField);
        dateOfDonationLabel = new JLabel("Date of Donation");
        dateOfDonationLabel.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(dateOfDonationLabel);
        dateOfDonationField = new JTextField(30);
        dateOfDonationField.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(dateOfDonationField);
        nextDonationLabel = new JLabel("Next Donation");
        nextDonationLabel.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(nextDonationLabel);
        nextDonationField = new JTextField(30);
        nextDonationField.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(nextDonationField);
        bloodTypeLabel = new JLabel("Blood Type");
        bloodTypeLabel.setFont(new Font ("Arial", Font.BOLD, 16));
        regPanel.add(bloodTypeLabel);
        bloodTypeField = new JTextField(30);
        bloodTypeField.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(bloodTypeField);
        bloodCompatibilityLabel = new JLabel("Blood Compatibility");
        bloodCompatibilityLabel.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(bloodCompatibilityLabel);
        bloodCompatilibityField = new JTextField(30);
        bloodCompatilibityField.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(bloodCompatilibityField);


        anJList = new JList(aniList);
        anJList.setFont(new Font("Arial", Font.BOLD, 16));
        anJList.setVisibleRowCount(10);
        regPanel.add(anJList);
        mainPanel.add(regPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        exitButton = new JButton("EXIT");
        exitButton.setPreferredSize(new Dimension(150, 40));
        exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        registerButton = new JButton("REGISTER");
        registerButton.setPreferredSize(new Dimension(150, 40));
        registerButton.setFont(new Font("Arial", Font.PLAIN, 18));
        ListenForButton listenForButton = new ListenForButton();
        exitButton.addActionListener(listenForButton);
        registerButton.addActionListener(listenForButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(registerButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        this.add(mainPanel);
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exitButton){
                System.exit(0);
            } else if (e.getSource() == registerButton) {
                Donor donor = new Donor(MainApp.donorCount, firstNameField.getText(),lastNameField.getText(),Integer.parseInt(dateOfDonationField.getText()),
                        Integer.parseInt(nextDonationField.getText()), bloodTypeField.getText(), bloodCompatilibityField.getText());
                donor.saveDonor(myStmt);
                MainApp.donorCount ++;
                new WelcomeGUI(myStmt);
                dispose();
            }
        }

    }
}
