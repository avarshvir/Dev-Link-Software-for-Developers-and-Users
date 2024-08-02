/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafiles;

/**
 *
 * @author Arsh
 */import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class MessageSharing extends JFrame implements ActionListener {
    private JLabel label1, label2;
    private JButton sendButton, inboxButton;
    private JTextArea messageArea, inboxArea;
    private JTextField ipAddressField;
    private ServerSocket serverSocket;
    private Map<String, String> inboxMessages;

    public MessageSharing() {
        setTitle("Message Sharing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 1));
        label1 = new JLabel("Message Sharing", SwingConstants.CENTER);
        label2 = new JLabel("Note: Enter IP Address to send message.", SwingConstants.CENTER);
        messageArea = new JTextArea(3, 4);
        ipAddressField = new JTextField("Enter IP Address");
        sendButton = new JButton("Send Message");
        inboxButton = new JButton("Inbox");
        inboxMessages = new HashMap<>();
        inboxArea = new JTextArea(3, 4);
        inboxArea.setEditable(false);

        sendButton.addActionListener(this);
        inboxButton.addActionListener(this);

        panel.add(label1);
        panel.add(label2);
        panel.add(messageArea);
        panel.add(ipAddressField);
        panel.add(sendButton);
        panel.add(inboxButton);

        add(panel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton) {
            sendMessage();
        } else if (e.getSource() == inboxButton) {
            showInbox();
        }
    }

    private void sendMessage() {
        try {
            String ipAddress = ipAddressField.getText();
            Socket socket = new Socket(ipAddress, 8000);
            System.out.println("Connected to " + ipAddress);
            OutputStream outputStream = socket.getOutputStream();
            String message = messageArea.getText();
            outputStream.write(message.getBytes());
            outputStream.close();
            socket.close();
            JOptionPane.showMessageDialog(this, "Message sent successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while sending message.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showInbox() {
        StringBuilder inboxContent = new StringBuilder();
        for (Map.Entry<String, String> entry : inboxMessages.entrySet()) {
            inboxContent.append("From: ").append(entry.getKey()).append("\n");
            inboxContent.append("Message: ").append(entry.getValue()).append("\n\n");
        }
        inboxArea.setText(inboxContent.toString());
        JOptionPane.showMessageDialog(this, new JScrollPane(inboxArea), "Inbox", JOptionPane.PLAIN_MESSAGE);
    }

    public void startServer() {
        try {
            serverSocket = new ServerSocket(8000);
            System.out.println("Server started on port 8000");
            new Thread(new ServerHandler()).start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    class ServerHandler implements Runnable {
        public void run() {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Connection established with: " + socket.getInetAddress().getHostAddress());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String receivedMessage = reader.readLine();
                    inboxMessages.put(socket.getInetAddress().getHostAddress(), receivedMessage);
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        MessageSharing messageSharing = new MessageSharing();
        messageSharing.startServer();
    }
}
