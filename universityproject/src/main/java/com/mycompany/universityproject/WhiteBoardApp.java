/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.universityproject;

/**
 *
 * @author Arsh
 */import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class WhiteBoardApp extends JFrame {
    private int lastX, lastY;
    private Color currentColor = Color.BLACK;
    private Color canvasColor = Color.WHITE;
    private int eraserSize = 20; // Size of the eraser
    private DrawingArea drawingArea;

    public WhiteBoardApp() {
        setTitle("Whiteboard by DevLink");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        // Panel for drawing area
        drawingArea = new DrawingArea();
        contentPane.add(drawingArea, BorderLayout.CENTER);

        // Panel for color selection, eraser, save, open, and new buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.GRAY);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        // Buttons for color selection
        JButton blackButton = new JButton("Black");
        blackButton.addActionListener(new ColorButtonListener(Color.BLACK));
        buttonPanel.add(blackButton);

        JButton redButton = new JButton("Red");
        redButton.addActionListener(new ColorButtonListener(Color.RED));
        buttonPanel.add(redButton);

        JButton blueButton = new JButton("Blue");
        blueButton.addActionListener(new ColorButtonListener(Color.BLUE));
        buttonPanel.add(blueButton);

        // Button for eraser
        JButton eraserButton = new JButton("Eraser");
        eraserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = canvasColor; // Set current color to canvas color (white) for eraser
            }
        });
        buttonPanel.add(eraserButton);

        // Button for save
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveImage();
            }
        });
        buttonPanel.add(saveButton);

        // Button for open
        JButton openButton = new JButton("Open");
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openImage();
            }
        });
        buttonPanel.add(openButton);

        // Button for new
        JButton newButton = new JButton("New");
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawingArea.clearCanvas();
            }
        });
        buttonPanel.add(newButton);

        setContentPane(contentPane);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private class DrawingArea extends JPanel {
        public DrawingArea() {
            setBackground(Color.WHITE);
            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    lastX = e.getX();
                    lastY = e.getY();
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    Graphics g = getGraphics();
                    if (currentColor == canvasColor) {
                        // If using eraser color, set larger stroke size
                        ((Graphics2D) g).setStroke(new BasicStroke(eraserSize));
                    } else {
                        ((Graphics2D) g).setStroke(new BasicStroke(1)); // Reset stroke size for other colors
                    }
                    g.setColor(currentColor);
                    int x = e.getX();
                    int y = e.getY();
                    g.drawLine(lastX, lastY, x, y);
                    lastX = x;
                    lastY = y;
                }
            });
        }

        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }

        public void clearCanvas() {
            Graphics g = getGraphics();
            g.setColor(canvasColor);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    private class ColorButtonListener implements ActionListener {
        private Color color;

        public ColorButtonListener(Color color) {
            this.color = color;
        }

        public void actionPerformed(ActionEvent e) {
            currentColor = color;
        }
    }

    private void saveImage() {
        try {
            File path = new File("E:\\universityproject\\userfiles");
            JFileChooser fileChooser = new JFileChooser(path);
            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                ImageIO.write((BufferedImage) drawingArea.createImage(drawingArea.getWidth(), drawingArea.getHeight()), "png", fileToSave);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void openImage() {
        try {
            File path = new File("E:\\universityproject\\userfiles");
            JFileChooser fileChooser = new JFileChooser(path);
            int userSelection = fileChooser.showOpenDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToOpen = fileChooser.getSelectedFile();
                Image image = ImageIO.read(fileToOpen);
                Graphics g = drawingArea.getGraphics();
                g.drawImage(image, 0, 0, null);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WhiteBoardApp::new);
    }
}
