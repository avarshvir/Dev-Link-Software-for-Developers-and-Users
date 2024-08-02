/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roughfiles;

/**
 *
 * @author Arsh
 */
import javax.swing.*;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class TaskManagerGUI {
    
    
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Task Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel memoryLabel = new JLabel();
        JLabel cpuLabel = new JLabel();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(memoryLabel);
        panel.add(cpuLabel);

        frame.getContentPane().add(panel);

        // Set the size of the frame
        frame.setSize(300, 180);

        frame.setVisible(true);

        // Update resource information
        Thread updateThread = new Thread(() -> {
            while (true) {
                // Get JVM memory usage
                MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
                MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
                MemoryUsage nonHeapMemoryUsage = memoryBean.getNonHeapMemoryUsage();

                StringBuilder memoryInfo = new StringBuilder();
                memoryInfo.append("<html>------Mini Task Manager------<br>")
                        .append("Heap Memory Usage:<br>")
                        .append("    Used: ").append(heapMemoryUsage.getUsed() / (1024 * 1024)).append(" MB<br>")
                        .append("    Max: ").append(heapMemoryUsage.getMax() / (1024 * 1024)).append(" MB<br>")
                        .append("Non-Heap Memory Usage:<br>")
                        .append("    Used: ").append(nonHeapMemoryUsage.getUsed() / (1024 * 1024)).append(" MB<br>")
                        .append("    Max: ").append(nonHeapMemoryUsage.getMax() / (1024 * 1024)).append(" MB</html>");

                // Update memory label
                SwingUtilities.invokeLater(() -> memoryLabel.setText(memoryInfo.toString()));

                // Get CPU time
                long cpuTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();

                // Update CPU time label
                SwingUtilities.invokeLater(() -> cpuLabel.setText("CPU Time: " + cpuTime + " nanoseconds"));

                try {
                    Thread.sleep(1000); // Update every 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        updateThread.setDaemon(true); // Daemon thread to stop when application exits
        updateThread.start();
        
    }
}

