/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafiles;

/**
 *
 * @author Arsh
 */
/*
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PresentationApplication extends JFrame {

    private JPanel bigPanel; // Panel to add images and text
    private int slideCounter = 1; // Counter to keep track of slides

    public PresentationApplication() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600); // Setting initial size

        // Main panel to hold buttons and big panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel to hold buttons
        JPanel buttonPanel = new JPanel();
        JButton insertImageButton = new JButton("Insert Image");
        JButton insertTextButton = new JButton("Insert Text");
        JButton addSlideButton = new JButton("Add Slide");

        // Adding action listeners to buttons
        insertImageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open a file chooser dialog to select an image
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Get the selected image file
                    ImageIcon imageIcon = new ImageIcon(fileChooser.getSelectedFile().getPath());
                    // Create a JLabel to display the image
                    JLabel imageLabel = new JLabel(imageIcon);
                    // Add the image label to the big panel
                    bigPanel.add(imageLabel);
                    // Refresh the big panel
                    bigPanel.revalidate();
                    bigPanel.repaint();
                }
            }
        });

        insertTextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open an input dialog to enter text
                String text = JOptionPane.showInputDialog(null, "Enter text:");
                if (text != null && !text.isEmpty()) {
                    // Create a JLabel to display the text
                    JLabel textLabel = new JLabel(text);
                    // Add the text label to the big panel
                    bigPanel.add(textLabel);
                    // Refresh the big panel
                    bigPanel.revalidate();
                    bigPanel.repaint();
                }
            }
        });

        addSlideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a new big panel for the next slide
                bigPanel = new JPanel();
                bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.Y_AXIS));
                // Add the big panel to the main panel
                mainPanel.add(bigPanel, BorderLayout.CENTER);
                // Increment slide counter
                slideCounter++;
                // Refresh the UI
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        buttonPanel.add(insertImageButton);
        buttonPanel.add(insertTextButton);
        buttonPanel.add(addSlideButton);

        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        // Initial big panel
        bigPanel = new JPanel();
        bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.Y_AXIS));
        mainPanel.add(bigPanel, BorderLayout.CENTER);

        getContentPane().add(mainPanel);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PresentationApplication().setVisible(true);
            }
        });
    }
}*/
/*
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class PresentationApplication extends JFrame {

    private JPanel bigPanel; // Panel to add images and text
    private JPanel sidePanel; // Panel to display content from previous slides
    private int slideCounter = 1; // Counter to keep track of slides

    public PresentationApplication() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600); // Setting initial size

        // Main panel to hold buttons, big panel, and side panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel to hold buttons
        JPanel buttonPanel = new JPanel();
        JButton insertImageButton = new JButton("Insert Image");
        JButton insertTextButton = new JButton("Insert Text");
        JButton addSlideButton = new JButton("Add Slide");
        JButton saveButton = new JButton("Save");

        // Adding action listeners to buttons
        insertImageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open a file chooser dialog to select an image
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Get the selected image file
                    ImageIcon imageIcon = new ImageIcon(fileChooser.getSelectedFile().getPath());
                    // Create a JLabel to display the image
                    JLabel imageLabel = new JLabel(imageIcon);
                    // Add the image label to the big panel
                    bigPanel.add(imageLabel);
                    // Refresh the big panel
                    bigPanel.revalidate();
                    bigPanel.repaint();
                }
            }
        });

        insertTextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open an input dialog to enter text
                String text = JOptionPane.showInputDialog(null, "Enter text:");
                if (text != null && !text.isEmpty()) {
                    // Create a JLabel to display the text
                    JLabel textLabel = new JLabel(text);
                    // Add the text label to the big panel
                    bigPanel.add(textLabel);
                    // Refresh the big panel
                    bigPanel.revalidate();
                    bigPanel.repaint();
                }
            }
        });

        addSlideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Move content from big panel to side panel
                if (bigPanel.getComponentCount() > 0) {
                    JPanel slidePanel = new JPanel();
                    slidePanel.setLayout(new BoxLayout(slidePanel, BoxLayout.Y_AXIS));
                    // Transfer components from big panel to slide panel
                    Component[] components = bigPanel.getComponents();
                    for (Component component : components) {
                        slidePanel.add(component);
                    }
                    // Add slide panel to side panel
                    sidePanel.add(slidePanel);
                    // Clear big panel
                    bigPanel.removeAll();
                    bigPanel.revalidate();
                    bigPanel.repaint();
                }
            }
        });

        
        
        saveButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        // Set the default directory to a dedicated folder
        fileChooser.setCurrentDirectory(new File("E:\\universityproject\\userfiles"));
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File file = fileChooser.getSelectedFile();
            // Perform saving operation to the selected file
            // This might involve writing data to the file
            // For simplicity, let's just display the selected file path
            JOptionPane.showMessageDialog(null, "Presentation saved to: " + file.getAbsolutePath());
        }
    }
});


        buttonPanel.add(insertImageButton);
        buttonPanel.add(insertTextButton);
        buttonPanel.add(addSlideButton);
        buttonPanel.add(saveButton);

        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        // Initial big panel
        bigPanel = new JPanel();
        bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.Y_AXIS));
        mainPanel.add(bigPanel, BorderLayout.CENTER);

        // Side panel to display content from previous slides
        sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        JScrollPane sideScrollPane = new JScrollPane(sidePanel);
        mainPanel.add(sideScrollPane, BorderLayout.WEST);

        getContentPane().add(mainPanel);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PresentationApplication().setVisible(true);
            }
        });
    }
}
*/
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PresentationApplication extends JFrame {

    private JPanel bigPanel; // Panel to add images and text
    private JPanel sidePanel; // Panel to display content from previous slides
    private int slideCounter = 1; // Counter to keep track of slides

    public PresentationApplication() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(800, 600); // Setting initial size

        // Main panel to hold buttons, big panel, and side panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel to hold buttons
        JPanel buttonPanel = new JPanel();
        JButton insertImageButton = new JButton("Insert Image");
        JButton insertTextButton = new JButton("Insert Text");
        JButton addSlideButton = new JButton("Add Slide");
        JButton saveButton = new JButton("Save");

        // Adding action listeners to buttons
        insertImageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open a file chooser dialog to select an image
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Get the selected image file
                    ImageIcon imageIcon = new ImageIcon(fileChooser.getSelectedFile().getPath());
                    // Create a JLabel to display the image
                    JLabel imageLabel = new JLabel(imageIcon);
                    // Add the image label to the big panel
                    bigPanel.add(imageLabel);
                    // Refresh the big panel
                    bigPanel.revalidate();
                    bigPanel.repaint();
                }
            }
        });

        insertTextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open an input dialog to enter text
                String text = JOptionPane.showInputDialog(null, "Enter text:");
                if (text != null && !text.isEmpty()) {
                    // Create a JLabel to display the text
                    JLabel textLabel = new JLabel(text);
                    // Add the text label to the big panel
                    bigPanel.add(textLabel);
                    // Refresh the big panel
                    bigPanel.revalidate();
                    bigPanel.repaint();
                }
            }
        });

        addSlideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Move content from big panel to side panel
                if (bigPanel.getComponentCount() > 0) {
                    JPanel slidePanel = new JPanel();
                    slidePanel.setLayout(new BoxLayout(slidePanel, BoxLayout.Y_AXIS));
                    // Transfer components from big panel to slide panel
                    Component[] components = bigPanel.getComponents();
                    for (Component component : components) {
                        slidePanel.add(component);
                    }
                    // Add slide panel to side panel
                    sidePanel.add(slidePanel);
                    // Clear big panel
                    bigPanel.removeAll();
                    bigPanel.revalidate();
                    bigPanel.repaint();
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a BufferedImage to hold the contents of bigPanel
                BufferedImage image = new BufferedImage(bigPanel.getWidth(), bigPanel.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = image.createGraphics();
                bigPanel.paint(g);
                g.dispose();
                
                // Initialize file chooser
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("E:\\universityproject\\userfiles")); // Set default directory
                fileChooser.setDialogTitle("Save Presentation as PNG");
                fileChooser.setFileFilter(new FileNameExtensionFilter("PNG files", "png"));

                // Show save dialog
                int result = fileChooser.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Get the selected file
                    File file = fileChooser.getSelectedFile();
                    // Ensure file ends with ".png" extension
                    if (!file.getName().toLowerCase().endsWith(".png")) {
                        file = new File(file.getParentFile(), file.getName() + ".png");
                    }
                    // Save the image to the selected file
                    try {
                        ImageIO.write(image, "png", file);
                        JOptionPane.showMessageDialog(null, "Presentation saved as PNG: " + file.getAbsolutePath());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Failed to save presentation as PNG.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        buttonPanel.add(insertImageButton);
        buttonPanel.add(insertTextButton);
        buttonPanel.add(addSlideButton);
        buttonPanel.add(saveButton);

        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        // Initial big panel
        bigPanel = new JPanel();
        bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.Y_AXIS));
        mainPanel.add(bigPanel, BorderLayout.CENTER);

        // Side panel to display content from previous slides
        sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        JScrollPane sideScrollPane = new JScrollPane(sidePanel);
        mainPanel.add(sideScrollPane, BorderLayout.WEST);

        getContentPane().add(mainPanel);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PresentationApplication().setVisible(true);
            }
        });
    }
}



