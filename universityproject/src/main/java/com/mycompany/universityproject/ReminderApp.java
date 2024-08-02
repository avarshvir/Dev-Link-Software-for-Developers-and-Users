/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.universityproject;

/**
 *
 * @author Arsh
 *//*
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class ReminderApp extends JFrame {
    private JTextField reminderTextField;
    private JSpinner hourSpinner, minuteSpinner;
    private Timer timer;
    private boolean isReminderSet = false;

    public ReminderApp() {
        setTitle("Reminder App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create components
        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel reminderLabel = new JLabel("Reminder:");
        reminderTextField = new JTextField(20);
        topPanel.add(reminderLabel);
        topPanel.add(reminderTextField);

        JPanel centerPanel = new JPanel(new FlowLayout());
        JLabel hourLabel = new JLabel("Hour:");
        hourSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
        JLabel minuteLabel = new JLabel("Minute:");
        minuteSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        centerPanel.add(hourLabel);
        centerPanel.add(hourSpinner);
        centerPanel.add(minuteLabel);
        centerPanel.add(minuteSpinner);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        JButton setReminderButton = new JButton("Set Reminder");
        setReminderButton.addActionListener(new SetReminderListener());
        bottomPanel.add(setReminderButton);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private class SetReminderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isReminderSet) {
                String reminderText = reminderTextField.getText().trim();
                if (!reminderText.isEmpty()) {
                    int hour = (int) hourSpinner.getValue();
                    int minute = (int) minuteSpinner.getValue();
                    setReminder(reminderText, hour, minute);
                    isReminderSet = true;
                } else {
                    JOptionPane.showMessageDialog(ReminderApp.this, "Please enter a reminder text.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(ReminderApp.this, "A reminder is already set.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void setReminder(String reminderText, int hour, int minute) {
        Calendar currentTime = Calendar.getInstance();
        Calendar reminderTime = Calendar.getInstance();
        reminderTime.set(Calendar.HOUR_OF_DAY, hour);
        reminderTime.set(Calendar.MINUTE, minute);
        reminderTime.set(Calendar.SECOND, 0);

        if (reminderTime.before(currentTime)) {
            reminderTime.add(Calendar.DATE, 1);
        }

        long delay = reminderTime.getTimeInMillis() - currentTime.getTimeInMillis();

        timer = new Timer();
        timer.schedule(new ReminderTask(reminderText), delay);
    }

    private class ReminderTask extends TimerTask {
        private String reminderText;

        public ReminderTask(String reminderText) {
            this.reminderText = reminderText;
        }

        @Override
        public void run() {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(ReminderApp.this, reminderText, "Reminder", JOptionPane.INFORMATION_MESSAGE);
            isReminderSet = false;
            timer.cancel();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReminderApp app = new ReminderApp();
            app.setVisible(true);
        });
    }
}*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class ReminderApp extends JFrame {

    private JTextField messageField;
    private JTextField timeField;
    private JButton setReminderButton;

    public ReminderApp() {
        setTitle("Reminder App");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        JLabel messageLabel = new JLabel("Message:");
        messageField = new JTextField();
        add(messageLabel);
        add(messageField);

        JLabel timeLabel = new JLabel("Time (in seconds):");
        timeField = new JTextField();
        add(timeLabel);
        add(timeField);

        setReminderButton = new JButton("Set Reminder");
        add(setReminderButton);

        setReminderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setReminder();
            }
        });
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    private void setReminder() {
        try {
            String message = messageField.getText();
            int timeInSeconds = Integer.parseInt(timeField.getText());

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    beep();
                    JOptionPane.showMessageDialog(null, message, "Reminder", JOptionPane.INFORMATION_MESSAGE);
                }
            }, timeInSeconds * 1000); // Convert seconds to milliseconds
            
            // for minutes timeInSeconds * 60 * 1000

            JOptionPane.showMessageDialog(null, "Reminder set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid time format. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void beep() {
        Toolkit.getDefaultToolkit().beep(); // Play system beep sound
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReminderApp().setVisible(true);
            }
        });
    }
}


