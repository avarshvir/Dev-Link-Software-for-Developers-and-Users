/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.universityproject;

/**
 *
 * @author Arsh
 *//*
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class CalendarApp extends JFrame {
    private final JLabel monthLabel;
    private final JTextArea reminderTextArea;
    private final JButton[][] dayButtons;
    private final Calendar calendar;
    private final int userId;

    
    
    
    public CalendarApp(int userId) {
        super("Calendar App");
        this.userId = userId;

        calendar = Calendar.getInstance();
        monthLabel = new JLabel("", SwingConstants.CENTER);
        reminderTextArea = new JTextArea(10, 20);
        reminderTextArea.setEditable(false);
        dayButtons = new JButton[6][7];

        setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel dayPanel = new JPanel(new GridLayout(6, 7));

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                dayButtons[row][col] = new JButton();
                dayButtons[row][col].setPreferredSize(new Dimension(60, 60));
                dayButtons[row][col].addActionListener(new DayButtonActionListener(row, col));
                dayPanel.add(dayButtons[row][col]);
            }
        }

        centerPanel.add(dayPanel, BorderLayout.CENTER);
        centerPanel.add(new JScrollPane(reminderTextArea), BorderLayout.EAST);
        add(centerPanel, BorderLayout.CENTER);
        add(monthLabel, BorderLayout.NORTH);

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        updateCalendar();
    }

    private void updateCalendar() {
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        monthLabel.setText((calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, java.util.Locale.getDefault()) + " " + year).toUpperCase());

        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayCount = 1;

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if ((row == 0 && col < startDay) || dayCount > daysInMonth) {
                    dayButtons[row][col].setText("");
                    dayButtons[row][col].setForeground(Color.LIGHT_GRAY);
                } else {
                    dayButtons[row][col].setText(String.valueOf(dayCount));
                    dayButtons[row][col].setForeground(Color.BLACK);
                    dayCount++;
                }
            }
        }

        loadReminders();
    }

    private void loadReminders() {
        reminderTextArea.setText("");

        try {
            Connection connection = SingletonDatabase.getInstance().connection;
            String query = "SELECT reminder, reminder_date FROM reminders WHERE user_id = ? AND reminder_date BETWEEN ? AND ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);

            calendar.set(Calendar.DAY_OF_MONTH, 1);
            Date startDate = calendar.getTime();
            calendar.add(Calendar.MONTH, 1);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            Date endDate = calendar.getTime();

            statement.setDate(2, new java.sql.Date(startDate.getTime()));
            statement.setDate(3, new java.sql.Date(endDate.getTime()));

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String reminder = resultSet.getString("reminder");
                Date reminderDate = resultSet.getDate("reminder_date");
                reminderTextArea.append(String.format("%tD: %s\n", reminderDate, reminder));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private class DayButtonActionListener implements ActionListener {
        private final int row;
        private final int col;

        public DayButtonActionListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int day = Integer.parseInt(dayButtons[row][col].getText());
            calendar.set(Calendar.DAY_OF_MONTH, day);

            String reminder = JOptionPane.showInputDialog(CalendarApp.this, "Enter a reminder for " + calendar.getTime() + ":");

            if (reminder != null && !reminder.isEmpty()) {
                try {
                    Connection connection = SingletonDatabase.getInstance().connection;
                    String query = "INSERT INTO reminders (user_id, reminder, reminder_date) VALUES (?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setInt(1, userId);
                    statement.setString(2, reminder);
                    statement.setDate(3, new java.sql.Date(calendar.getTimeInMillis()));
                    statement.executeUpdate();
                    statement.close();

                    loadReminders();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // Replace 'userId' with the appropriate user ID
        // This should be the ID of the logged-in user
        new CalendarApp(1);
    }
}*//*
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;

public class CalendarApp extends JFrame {
    private final JLabel monthLabel;
    private final JTextArea reminderTextArea;
    private final JButton[][] dayButtons;
    private final Calendar calendar;
    private final int userId;

    public CalendarApp(int userId) {
        super("Calendar App");
        this.userId = userId;

        calendar = Calendar.getInstance();
        monthLabel = new JLabel("", SwingConstants.CENTER);
        reminderTextArea = new JTextArea(10, 20);
        reminderTextArea.setEditable(false);
        dayButtons = new JButton[6][7];

        setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel dayPanel = new JPanel(new GridLayout(6, 7));

        JButton prevMonthButton = new JButton("< Prev Month");
        prevMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.add(Calendar.MONTH, -1);
                updateCalendar();
            }
        });

        JButton nextMonthButton = new JButton("Next Month >");
        nextMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.add(Calendar.MONTH, 1);
                updateCalendar();
            }
        });

        JButton prevYearButton = new JButton("< Prev Year");
        prevYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.add(Calendar.YEAR, -1);
                updateCalendar();
            }
        });

        JButton nextYearButton = new JButton("Next Year >");
        nextYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.add(Calendar.YEAR, 1);
                updateCalendar();
            }
        });

        JPanel navPanel = new JPanel(new GridLayout(1, 4));
        navPanel.add(prevYearButton);
        navPanel.add(prevMonthButton);
        navPanel.add(nextMonthButton);
        navPanel.add(nextYearButton);

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                dayButtons[row][col] = new JButton();
                dayButtons[row][col].setPreferredSize(new Dimension(60, 60));
                dayButtons[row][col].addActionListener(new DayButtonActionListener(row, col));
                dayPanel.add(dayButtons[row][col]);
            }
        }

        centerPanel.add(navPanel, BorderLayout.NORTH);
        centerPanel.add(dayPanel, BorderLayout.CENTER);
        centerPanel.add(new JScrollPane(reminderTextArea), BorderLayout.EAST);
        add(centerPanel, BorderLayout.CENTER);
        add(monthLabel, BorderLayout.NORTH);

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        updateCalendar();
    }

    private void updateCalendar() {
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        monthLabel.setText((calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, java.util.Locale.getDefault()) + " " + year).toUpperCase());

        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayCount = 1;

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if ((row == 0 && col < startDay) || dayCount > daysInMonth) {
                    dayButtons[row][col].setText("");
                    dayButtons[row][col].setForeground(Color.LIGHT_GRAY);
                } else {
                    dayButtons[row][col].setText(String.valueOf(dayCount));
                    dayButtons[row][col].setForeground(Color.BLACK);
                    dayCount++;
                }
            }
        }

        loadReminders();
    }

    private void loadReminders() {
        reminderTextArea.setText("");

        try {
            Connection connection = SingletonDatabase.getInstance().connection;
            String query = "SELECT reminder, reminder_date FROM reminders WHERE user_id = ? AND reminder_date BETWEEN ? AND ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);

            calendar.set(Calendar.DAY_OF_MONTH, 1);
            Date startDate = calendar.getTime();
            calendar.add(Calendar.MONTH, 1);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            Date endDate = calendar.getTime();

            statement.setDate(2, new java.sql.Date(startDate.getTime()));
            statement.setDate(3, new java.sql.Date(endDate.getTime()));

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String reminder = resultSet.getString("reminder");
                Date reminderDate = resultSet.getDate("reminder_date");
                reminderTextArea.append(String.format("%tD: %s\n", reminderDate, reminder));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private class DayButtonActionListener implements ActionListener {
        private final int row;
        private final int col;

        public DayButtonActionListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int day = Integer.parseInt(dayButtons[row][col].getText());
            calendar.set(Calendar.DAY_OF_MONTH, day);

            String reminder = JOptionPane.showInputDialog(CalendarApp.this, "Enter a reminder for " + calendar.getTime() + ":");

            if (reminder != null && !reminder.isEmpty()) {
                try {
                    Connection connection = SingletonDatabase.getInstance().connection;
                    String query = "INSERT INTO reminders (user_id, reminder, reminder_date) VALUES (?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setInt(1, userId);
                    statement.setString(2, reminder);
                    statement.setDate(3, new java.sql.Date(calendar.getTimeInMillis()));
                    statement.executeUpdate();
                    statement.close();

                    loadReminders();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // Replace 'userId' with the appropriate user ID
        // This should be the ID of the logged-in user
        new CalendarApp(1);
    }
}
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarApp extends JFrame {
    private final JLabel monthLabel;
    private final JTextArea reminderTextArea;
    private final JButton[][] dayButtons;
    private final Calendar calendar;
    private final int userId;

    public CalendarApp(int userId) {
        super("Calendar App");
        this.userId = userId;

        calendar = Calendar.getInstance();
        monthLabel = new JLabel("", SwingConstants.CENTER);
        reminderTextArea = new JTextArea(10, 20);
        reminderTextArea.setEditable(false);
        dayButtons = new JButton[6][7];

        setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel dayPanel = new JPanel(new GridLayout(7, 7));

        JButton prevMonthButton = new JButton("< Prev Month");
        prevMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.add(Calendar.MONTH, -1);
                updateCalendar();
            }
        });

        JButton nextMonthButton = new JButton("Next Month >");
        nextMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.add(Calendar.MONTH, 1);
                updateCalendar();
            }
        });

        JButton prevYearButton = new JButton("< Prev Year");
        prevYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.add(Calendar.YEAR, -1);
                updateCalendar();
            }
        });

        JButton nextYearButton = new JButton("Next Year >");
        nextYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.add(Calendar.YEAR, 1);
                updateCalendar();
            }
        });

        JPanel navPanel = new JPanel(new GridLayout(1, 4));
        navPanel.add(prevYearButton);
        navPanel.add(prevMonthButton);
        navPanel.add(nextMonthButton);
        navPanel.add(nextYearButton);

        String[] dayNames = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String dayName : dayNames) {
            JLabel dayLabel = new JLabel(dayName, SwingConstants.CENTER);
            dayPanel.add(dayLabel);
        }

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                dayButtons[row][col] = new JButton();
                dayButtons[row][col].setPreferredSize(new Dimension(60, 60));
                dayButtons[row][col].addActionListener(new DayButtonActionListener(row, col));
                dayPanel.add(dayButtons[row][col]);
            }
        }

        centerPanel.add(navPanel, BorderLayout.NORTH);
        centerPanel.add(dayPanel, BorderLayout.CENTER);
        centerPanel.add(new JScrollPane(reminderTextArea), BorderLayout.EAST);
        add(centerPanel, BorderLayout.CENTER);
        add(monthLabel, BorderLayout.NORTH);

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        updateCalendar();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private void updateCalendar() {
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        monthLabel.setText((calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, java.util.Locale.getDefault()) + " " + year).toUpperCase());

        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayCount = 1;

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if ((row == 0 && col < startDay) || dayCount > daysInMonth) {
                    dayButtons[row][col].setText("");
                    dayButtons[row][col].setForeground(Color.LIGHT_GRAY);
                } else {
                    dayButtons[row][col].setText(String.valueOf(dayCount));
                    dayButtons[row][col].setForeground(Color.BLACK);
                    dayCount++;
                }
            }
        }

        loadReminders();
    }

    private void loadReminders() {
        reminderTextArea.setText("");

        try {
            Connection connection = SingletonDatabase.getInstance().connection;
            String query = "SELECT id, reminder, reminder_date FROM reminders WHERE user_id = ? AND reminder_date BETWEEN ? AND ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);

            calendar.set(Calendar.DAY_OF_MONTH, 1);
            Date startDate = calendar.getTime();
            calendar.add(Calendar.MONTH, 1);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            Date endDate = calendar.getTime();

            statement.setDate(2, new java.sql.Date(startDate.getTime()));
            statement.setDate(3, new java.sql.Date(endDate.getTime()));

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int reminderId = resultSet.getInt("id");
                String reminder = resultSet.getString("reminder");
                Date reminderDate = resultSet.getDate("reminder_date");
                SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd yyyy");
                String formattedDate = sdf.format(reminderDate);
                reminderTextArea.append(formattedDate + ": " + reminder + "\n");

                // Add edit and delete buttons for each reminder
                JButton editButton = new JButton("Edit");
                JButton deleteButton = new JButton("Delete");

                editButton.addActionListener(new EditButtonActionListener(reminderId));
                deleteButton.addActionListener(new DeleteButtonActionListener(reminderId));

                reminderTextArea.add(editButton);
                reminderTextArea.add(deleteButton);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private class DayButtonActionListener implements ActionListener {
        private final int row;
        private final int col;

        public DayButtonActionListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int day = Integer.parseInt(dayButtons[row][col].getText());
            calendar.set(Calendar.DAY_OF_MONTH, day);

            String reminder = JOptionPane.showInputDialog(CalendarApp.this, "Enter a reminder for " + calendar.getTime() + ":");

            if (reminder != null && !reminder.isEmpty()) {
                try {
                    Connection connection = SingletonDatabase.getInstance().connection;
                    String query = "INSERT INTO reminders (user_id, reminder, reminder_date) VALUES (?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setInt(1, userId);
                    statement.setString(2, reminder);
                    statement.setDate(3, new java.sql.Date(calendar.getTimeInMillis()));
                    statement.executeUpdate();
                    statement.close();

                    loadReminders();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private class EditButtonActionListener implements ActionListener {
        private final int reminderId;

        public EditButtonActionListener(int reminderId) {
            this.reminderId = reminderId;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String newReminder = JOptionPane.showInputDialog(CalendarApp.this, "Enter a new reminder:");
            if (newReminder != null && !newReminder.isEmpty()) {
                try {
                    Connection connection = SingletonDatabase.getInstance().connection;
                    String query = "UPDATE reminders SET reminder = ? WHERE id = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, newReminder);
                    statement.setInt(2, reminderId);
                    statement.executeUpdate();
                    statement.close();

                    loadReminders();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private class DeleteButtonActionListener implements ActionListener {
        private final int reminderId;

        public DeleteButtonActionListener(int reminderId) {
            this.reminderId = reminderId;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int confirm = JOptionPane.showConfirmDialog(CalendarApp.this, "Are you sure you want to delete this reminder?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Connection connection = SingletonDatabase.getInstance().connection;
                    String query = "DELETE FROM reminders WHERE id = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setInt(1, reminderId);
                    statement.executeUpdate();
                    statement.close();

                    loadReminders();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // Replace 'userId' with the appropriate user ID
        // This should be the ID of the logged-in user
        new CalendarApp(1);
    }
}
