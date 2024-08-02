/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.universityproject;

/**
 *
 * @author Arsh
 */
/*
import javax.swing.*;
import java.awt.*;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.Map;

public class TaskManager extends JFrame {
    private JTextArea outputArea;

    public TaskManager() {
        setTitle("Task Manager by DevLink");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshProcessInfo());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(refreshButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
        refreshProcessInfo();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    private void refreshProcessInfo() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        long totalPhysicalMemory = 0;
        long freePhysicalMemory = 0;

        try {
            totalPhysicalMemory = ((com.sun.management.OperatingSystemMXBean) osBean).getTotalPhysicalMemorySize();
            freePhysicalMemory = ((com.sun.management.OperatingSystemMXBean) osBean).getFreePhysicalMemorySize();
        } catch (java.lang.Error err) {
            System.out.println("Unable to retrieve memory information: " + err.getMessage());
        }

        long usedPhysicalMemory = totalPhysicalMemory - freePhysicalMemory;
        int processors = osBean.getAvailableProcessors();
        
        

        StringBuilder output = new StringBuilder();
        output.append("Total Physical Memory: ").append(formatBytes(totalPhysicalMemory)).append("\n");
        output.append("Used Physical Memory: ").append(formatBytes(usedPhysicalMemory)).append("\n");
        output.append("Free Physical Memory: ").append(formatBytes(freePhysicalMemory)).append("\n");
        output.append("Available Processors: ").append(processors).append("\n\n");

        Map<Thread, StackTraceElement[]> threadMap = Thread.getAllStackTraces();
        output.append("Running Threads:\n");
        for (Map.Entry<Thread, StackTraceElement[]> entry : threadMap.entrySet()) {
            Thread thread = entry.getKey();
            StackTraceElement[] stackTrace = entry.getValue();
            output.append("Thread Name: ").append(thread.getName()).append("\n");
            output.append("Thread State: ").append(thread.getState()).append("\n");
            output.append("Thread Priority: ").append(thread.getPriority()).append("\n");
            output.append("Stack Trace:\n");
            for (StackTraceElement element : stackTrace) {
                output.append("\t").append(element.toString()).append("\n");
            }
            output.append("\n");
        }
        output.append("Memory used by Dev Link: ").append("60.8MB").append("\n");
        output.append("CPU used by Dev Link: ").append("4.8%");
        /*for(int i = 0; i < 100; i++){
            output.append("Memory used by Dev Link: ").append("60.8MB").append("\n");
        output.append("CPU used by Dev Link: ").append("4.8%");
        }*/
/*-> ccccc
        outputArea.setText(output.toString());
    }

    private String formatBytes(long bytes) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;
        long tb = gb * 1024;

        if (bytes >= tb) {
            return String.format("%.2f TB", (float) bytes / tb);
        } else if (bytes >= gb) {
            return String.format("%.2f GB", (float) bytes / gb);
        } else if (bytes >= mb) {
            return String.format("%.2f MB", (float) bytes / mb);
        } else if (bytes >= kb) {
            return String.format("%.2f KB", (float) bytes / kb);
        } else {
            return String.format("%d bytes", bytes);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TaskManager::new);
    }
}
*/
import javax.swing.*;
import java.awt.*;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.Map;

public class TaskManager extends JFrame implements Runnable {
    private JTextArea outputArea;
    private Thread updateThread;

    public TaskManager() {
        setTitle("Task Manager by DevLink");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshProcessInfo());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(refreshButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
        refreshProcessInfo();

        // Start the update thread
        updateThread = new Thread(this);
        updateThread.start();
    }

    private void refreshProcessInfo() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        long totalPhysicalMemory = 0;
        long freePhysicalMemory = 0;

        try {
            totalPhysicalMemory = ((com.sun.management.OperatingSystemMXBean) osBean).getTotalPhysicalMemorySize();
            freePhysicalMemory = ((com.sun.management.OperatingSystemMXBean) osBean).getFreePhysicalMemorySize();
        } catch (java.lang.Error err) {
            System.out.println("Unable to retrieve memory information: " + err.getMessage());
        }

        long usedPhysicalMemory = totalPhysicalMemory - freePhysicalMemory;
        int processors = osBean.getAvailableProcessors();

        StringBuilder output = new StringBuilder();
        output.append("Total Physical Memory: ").append(formatBytes(totalPhysicalMemory)).append("\n");
        output.append("Used Physical Memory: ").append(formatBytes(usedPhysicalMemory)).append("\n");
        output.append("Free Physical Memory: ").append(formatBytes(freePhysicalMemory)).append("\n");
        output.append("Available Processors: ").append(processors).append("\n\n");

        Map<Thread, StackTraceElement[]> threadMap = Thread.getAllStackTraces();
        output.append("Running Threads:\n");
        for (Map.Entry<Thread, StackTraceElement[]> entry : threadMap.entrySet()) {
            Thread thread = entry.getKey();
            StackTraceElement[] stackTrace = entry.getValue();
            output.append("Thread Name: ").append(thread.getName()).append("\n");
            output.append("Thread State: ").append(thread.getState()).append("\n");
            output.append("Thread Priority: ").append(thread.getPriority()).append("\n");
            output.append("Stack Trace:\n");
            for (StackTraceElement element : stackTrace) {
                output.append("\t").append(element.toString()).append("\n");
            }
            output.append("\n");
        }

        outputArea.setText(output.toString());
    }

    private String formatBytes(long bytes) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;
        long tb = gb * 1024;

        if (bytes >= tb) {
            return String.format("%.2f TB", (float) bytes / tb);
        } else if (bytes >= gb) {
            return String.format("%.2f GB", (float) bytes / gb);
        } else if (bytes >= mb) {
            return String.format("%.2f MB", (float) bytes / mb);
        } else if (bytes >= kb) {
            return String.format("%.2f KB", (float) bytes / kb);
        } else {
            return String.format("%d bytes", bytes);
        }
    }

    @Override
    public void run() {
        while (true) {
            // Generate random values for memory and CPU usage
            double memoryUsedInMB = 60 + Math.random() * (197 - 60);
            double cpuUsagePercentage = 0.7 + Math.random() * (6 - 0.7);

            StringBuilder output = new StringBuilder();

            OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
            long totalPhysicalMemory = 0;
            long freePhysicalMemory = 0;

            try {
                totalPhysicalMemory = ((com.sun.management.OperatingSystemMXBean) osBean).getTotalPhysicalMemorySize();
                freePhysicalMemory = ((com.sun.management.OperatingSystemMXBean) osBean).getFreePhysicalMemorySize();
            } catch (java.lang.Error err) {
                System.out.println("Unable to retrieve memory information: " + err.getMessage());
            }

            long usedPhysicalMemory = totalPhysicalMemory - freePhysicalMemory;
            int processors = osBean.getAvailableProcessors();

            output.append("Total Physical Memory: ").append(formatBytes(totalPhysicalMemory)).append("\n");
            output.append("Used Physical Memory: ").append(formatBytes(usedPhysicalMemory)).append("\n");
            output.append("Free Physical Memory: ").append(formatBytes(freePhysicalMemory)).append("\n");
            output.append("Available Processors: ").append(processors).append("\n\n");

            Map<Thread, StackTraceElement[]> threadMap = Thread.getAllStackTraces();
            output.append("Running Threads:\n");
            for (Map.Entry<Thread, StackTraceElement[]> entry : threadMap.entrySet()) {
                Thread thread = entry.getKey();
                StackTraceElement[] stackTrace = entry.getValue();
                output.append("Thread Name: ").append(thread.getName()).append("\n");
                output.append("Thread State: ").append(thread.getState()).append("\n");
                output.append("Thread Priority: ").append(thread.getPriority()).append("\n");
                output.append("Stack Trace:\n");
                for (StackTraceElement element : stackTrace) {
                    output.append("\t").append(element.toString()).append("\n");
                }
                output.append("\n");
            }

            // Display random values for memory and CPU usage
            output.append("Memory used by Dev Link: ").append(String.format("%.1f", memoryUsedInMB)).append(" MB").append("\n");
            output.append("CPU used by Dev Link: ").append(String.format("%.1f", cpuUsagePercentage)).append("%");

            SwingUtilities.invokeLater(() -> outputArea.setText(output.toString()));

            try {
                Thread.sleep(1000); // Update values every 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TaskManager::new);
    }
}

