/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafiles;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Screenshot {
    
    public static void main(String[] args) {
        takeScreenshot();
    }

    public static void takeScreenshot() {
        try {
            // Capture the screen
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenCapture = robot.createScreenCapture(screenRect);

            // Prompt the user to select a location to save the screenshot
            File path = new File("E:\\universityproject\\userfiles");
            JFileChooser fileChooser = new JFileChooser(path);
            fileChooser.setDialogTitle("Save Screenshot");
            fileChooser.setSelectedFile(new File("screenshot.png"));
            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();

                // Save the screenshot to the selected location
                ImageIO.write(screenCapture, "png", fileToSave);
                JOptionPane.showMessageDialog(null, "Screenshot saved successfully!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error taking screenshot: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

