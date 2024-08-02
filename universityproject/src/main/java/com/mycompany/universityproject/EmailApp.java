/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.universityproject;

/**
 *
 * @author Arsh
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailApp extends JFrame {
    private JTextField toField, subjectField;
    private JTextArea messageArea;
    private String username, password;
    private String provider;

    public EmailApp() {
        super("Email by DevLink");

        // Create components
        JLabel toLabel = new JLabel("To:");
        toField = new JTextField(20);
        JLabel subjectLabel = new JLabel("Subject:");
        subjectField = new JTextField(20);
        JLabel messageLabel = new JLabel("Message:");
        messageArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        JButton sendButton = new JButton("Send");

        // Set layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add components to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(toLabel, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(toField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(subjectLabel, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(subjectField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(messageLabel, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 3;
        add(scrollPane, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        add(sendButton, gbc);

        // Add action listener for the send button
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLoginWindow();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    private void showLoginWindow() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        JButton gmailButton = new JButton("Continue with Gmail");
        JButton tutanotaButton = new JButton("Continue with Tutanota");

        gmailButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                username = "your_gmail_address@gmail.com";
                password = "your_gmail_password";
                provider = "gmail";
                sendEmail();
            }
        });

        tutanotaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                username = "xxx@tutanota.com";
                password = "xxx";
                provider = "tutanota";
                sendEmail();
            }
        });

        panel.add(gmailButton);
        panel.add(tutanotaButton);

        JOptionPane.showMessageDialog(null, panel, "Choose Email Provider", JOptionPane.PLAIN_MESSAGE);
    }

    private void sendEmail() {
        String to = toField.getText();
        String subject = subjectField.getText();
        String message = messageArea.getText();

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");

        if (provider.equals("gmail")) {
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
        } else if (provider.equals("tutanota")) {
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.tutanota.com");
            props.put("mail.smtp.port", "587");
        }

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(username));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);
            msg.setText(message);

            Transport.send(msg);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EmailApp();
            }
        });
    }
}