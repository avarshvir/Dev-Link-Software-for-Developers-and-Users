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
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileConverterApp extends JFrame {
    private final JLabel inputFileLabel;
    private final JButton chooseFileButton;
    private final JComboBox<String> formatComboBox;
    private final JButton convertButton;

    public FileConverterApp() {
        super("File Converter");
        inputFileLabel = new JLabel("Input File:");
        chooseFileButton = new JButton("Choose File");
        formatComboBox = new JComboBox<>(new String[]{"PDF", "TXT", "DOCX"}); // Add more formats as needed
        convertButton = new JButton("Convert");

        setLayout(new GridLayout(4, 1));
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.add(inputFileLabel);
        panel1.add(chooseFileButton);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2.add(new JLabel("Output Format:"));
        panel2.add(formatComboBox);

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(convertButton);

        add(panel1);
        add(panel2);
        add(panel3);

        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Files", "txt"); // Only allow text files for demonstration
                fileChooser.setFileFilter(filter);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    inputFileLabel.setText("Input File: " + selectedFile.getName());
                }
            }
        });

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFormat = (String) formatComboBox.getSelectedItem();
                if (inputFileLabel.getText().equals("Input File:")) {
                    JOptionPane.showMessageDialog(FileConverterApp.this, "Please select a file.");
                    return;
                }

                File inputFile = new File(inputFileLabel.getText().substring(11));
                File outputFile = new File(inputFile.getParent(), getFileNameWithoutExtension(inputFile) + "." + selectedFormat.toLowerCase());

                try {
                    if (selectedFormat.equalsIgnoreCase("pdf")) {
                        // Conversion logic for PDF format
                        // For demonstration, we just copy the content of the input file to the output file
                        try (FileReader reader = new FileReader(inputFile); FileWriter writer = new FileWriter(outputFile)) {
                            int character;
                            while ((character = reader.read()) != -1) {
                                writer.write(character);
                            }
                        }
                    } else if (selectedFormat.equalsIgnoreCase("txt")) {
                        // Conversion logic for TXT format
                        // For demonstration, we just copy the content of the input file to the output file
                        try (FileReader reader = new FileReader(inputFile); FileWriter writer = new FileWriter(outputFile)) {
                            int character;
                            while ((character = reader.read()) != -1) {
                                writer.write(character);
                            }
                        }
                    } else if (selectedFormat.equalsIgnoreCase("docx")) {
                        // Conversion logic for DOCX format
                        // For demonstration, we just copy the content of the input file to the output file
                        try (FileReader reader = new FileReader(inputFile); FileWriter writer = new FileWriter(outputFile)) {
                            int character;
                            while ((character = reader.read()) != -1) {
                                writer.write(character);
                            }
                        }
                    }

                    JOptionPane.showMessageDialog(FileConverterApp.this, "Conversion completed!");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(FileConverterApp.this, "Error occurred during conversion!");
                }
            }
        });

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String getFileNameWithoutExtension(File file) {
        String name = file.getName();
        int pos = name.lastIndexOf(".");
        if (pos > 0 && pos < name.length() - 1) {
            return name.substring(0, pos);
        }
        return name;
    }

    public static void main(String[] args) {
        new FileConverterApp();
    }
}

