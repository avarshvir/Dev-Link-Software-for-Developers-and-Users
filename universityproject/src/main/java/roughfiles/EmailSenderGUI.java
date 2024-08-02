/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roughfiles;

/**
 *
 * @author Arsh
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSenderGUI extends JFrame {
    private JTextField toField, subjectField;
    private JTextArea messageArea;
    private JButton sendButton;

    public EmailSenderGUI() {
        super("Email Sender");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        // Create UI components
        JLabel toLabel = new JLabel("To:");
        toField = new JTextField(20);
        JLabel subjectLabel = new JLabel("Subject:");
        subjectField = new JTextField(20);
        JLabel messageLabel = new JLabel("Message:");
        messageArea = new JTextArea(10, 20);
        sendButton = new JButton("Send");

        // Add action listener to send button
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendEmail();
            }
        });

        // Create layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(toLabel, gbc);
        gbc.gridx = 1;
        panel.add(toField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(subjectLabel, gbc);
        gbc.gridx = 1;
        panel.add(subjectField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(messageLabel, gbc);
        gbc.gridx = 1;
        gbc.gridheight = 2;
        panel.add(new JScrollPane(messageArea), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(sendButton, gbc);

        add(panel);
        setVisible(true);
    }

    private void sendEmail() {
        // Recipient's email address
        String to = toField.getText();

        // Sender's email address and password
        String from = "sender@example.com";
        String password = "yourPassword";

        // Email properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.example.com"); // SMTP server address
        props.put("mail.smtp.port", "587"); // SMTP server port

        // Create a Session object
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);

            // Set the sender and recipient addresses
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set the email subject
            message.setSubject(subjectField.getText());

            // Set the email content
            message.setText(messageArea.getText());

            // Send the email
            Transport.send(message);

            JOptionPane.showMessageDialog(this, "Email sent successfully!");
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(this, "Error sending email: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EmailSenderGUI();
            }
        });
    }
}