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
import java.io.InputStream;  
import java.net.*;  
import javax.swing.*;
public class SourceGetter extends JFrame implements ActionListener{  
    JTextField tf;  
    JTextArea ta;  
    JButton b;  
    JLabel l;
    JLabel titleLabel;
    SourceGetter(){  
        super("Reverse Engineering Tool"); 

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        titleLabel = new JLabel("Reverse Engineering Tool");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(50, 20, 350, 30);
        add(titleLabel);

        l=new JLabel("Enter Website URL:");  
        l.setBounds(50,50,250,20);  
          
        tf=new JTextField("https://arshvir.w3spaces.com");  
        tf.setBounds(50,100,250,30);  
          
        b=new JButton("Get Source Code");  
        b.setBounds(50, 150,180,30);  
        b.addActionListener(this);  
          
        ta=new JTextArea();  
        JScrollPane sp=new JScrollPane(ta);
        sp.setBounds(50,200,350,250);  
          
        add(titleLabel);add(l);add(tf);add(b);add(sp);  
        setSize(500,500);  
        setLayout(null);  
        setVisible(true);  
    }  
    public void actionPerformed(ActionEvent e){  
        String s=tf.getText();  
        if(s==null){}  
        else{  
            try{  
            URL u=new URL(s);  
            URLConnection uc=u.openConnection();  
          
            InputStream is=uc.getInputStream();  
            int i;  
            StringBuilder sb=new StringBuilder();  
            while((i=is.read())!=-1){  
                sb.append((char)i);  
            }  
            String source=sb.toString();  
            ta.setText(source);  
            }catch(Exception ex){JOptionPane.showMessageDialog(this,"Make Sure Connected With Internet ");}  
        }  
    }  
    public static void main(String[] args) {  
        new SourceGetter();  
    }  
}  
/*
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileWriter;
import java.net.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SourceGetter extends JFrame implements ActionListener {
    JTextField tf;
    JTextArea ta;
    JButton b;
    JLabel l, titleLabel;

    SourceGetter() {
        super("Reverse Engineering Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add title label
        titleLabel = new JLabel("Reverse Engineering Tool");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(50, 20, 350, 30);
        add(titleLabel);

        l = new JLabel("Enter Website URL:");
        l.setBounds(50, 60, 250, 20);

        tf = new JTextField("https://arshvir.w3spaces.com");
        tf.setBounds(50, 100, 250, 30);

        b = new JButton("Get Source Code and Run");
        b.setBounds(50, 150, 180, 30);
        b.addActionListener(this);

        ta = new JTextArea();
        JScrollPane sp = new JScrollPane(ta);
        sp.setBounds(50, 200, 350, 250);

        add(titleLabel);
        add(l);
        add(tf);
        add(b);
        add(sp);

        setSize(500, 500);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = tf.getText();
        if (s == null) {
        } else {
            try {
                URL u = new URL(s);
                URLConnection uc = u.openConnection();
                InputStream is = uc.getInputStream();
                int i;
                StringBuilder sb = new StringBuilder();
                while ((i = is.read()) != -1) {
                    sb.append((char) i);
                }
                String source = sb.toString();
                ta.setText(source);

                // Save the source code to a file
                File file = new File("website_source.java");
                FileWriter writer = new FileWriter(file);
                writer.write(source);
                writer.close();

                // Compile and run the source code
                Process process = Runtime.getRuntime().exec("javac website_source.java");
                process.waitFor();
                process = Runtime.getRuntime().exec("java website_source");
                process.waitFor();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Exception: " + ex);
            }
        }
    }

    public static void main(String[] args) {
        new SourceGetter();
    }
}*/