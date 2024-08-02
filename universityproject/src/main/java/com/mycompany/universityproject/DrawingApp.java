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
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DrawingApp extends JFrame {
    private enum Tool {PENCIL, ERASER, FILL, RECTANGLE, CIRCLE, LINE}
    private BufferedImage canvasImage;
    private Graphics2D graphics2D;
    private int prevX, prevY;
    private Color drawColor;
    private Tool currentTool;
    private int brushSize;

    public DrawingApp() {
        setTitle("Draw simple");
        setSize(800, 600);

        drawColor = Color.BLACK;
        currentTool = Tool.PENCIL;
        brushSize = 5;

        // Initialize canvas
        canvasImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        graphics2D = canvasImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        clearCanvas();

        // Create drawing area
        JPanel drawingArea = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(canvasImage, 0, 0, null);
            }
        };
        drawingArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                prevX = e.getX();
                prevY = e.getY();
                if (currentTool == Tool.FILL) {
                    fillArea(prevX, prevY);
                    drawingArea.repaint();
                }
            }
        });
        drawingArea.addMouseMotionListener(new MouseMotionAdapter() {
    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (currentTool == Tool.PENCIL) {
            drawLine(prevX, prevY, x, y);
        } else if (currentTool == Tool.ERASER) {
            erase(prevX, prevY, brushSize);
        } else if (currentTool == Tool.RECTANGLE) {
            // Add code to draw a rectangle
        } else if (currentTool == Tool.CIRCLE) {
            // Add code to draw a circle
        } else if (currentTool == Tool.LINE) {
            // Add code to draw a line
        }
        prevX = x;
        prevY = y;
        drawingArea.repaint();
    }
});
        /*
        drawingArea.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if (currentTool == Tool.PENCIL) {
                    drawLine(prevX, prevY, x, y);
                } else if (currentTool == Tool.ERASER) {
                    erase(prevX, prevY, brushSize);
                }
                prevX = x;
                prevY = y;
                drawingArea.repaint();
            }
        });*/

        // Create toolbar
        JPanel toolbar = new JPanel();
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearCanvas();
                drawingArea.repaint();
            }
        });
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCanvas();
            }
        });
        JButton newButton = new JButton("New");
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearCanvas();
                drawingArea.repaint();
            }
        });
        JButton openButton = new JButton("Open");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
                drawingArea.repaint();
            }
        });
        JButton colorButton = new JButton("Color");
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawColor = JColorChooser.showDialog(null, "Choose a color", drawColor);
            }
        });

        JComboBox<Tool> toolComboBox = new JComboBox<>(Tool.values());
        toolComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTool = (Tool) toolComboBox.getSelectedItem();
            }
        });

        JSpinner brushSizeSpinner = new JSpinner(new SpinnerNumberModel(5, 1, 50, 1));
        brushSizeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                brushSize = (int) brushSizeSpinner.getValue();
            }
        });

        toolbar.add(clearButton);
        toolbar.add(saveButton);
        toolbar.add(newButton);
        toolbar.add(openButton);
        toolbar.add(colorButton);
        toolbar.add(toolComboBox);
        toolbar.add(new JLabel("Brush Size:"));
        toolbar.add(brushSizeSpinner);

        // Add components to frame
        setLayout(new BorderLayout());
        add(toolbar, BorderLayout.NORTH);
        add(drawingArea, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    private void clearCanvas() {
        graphics2D.setPaint(Color.WHITE);
        graphics2D.fillRect(0, 0, getWidth(), getHeight());
        graphics2D.setPaint(drawColor);
    }

    private void drawLine(int x1, int y1, int x2, int y2) {
        graphics2D.setColor(drawColor);
        graphics2D.setStroke(new BasicStroke(brushSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        graphics2D.drawLine(x1, y1, x2, y2);
    }

    private void erase(int x, int y, int size) {
        graphics2D.setComposite(AlphaComposite.Clear);
        graphics2D.fillRect(x - size / 2, y - size / 2, size, size);
        graphics2D.setComposite(AlphaComposite.SrcOver);
    }

    private void fillArea(int x, int y) {
        Color targetColor = new Color(canvasImage.getRGB(x, y));
        fillAreaRecursive(x, y, targetColor);
    }

    private void fillAreaRecursive(int x, int y, Color targetColor) {
        if (x < 0 || x >= canvasImage.getWidth() || y < 0 || y >= canvasImage.getHeight())
            return;
        if (!new Color(canvasImage.getRGB(x, y)).equals(targetColor))
            return;
        canvasImage.setRGB(x, y, drawColor.getRGB());
        fillAreaRecursive(x + 1, y, targetColor);
        fillAreaRecursive(x - 1, y, targetColor);
        fillAreaRecursive(x, y + 1, targetColor);
        fillAreaRecursive(x, y - 1, targetColor);
    }

    private void saveCanvas() {
        try {
            File path = new File("E:\\universityproject\\userfiles");
            JFileChooser fileChooser = new JFileChooser(path);
            fileChooser.setDialogTitle("Save As");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG files", "png");
            fileChooser.setFileFilter(filter);
            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                ImageIO.write(canvasImage, "png", fileToSave);
                JOptionPane.showMessageDialog(this, "Image saved successfully!");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openFile() {
        try {
            File path = new File("E:\\universityproject\\userfiles");
            JFileChooser fileChooser = new JFileChooser(path);
            fileChooser.setDialogTitle("Open");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG files", "png");
            fileChooser.setFileFilter(filter);
            int userSelection = fileChooser.showOpenDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToOpen = fileChooser.getSelectedFile();
                canvasImage = ImageIO.read(fileToOpen);
                graphics2D = canvasImage.createGraphics();
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                repaint();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error opening image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DrawingApp();
            }
        });
    }
}

