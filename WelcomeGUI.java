package com.proiect.Proiect;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Statement;

/**
 * Created by Bugghy on 10/30/2017.
 */
public class WelcomeGUI extends JFrame {
    JButton exitButton, registerButton, listButton;
    BufferedImage img;
    Statement myStmt;

    public WelcomeGUI(Statement myStmt) {
        this.myStmt = myStmt;
        this.setTitle("Blood Donation List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(860, 640);
        this.setLocationRelativeTo(null);
        JLabel mainLabel = new JLabel();
        mainLabel.setSize(860,640);
        try {
            img = ImageIO.read(new File("C:\\Users\\Laura\\Desktop\\blooddonation.JPG"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(mainLabel.getWidth(), mainLabel.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon ImageIcon = new ImageIcon(dimg);
        mainLabel.setIcon(ImageIcon);
        mainLabel.setLayout(new BorderLayout());
        this.setContentPane(mainLabel);
        JLabel welcomeLabel = new JLabel("Blood Donation List", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 28));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
        exitButton = new JButton("EXIT");
        exitButton.setPreferredSize(new Dimension(150,40));
        exitButton.setFont(new Font("Arial", Font.PLAIN,18));
        registerButton = new JButton("REGISTER");
        registerButton.setPreferredSize(new Dimension(150, 40));
        registerButton.setFont(new Font("Arial", Font.PLAIN, 18));
        listButton = new JButton("LIST");
        listButton.setPreferredSize(new Dimension(150,40));
        listButton.setFont(new Font("Arial", Font.PLAIN, 18));
        ListenForButton listenForButton = new ListenForButton();
        exitButton.addActionListener(listenForButton);
        registerButton.addActionListener(listenForButton);
        listButton.addActionListener(listenForButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(registerButton);
        buttonPanel.add(listButton);
        mainLabel.add(buttonPanel, BorderLayout.SOUTH);
        mainLabel.add(welcomeLabel);
        //this.add(mainLabel);
        this.pack();
        this.setVisible(true);

    }

    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exitButton) {
                System.exit(0);
            } else if (e.getSource() == registerButton) {
                new RegisterGUI(myStmt);
                dispose();
            } else if (e.getSource() == listButton) {
                new ListGUI(myStmt);
                dispose();
            }
        }
    }
}

