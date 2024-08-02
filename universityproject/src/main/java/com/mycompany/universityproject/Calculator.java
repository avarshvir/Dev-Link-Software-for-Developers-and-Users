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

public class Calculator extends JFrame implements ActionListener {

    private JTextField displayField;
    private double result = 0;
    private String operation = "";
    private boolean startNewNumber = true;

    Calculator() {
        setTitle("CalcByDevLink");
        setSize(261, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setEditable(false);
        add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttonLabels = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]")) {
            if (startNewNumber) {
                displayField.setText(command);
                startNewNumber = false;
            } else {
                displayField.setText(displayField.getText() + command);
            }
        } else if (command.matches("[\\+\\-\\*\\/]")) {
            performOperation(command);
            operation = command;
            startNewNumber = true;
        } else if (command.equals("=")) {
            performOperation(operation);
            operation = "";
            startNewNumber = true;
        } else if (command.equals(".")) {
            if (!displayField.getText().contains(".")) {
                displayField.setText(displayField.getText() + ".");
            }
        }
    }

    private void performOperation(String op) {
        double num = Double.parseDouble(displayField.getText());
        switch (operation) {
            case "+":
                result += num;
                break;
            case "-":
                result -= num;
                break;
            case "*":
                result *= num;
                break;
            case "/":
                result /= num;
                break;
            default:
                result = num;
        }
        displayField.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        new Calculator();
    }
}