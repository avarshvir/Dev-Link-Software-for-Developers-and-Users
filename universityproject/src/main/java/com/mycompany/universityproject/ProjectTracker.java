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
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectTracker extends JFrame {
    private JTable projectTable;
    private DefaultTableModel tableModel;
    private List<Project> projects;

    public ProjectTracker() {
        setTitle("Project Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        // Initialize data structures
        projects = new ArrayList<>();
        tableModel = new DefaultTableModel(new Object[]{"Project Name", "Requirements", "Start Date", "Deadline", "Modules/Methods", "Status"}, 0);
        projectTable = new JTable(tableModel);

        // Create components
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout());
        JButton addProjectButton = new JButton("Add Project");
        topPanel.add(addProjectButton);

        JScrollPane scrollPane = new JScrollPane(projectTable);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);

        // Add action listeners
        addProjectButton.addActionListener(new AddProjectListener());
        projectTable.setComponentPopupMenu(createPopupMenu());
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    
    }

    private class AddProjectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String projectName = JOptionPane.showInputDialog(ProjectTracker.this, "Enter project name:");
            if (projectName != null && !projectName.isEmpty()) {
                String requirements = JOptionPane.showInputDialog(ProjectTracker.this, "Enter project requirements:");
                String startDateStr = JOptionPane.showInputDialog(ProjectTracker.this, "Enter start date (yyyy-MM-dd):");
                String deadlineDateStr = JOptionPane.showInputDialog(ProjectTracker.this, "Enter deadline (yyyy-MM-dd):");
                String modulesMethodsStr = JOptionPane.showInputDialog(ProjectTracker.this, "Enter modules/methods (comma-separated):");

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = null, deadlineDate = null;
                try {
                    startDate = dateFormat.parse(startDateStr);
                    deadlineDate = dateFormat.parse(deadlineDateStr);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(ProjectTracker.this, "Invalid date format.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Project newProject = new Project(projectName, requirements, startDate, deadlineDate, modulesMethodsStr);
                projects.add(newProject);
                tableModel.addRow(new Object[]{projectName, requirements, startDateStr, deadlineDateStr, modulesMethodsStr, "Open"});
            }
        }
    }

    private JPopupMenu createPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem closeProjectMenuItem = new JMenuItem("Close Project");
        closeProjectMenuItem.addActionListener(new CloseProjectListener());
        popupMenu.add(closeProjectMenuItem);

        JMenuItem deleteProjectMenuItem = new JMenuItem("Delete Project");
        deleteProjectMenuItem.addActionListener(new DeleteProjectListener());
        popupMenu.add(deleteProjectMenuItem);

        return popupMenu;
    }

    private class CloseProjectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = projectTable.getSelectedRow();
            if (selectedRow != -1) {
                String projectName = (String) tableModel.getValueAt(selectedRow, 0);
                Project project = findProjectByName(projectName);
                if (project != null) {
                    project.setStatus("Closed");
                    tableModel.setValueAt("Closed", selectedRow, 5);
                }
            }
        }
    }

    private class DeleteProjectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = projectTable.getSelectedRow();
            if (selectedRow != -1) {
                String projectName = (String) tableModel.getValueAt(selectedRow, 0);
                Project project = findProjectByName(projectName);
                if (project != null) {
                    int confirm = JOptionPane.showConfirmDialog(ProjectTracker.this, "Are you sure you want to delete the project?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        projects.remove(project);
                        tableModel.removeRow(selectedRow);
                    }
                }
            }
        }
    }

    private Project findProjectByName(String projectName) {
        for (Project project : projects) {
            if (project.getName().equals(projectName)) {
                return project;
            }
        }
        return null;
    }

    private static class Project {
        private String name;
        private String requirements;
        private Date startDate;
        private Date deadlineDate;
        private String modulesMethodsStr;
        private String status;

        public Project(String name, String requirements, Date startDate, Date deadlineDate, String modulesMethodsStr) {
            this.name = name;
            this.requirements = requirements;
            this.startDate = startDate;
            this.deadlineDate = deadlineDate;
            this.modulesMethodsStr = modulesMethodsStr;
            this.status = "Open";
        }

        public String getName() {
            return name;
        }

        public String getRequirements() {
            return requirements;
        }

        public Date getStartDate() {
            return startDate;
        }

        public Date getDeadlineDate() {
            return deadlineDate;
        }

        public String getModulesMethodsStr() {
            return modulesMethodsStr;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProjectTracker tracker = new ProjectTracker();
            tracker.setVisible(true);
        });
    }
    
}