/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.universityproject;

/**
 *
 * @author Arsh
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javafiles.JFontChooser;
import javax.swing.*;
import javax.swing.filechooser.*;

public class TextEditor extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private String currentFile = "Untitled";
    private boolean isModified = false;

    public TextEditor() {
        setTitle("Text Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create text area
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create File menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem newItem = new JMenuItem("New");
        newItem.addActionListener(this);
        fileMenu.add(newItem);

        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(this);
        fileMenu.add(openItem);

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);
        fileMenu.add(saveItem);

        JMenuItem saveAsItem = new JMenuItem("Save As");
        saveAsItem.addActionListener(this);
        fileMenu.add(saveAsItem);

        fileMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);
        fileMenu.add(exitItem);

        // Create Edit menu
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        JMenuItem fontItem = new JMenuItem("Font");
        fontItem.addActionListener(this);
        editMenu.add(fontItem);

        JMenuItem colorItem = new JMenuItem("Text Color");
        colorItem.addActionListener(this);
        editMenu.add(colorItem);

        JMenuItem findItem = new JMenuItem("Find");
        findItem.addActionListener(this);
        editMenu.add(findItem);

        JMenuItem replaceItem = new JMenuItem("Replace");
        replaceItem.addActionListener(this);
        editMenu.add(replaceItem);

        // Create file chooser
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New":
                newFile();
                break;
            case "Open":
                openFile();
                break;
            case "Save":
                saveFile();
                break;
            case "Save As":
                saveFileAs("E:\\universityproject\\userfiles");
                break;
            case "Exit":
                exitEditor();
                break;
            case "Font":
                changeFont();
                break;
            case "Text Color":
                changeTextColor();
                break;
            case "Find":
                findText();
                break;
            case "Replace":
                replaceText();
                break;
        }
    }

    private void newFile() {
        if (isModified) {
            int choice = JOptionPane.showConfirmDialog(this, "Save changes to " + currentFile + "?", "Text Editor", JOptionPane.YES_NO_CANCEL_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                saveFile();
            } else if (choice == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }

        textArea.setText("");
        currentFile = "Untitled";
        isModified = false;
        setTitle("Text Editor - " + currentFile);
    }
    
    private void openFile() {
    if (isModified) {
        int choice = JOptionPane.showConfirmDialog(this, "Save changes to " + currentFile + "?", "Text Editor", JOptionPane.YES_NO_CANCEL_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            saveFile();
        } else if (choice == JOptionPane.CANCEL_OPTION) {
            return;
        }
    }

    // Specify the path to the directory where the file is located
    String directoryPath = "E:\\universityproject\\userfiles";
    fileChooser.setCurrentDirectory(new File(directoryPath));

    int returnVal = fileChooser.showOpenDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();
            textArea.setText(content.toString());
            currentFile = file.getAbsolutePath();
            isModified = false;
            setTitle("Text Editor - " + currentFile);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error opening file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    
    private void saveFile() {
    String directoryPath = "E:\\universityproject\\userfiles"; // Specify the desired directory path
    
    if (currentFile.equals("Untitled")) {
        saveFileAs(directoryPath);
    } else {
        try {
            // Create a new File object with the directoryPath and currentFile
            File file = new File(directoryPath, new File(currentFile).getName());
            
            FileWriter writer = new FileWriter(file);
            writer.write(textArea.getText());
            writer.close();
            
            isModified = false;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    private void saveFileAs(String directoryPath) {
    fileChooser.setCurrentDirectory(new File(directoryPath));
    
    int returnVal = fileChooser.showSaveDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(textArea.getText());
            writer.close();
            currentFile = file.getAbsolutePath();
            isModified = false;
            setTitle("Text Editor - " + currentFile);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    private void exitEditor() {
        if (isModified) {
            int choice = JOptionPane.showConfirmDialog(this, "Save changes to " + currentFile + "?", "Text Editor", JOptionPane.YES_NO_CANCEL_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                saveFile();
            } else if (choice == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }
        dispose();
    }

    private void changeFont() {
        Font selectedFont = JFontChooser.showDialog(this, "Choose Font", textArea.getFont());
        if (selectedFont != null) {
            textArea.setFont(selectedFont);
        }
    }

    private void changeTextColor() {
        Color selectedColor = JColorChooser.showDialog(this, "Choose Text Color", textArea.getForeground());
        if (selectedColor != null) {
            textArea.setForeground(selectedColor);
        }
    }

    private void findText() {
        String searchText = JOptionPane.showInputDialog(this, "Enter text to find:");
        if (searchText != null && !searchText.isEmpty()) {
            String text = textArea.getText();
            int index = text.indexOf(searchText);
            if (index != -1) {
                textArea.setSelectionStart(index);
                textArea.setSelectionEnd(index + searchText.length());
            } else {
                JOptionPane.showMessageDialog(this, "Text not found!");
            }
        }
    }

    private void replaceText() {
    String searchText = JOptionPane.showInputDialog(this, "Enter text to find:");
    if (searchText != null && !searchText.isEmpty()) {
        String replaceText = JOptionPane.showInputDialog(this, "Enter text to replace with:");
        if (replaceText != null) {
            String text = textArea.getText();
            String newText = text.replace(searchText, replaceText);
            textArea.setText(newText);
        }
    }
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new TextEditor().setVisible(true);
        }
    });
}
}

/*
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javafiles.JFontChooser;
import javafiles.UserModel;
import javax.swing.*;
import javax.swing.filechooser.*;

public class TextEditor extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private String currentFile = "Untitled";
    private boolean isModified = false;

    public TextEditor(UserModel userModel) {
        super("Text Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save As");
        JMenuItem exitItem = new JMenuItem("Exit");

        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        saveAsItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        JMenuItem fontItem = new JMenuItem("Font");
        JMenuItem colorItem = new JMenuItem("Text Color");
        JMenuItem findItem = new JMenuItem("Find");
        JMenuItem replaceItem = new JMenuItem("Replace");

        fontItem.addActionListener(this);
        colorItem.addActionListener(this);
        findItem.addActionListener(this);
        replaceItem.addActionListener(this);

        editMenu.add(fontItem);
        editMenu.add(colorItem);
        editMenu.add(findItem);
        editMenu.add(replaceItem);

        fileChooser = new JFileChooser();

        String userDirectoryPath = userModel.getUserDirectory();
        fileChooser.setCurrentDirectory(new File(userDirectoryPath));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New":
                newFile();
                break;
            case "Open":
                openFile();
                break;
            case "Save":
                saveFile();
                break;
            case "Save As":
                saveFileAs();
                break;
            case "Exit":
                exitEditor();
                break;
            case "Font":
                changeFont();
                break;
            case "Text Color":
                changeTextColor();
                break;
            case "Find":
                findText();
                break;
            case "Replace":
                replaceText();
                break;
        }
    }

    private void newFile() {
        if (isModified) {
            int choice = JOptionPane.showConfirmDialog(this, "Save changes to " + currentFile + "?", "Text Editor", JOptionPane.YES_NO_CANCEL_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                saveFile();
            } else if (choice == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }

        textArea.setText("");
        currentFile = "Untitled";
        isModified = false;
        setTitle("Text Editor - " + currentFile);
    }

    private void openFile() {
        if (isModified) {
            int choice = JOptionPane.showConfirmDialog(this, "Save changes to " + currentFile + "?", "Text Editor", JOptionPane.YES_NO_CANCEL_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                saveFile();
            } else if (choice == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }

        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                bufferedReader.close();
                textArea.setText(content.toString());
                currentFile = file.getAbsolutePath();
                isModified = false;
                setTitle("Text Editor - " + currentFile);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error opening file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveFile() {
        if (currentFile.equals("Untitled")) {
            saveFileAs();
        } else {
            try {
                FileWriter writer = new FileWriter(currentFile);
                writer.write(textArea.getText());
                writer.close();
                isModified = false;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveFileAs() {
        int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(textArea.getText());
                writer.close();
                currentFile = file.getAbsolutePath();
                isModified = false;
                setTitle("Text Editor - " + currentFile);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void exitEditor() {
        if (isModified) {
            int choice = JOptionPane.showConfirmDialog(this, "Save changes to " + currentFile + "?", "Text Editor", JOptionPane.YES_NO_CANCEL_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                saveFile();
            } else if (choice == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }
        dispose();
    }

    private void changeFont() {
        Font selectedFont = JFontChooser.showDialog(this, "Choose Font", textArea.getFont());
        if (selectedFont != null) {
            textArea.setFont(selectedFont);
        }
    }

    private void changeTextColor() {
        Color selectedColor = JColorChooser.showDialog(this, "Choose Text Color", textArea.getForeground());
        if (selectedColor != null) {
            textArea.setForeground(selectedColor);
        }
    }

    private void findText() {
        String searchText = JOptionPane.showInputDialog(this, "Enter text to find:");
        if (searchText != null && !searchText.isEmpty()) {
            String text = textArea.getText();
            int index = text.indexOf(searchText);
            if (index != -1) {
                textArea.setSelectionStart(index);
                textArea.setSelectionEnd(index + searchText.length());
            } else {
                JOptionPane.showMessageDialog(this, "Text not found!");
            }
        }
    }

    private void replaceText() {
        String searchText = JOptionPane.showInputDialog(this, "Enter text to find:");
        if (searchText != null && !searchText.isEmpty()) {
            String replaceText = JOptionPane.showInputDialog(this, "Enter text to replace with:");
            if (replaceText != null) {
                String text = textArea.getText();
                String newText = text.replace(searchText, replaceText);
                textArea.setText(newText);
            }
        }
    }
    public void configureFileChooser(String userDirectoryPath) {
        fileChooser.setCurrentDirectory(new File(userDirectoryPath));
    }
    
    public static void handleLogin(UserModel userModel) {
    // Assuming you have a UserModel object named 'userModel'
    //UserModel userModel = new UserModel("E:\\universityproject\\userfiles");
     String userDirectoryPath = userModel.getUserDirectory();
     TextEditor textEditor = new TextEditor(userModel);
        textEditor.configureFileChooser(userDirectoryPath);
    // Now, create an instance of TextEditor by passing the userModel object to its constructor
    //TextEditor textEditor = new TextEditor(userModel);

    // You might then show the TextEditor frame to the user
    textEditor.setVisible(true);
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create a new instance of UserModel with the desired user directory path
                UserModel userModel = new UserModel();
                // Create and show the text editor
                //new TextEditor(userModel).setVisible(true);
                handleLogin(userModel);
            }
        });
    }
}
*/
