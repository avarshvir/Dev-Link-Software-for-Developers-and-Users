/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.TimeApp to edit this template
 */
package javafiles;

/**
 *
 * @author Arsh
 */
/*import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
public class TimeApp {
    
    /*public void timeFun(){
        Calendar c = Calendar.getInstance();
        
    }*/
    
   /* private static String formatDate(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }
    
    public static void main(String args[]){
        Calendar c = Calendar.getInstance();
        Date currentDate = c.getTime();
        String currentTime = formatDate(currentDate, "HH:mm:ss"); // Extract time
        String currentDateStr = formatDate(currentDate, "yyyy-MM-dd"); // Extract date
        
        Frame f = new Frame("Time App");
        
        //Label miniTimerLabel = new Label("Mini Timer", Label.CENTER);
        
        Label l1 = new Label("Time : ");
        Label l2 = new Label("Date : ");
        
        TextField tf1 = new TextField(currentTime,10);
        tf1.setEditable(false);
        TextField tf2 = new TextField(currentDateStr,10);
        tf2.setEditable(false);
        
        //f.add(miniTimerLabel);
        f.add(l1);
        f.add(tf1);
        f.add(l2);
        f.add(tf2);
        
        
        f.setLayout(new FlowLayout());
        f.setSize(200,200);
        f.setVisible(true);
        
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose(); // Close the frame when close button is clicked
            }
        });
    }
}*/
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class TimeApp extends JFrame {
    
    private static String formatDate(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }
    
    public static void main(String args[]){
        Calendar c = Calendar.getInstance();
        Date currentDate = c.getTime();
        String currentTime = formatDate(currentDate, "HH:mm:ss"); // Extract time
        String currentDateStr = formatDate(currentDate, "yyyy-MM-dd"); // Extract date
        
        JFrame frame = new JFrame("Time App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(2, 2));
        
        JLabel l1 = new JLabel("Time : ");
        JLabel l2 = new JLabel("Date : ");
        
        JTextField tf1 = new JTextField(currentTime, 10);
        tf1.setEditable(false);
        JTextField tf2 = new JTextField(currentDateStr, 10);
        tf2.setEditable(false);
        
        panel.add(l1);
        panel.add(tf1);
        panel.add(l2);
        panel.add(tf2);
        
        frame.add(panel);
        
        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

