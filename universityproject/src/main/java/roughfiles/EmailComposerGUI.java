/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roughfiles;

/**
 *
 * @author Arsh
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailComposerGUI extends JFrame {
    private JTextField toField, subjectField;
    private JTextArea messageArea;
    private JButton sendButton;

    public EmailComposerGUI() {
        setTitle("Email Composer");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        toField = new JTextField(20);
        subjectField = new JTextField(20);
        messageArea = new JTextArea(10, 30);
        sendButton = new JButton("Send");

        // Add components to the frame
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("To:"));
        inputPanel.add(toField);
        inputPanel.add(new JLabel("Subject:"));
        inputPanel.add(subjectField);
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(messageArea), BorderLayout.CENTER);
        add(sendButton, BorderLayout.SOUTH);

        // Attach listener to the Send button
        sendButton.addActionListener(new SendListener());
    }

    private class SendListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String recipient = toField.getText();
            String subject = subjectField.getText();
            String message = messageArea.getText();

            // Set up properties for the Gmail SMTP server
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            // Replace with your Gmail credentials
            String senderEmail = "your@gmail.com";
            String senderPassword = "your-gmail-password";

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(senderEmail, senderPassword);
                }
            });

            try {
                Message emailMessage = new MimeMessage(session);
                emailMessage.setFrom(new InternetAddress(senderEmail));
                emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
                emailMessage.setSubject(subject);
                emailMessage.setText(message);

                Transport.send(emailMessage);
                System.out.println("Email sent successfully!");
            } catch (MessagingException ex) {
                ex.printStackTrace();
                System.out.println("Error sending email.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EmailComposerGUI().setVisible(true);
        });
    }
}
