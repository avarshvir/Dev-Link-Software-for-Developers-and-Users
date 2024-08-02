/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.universityproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Arsh
 */
public class SingletonDatabase {
    public Connection connection = null;
    private static SingletonDatabase singletoneg = null;
    
    private SingletonDatabase(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/softwareutil","root","");
            if(connection != null){
            String user = "CREATE TABLE IF NOT EXISTS user(id INT AUTO_INCREMENT, full_name VARCHAR(255), email VARCHAR(255), phoneNo VARCHAR(255),username VARCHAR(255),password VARCHAR(255), PRIMARY KEY(id))";
            PreparedStatement ps = connection.prepareStatement(user);
            ps.execute();
            
            // creating a table for text files
            String textEditor = "CREATE TABLE IF NOT EXISTS textEditor(file_id INT AUTO_INCREMENT, user_id INT, file_name VARCHAR(255), file_content LONGTEXT, PRIMARY KEY(file_id), FOREIGN KEY(user_id) REFERENCES user(id))";
            PreparedStatement ps2 = connection.prepareStatement(textEditor);
            ps2.execute();
            
            String reminders = "CREATE TABLE IF NOT EXISTS reminders (id INT AUTO_INCREMENT PRIMARY KEY, user_id INT NOT NULL, reminder VARCHAR(255) NOT NULL, reminder_date DATE NOT NULL, FOREIGN KEY (user_id) REFERENCES user(id))";
                PreparedStatement ps3 = connection.prepareStatement(reminders);
                ps3.execute();
        }
        }
        catch(SQLException sqlExcepion){
            System.out.println("in exception singleton ");
        }
    }
    
     public static SingletonDatabase getInstance(){
        if(singletoneg == null){
            singletoneg = new SingletonDatabase();

        }
    
        return singletoneg;
    }
    
}
//package com.mycompany.universityproject;
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SingletonDatabase {
    public Connection connection = null;
    private static SingletonDatabase instance = null;

    private SingletonDatabase(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/softwareutil","root","");
            if(connection != null){
                // Create user table
                String userTableQuery = "CREATE TABLE IF NOT EXISTS user(id INT AUTO_INCREMENT, full_name VARCHAR(255), email VARCHAR(255), phoneNo VARCHAR(255), username VARCHAR(255), password VARCHAR(255), PRIMARY KEY(id))";

                // Create textEditor table
                String textEditorTableQuery = "CREATE TABLE IF NOT EXISTS textEditor(file_id INT AUTO_INCREMENT, user_id INT, file_name VARCHAR(255), file_content LONGTEXT, PRIMARY KEY(file_id), FOREIGN KEY(user_id) REFERENCES user(id))";

                // Create reminders table
                String remindersTableQuery = "CREATE TABLE IF NOT EXISTS reminders (id INT AUTO_INCREMENT PRIMARY KEY, user_id INT NOT NULL, reminder VARCHAR(255) NOT NULL, reminder_date DATE NOT NULL, FOREIGN KEY (user_id) REFERENCES user(id))";

                // Create projectTracker table
                String projectTrackerTableQuery = "CREATE TABLE IF NOT EXISTS projectTracker(id INT AUTO_INCREMENT, user_id INT, project_name VARCHAR(255), description TEXT, status VARCHAR(50), PRIMARY KEY(id), FOREIGN KEY(user_id) REFERENCES user(id))";

                // Execute table creation queries
                PreparedStatement createUserTable = connection.prepareStatement(userTableQuery);
                PreparedStatement createTextEditorTable = connection.prepareStatement(textEditorTableQuery);
                PreparedStatement createRemindersTable = connection.prepareStatement(remindersTableQuery);
                PreparedStatement createProjectTrackerTable = connection.prepareStatement(projectTrackerTableQuery);

                createUserTable.execute();
                createTextEditorTable.execute();
                createRemindersTable.execute();
                createProjectTrackerTable.execute();
            }
        } catch(SQLException sqlException){
            System.out.println("Error in database initialization.");
            sqlException.printStackTrace();
        }
    }

    public static SingletonDatabase getInstance(){
        if(instance == null){
            instance = new SingletonDatabase();
        }
        return instance;
    }

    // Add methods for managing other tables here
    // For example: getUsers, addUser, getRemindersForUser, addReminderForUser, etc.
}*/

