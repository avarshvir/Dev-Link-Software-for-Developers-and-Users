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
import java.io.*;

public class ToDoListManager extends JFrame {
    private DefaultListModel<JCheckBox> listModel;
    private JList<JCheckBox> taskList;
    private JTextField taskInput;
    
    

    public ToDoListManager() {
        super("To-Do List Manager");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create the list model and task list
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setBackground(new Color(255, 255, 204));
        taskList.setCellRenderer(new CheckBoxCellRenderer());

        // Create the input field and buttons
        taskInput = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton removeButton = new JButton("Delete Task");
        JButton clearButton = new JButton("Delete All Tasks");
        JButton exitButton = new JButton("Exit");

        // Set font and styling
        Font font = new Font("Arial", Font.PLAIN, 14);
        taskInput.setFont(font);
        addButton.setFont(font);
        removeButton.setFont(font);
        clearButton.setFont(font);
        exitButton.setFont(font);

        // Add action listeners
        addButton.addActionListener(new AddTaskListener());
        removeButton.addActionListener(new RemoveTaskListener());
        clearButton.addActionListener(new ClearTasksListener());
        exitButton.addActionListener(new ExitListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveTasksToFile();
                System.exit(0);
            }
        });

        // Create the layout
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        inputPanel.setBackground(new Color(255, 204, 153));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(removeButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);
        buttonPanel.setBackground(new Color(255, 204, 153));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.setBackground(new Color(255, 204, 153));

        setContentPane(mainPanel);
        setVisible(true);
        loadTasksFromFile();
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }

    private class AddTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                JCheckBox checkBox = new JCheckBox(task);
                listModel.addElement(checkBox);
                taskInput.setText("");
            }
        }
    }

    private class RemoveTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.removeElementAt(selectedIndex);
            }
        }
    }

    private class ClearTasksListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            listModel.clear();
        }
    }

    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveTasksToFile();
            //System.exit(0);
            setDefaultCloseOperation(HIDE_ON_CLOSE);
        }
    }

    private void saveTasksToFile() {
        try {
            // Specify the desired file path and name
            String filePath = "C:\\Users\\dell\\Desktop\\tasks.txt";

            PrintWriter writer = new PrintWriter(new FileWriter(filePath));
            for (int i = 0; i < listModel.getSize(); i++) {
                JCheckBox checkBox = listModel.getElementAt(i);
                writer.println(checkBox.isSelected() + "," + checkBox.getText());
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\tasks.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                boolean isSelected = Boolean.parseBoolean(parts[0]);
                String taskText = parts[1];
                JCheckBox checkBox = new JCheckBox(taskText, isSelected);
                listModel.addElement(checkBox);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static class CheckBoxCellRenderer extends JCheckBox implements ListCellRenderer<JCheckBox> {
        public CheckBoxCellRenderer() {
            setBackground(new Color(255, 255, 204));
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends JCheckBox> list, JCheckBox value, int index, boolean isSelected, boolean cellHasFocus) {
            setComponentOrientation(list.getComponentOrientation());
            setFont(list.getFont());
            setSelected(value.isSelected());
            setEnabled(list.isEnabled());
            setForeground(list.getForeground());
            setBackground(isSelected ? new Color(255, 204, 153) : new Color(255, 255, 204));
            setText(value.getText());
            return this;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoListManager();
            }
        });
    }
}