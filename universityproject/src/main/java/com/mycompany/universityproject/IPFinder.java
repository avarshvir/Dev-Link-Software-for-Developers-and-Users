/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.universityproject;

/**
 *
 * @author Arsh
 */
// using concept of networking
import javax.swing.*;  
import java.awt.event.*;  
import java.net.*;  
public class IPFinder extends JFrame implements ActionListener{  
    JLabel l;  
    JTextField tf;  
    JButton b;  
IPFinder(){  
    super("IP Tool");  
    l=new JLabel("Enter URL:");  
    l.setBounds(50,70,150,20);;  
    tf=new JTextField();  
    tf.setBounds(50,100,200,20);  
      
    b=new JButton("Find IP");  
    b.setBounds(100,150,80,30);  
    b.addActionListener(this);  
    add(l);  
    add(tf);  
    add(b);  
    setSize(300,300);  
    setLayout(null);  
    setVisible(true);  
}  
public void actionPerformed(ActionEvent e){  
    String url=tf.getText();  
    try {  
        InetAddress ia=InetAddress.getByName(url);  
        String ip=ia.getHostAddress();  
        JOptionPane.showMessageDialog(this,"IP of "+url+" is: "+ip);  
    } catch (UnknownHostException e1) {  
        JOptionPane.showMessageDialog(this,e1.toString());  
    }  
}  
public static void main(String[] args) {  
    new IPFinder();  
}  
}  
