/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.universityproject;

/**
 *
 * @author Arsh
 */
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FileSharing extends JFrame implements ActionListener {
    private JLabel label1, label2;
    private JButton sendButton, receiveButton, chooseButton;
    private JFileChooser fileChooser;
    private ServerSocket serverSocket;
    private Socket socket;
    private boolean isServerRunning = false;

    public FileSharing() {
        setTitle("File Sharing");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(7, 1));
        label1 = new JLabel("File Sharing", SwingConstants.CENTER);
        label2 = new JLabel("Note: For file sharing, server side and client side must be in the same network.", SwingConstants.CENTER);
        sendButton = new JButton("Send File");
        receiveButton = new JButton("Receive File");
        chooseButton = new JButton("Choose File");

        sendButton.addActionListener(this);
        receiveButton.addActionListener(this);
        chooseButton.addActionListener(this);

        panel.add(label1);
        panel.add(label2);
        panel.add(sendButton);
        panel.add(receiveButton);
        panel.add(chooseButton);

        add(panel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton) {
            startServer();
            sendFile();
        } else if (e.getSource() == receiveButton) {
            receiveFile();
        } else if (e.getSource() == chooseButton) {
            chooseFile();
        }
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(8000);
            isServerRunning = true;
            System.out.println("Server started on port 8000");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void sendFile() {
        try {
            if (!isServerRunning) {
                return;
            }
            fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                System.out.println("Waiting for connection...");
                socket = serverSocket.accept();
                System.out.println("Connected to " + socket.getInetAddress().getHostAddress());
                sendFileToClient(file, socket);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void receiveFile() {
        try {
            String serverAddress = JOptionPane.showInputDialog(this, "Enter the server IP address:", "Server IP", JOptionPane.QUESTION_MESSAGE);
            if (serverAddress != null && !serverAddress.isEmpty()) {
                socket = new Socket(serverAddress, 8000);
                System.out.println("Connected to server " + serverAddress);
                receiveFileFromServer(socket);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid server IP address.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void sendFileToClient(File file, Socket socket) throws IOException {
        byte[] buffer = new byte[4096];
        FileInputStream fileInputStream = new FileInputStream(file);
        OutputStream outputStream = socket.getOutputStream();

        int bytesRead;
        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        fileInputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        isServerRunning = false;
    }

    private void receiveFileFromServer(Socket socket) throws IOException {
        fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            byte[] buffer = new byte[4096];
            InputStream inputStream = socket.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            fileOutputStream.close();
            inputStream.close();
            socket.close();
        }
    }

    private void chooseFile() {
        fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(this);
    }

    public static void main(String[] args) {
        new FileSharing();
    }
}