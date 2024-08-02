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
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javafiles.JFontChooser;

public class StickyNotesApp extends JFrame {

    private ArrayList<JTextArea> notesList;

    public StickyNotesApp() {
        
        notesList = new ArrayList<>();

        setTitle("Sticky Notes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(inchesToPixels(2.5), inchesToPixels(2.5)));
        setLayout(new GridLayout(0, 1));

        createMenu();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem newNoteItem = new JMenuItem("New Note");
        newNoteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewNote();
            }
        });
        fileMenu.add(newNoteItem);

        JMenuItem saveItem = new JMenuItem("Save Notes");
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveNotesToFile();
            }
        });
        fileMenu.add(saveItem);

        menuBar.add(fileMenu);

        JMenu optionsMenu = new JMenu("Options");
        JMenuItem changeBackgroundItem = new JMenuItem("Change Background");
        changeBackgroundItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackground();
            }
        });
        optionsMenu.add(changeBackgroundItem);
        
        JMenuItem changeFontItem = new JMenuItem("Change Font");
        changeFontItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeFont();
            }
        });
        optionsMenu.add(changeFontItem);
        
        menuBar.add(optionsMenu);

        setJMenuBar(menuBar);
    }

    private void createNewNote() {
        JTextArea noteTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(noteTextArea);
        notesList.add(noteTextArea);

        JPanel notePanel = new JPanel();
        notePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        notePanel.add(scrollPane);
        add(notePanel);

        revalidate();
        repaint();
    }

    private void changeBackground() {
        Color color = JColorChooser.showDialog(this, "Choose Background Color", Color.YELLOW);
        if (color != null) {
            for (JTextArea note : notesList) {
                note.setBackground(color);
            }
        }
    }

    private void saveNotesToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(file)) {
                for (JTextArea note : notesList) {
                    writer.write(note.getText() + "\n");
                }
                JOptionPane.showMessageDialog(this, "Notes saved successfully!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving notes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void changeFont() {
        Font selectedFont = JFontChooser.showDialog(this, "Choose Font", notesList.get(0).getFont());
    if (selectedFont != null) {
        for (JTextArea note : notesList) {
            note.setFont(selectedFont);
        }
    }
    }
    
    private int inchesToPixels(double inches) {
        return (int) (inches * Toolkit.getDefaultToolkit().getScreenResolution());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StickyNotesApp();
            }
        });
    }
}
*/
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafiles.JFontChooser;

public class StickyNotesApp extends JFrame {

    private ArrayList<JTextArea> notesList;

    public StickyNotesApp() {
        notesList = new ArrayList<>();

        setTitle("Sticky Notes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(inchesToPixels(2.5), inchesToPixels(2.5)));
        setLayout(new GridLayout(0, 1));

        createMenu();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem newNoteItem = new JMenuItem("New Note");
        newNoteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewNote();
            }
        });
        fileMenu.add(newNoteItem);

        JMenuItem saveItem = new JMenuItem("Save Notes");
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveNotesToFile();
            }
        });
        fileMenu.add(saveItem);

        menuBar.add(fileMenu);

        JMenu optionsMenu = new JMenu("Options");
        JMenuItem changeBackgroundItem = new JMenuItem("Change Background");
        changeBackgroundItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackground();
            }
        });
        optionsMenu.add(changeBackgroundItem);

        JMenuItem changeFontItem = new JMenuItem("Change Font");
        changeFontItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeFont();
            }
        });
        optionsMenu.add(changeFontItem);

        menuBar.add(optionsMenu);

        setJMenuBar(menuBar);
    }

    private void createNewNote() {
        JTextArea noteTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(noteTextArea);
        notesList.add(noteTextArea);

        JPanel notePanel = new JPanel();
        notePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        notePanel.add(scrollPane);
        add(notePanel);

        revalidate();
        repaint();
    }

    private void changeBackground() {
        Color color = JColorChooser.showDialog(this, "Choose Background Color", Color.YELLOW);
        if (color != null) {
            for (JTextArea note : notesList) {
                note.setBackground(color);
            }
        }
    }

    private void saveNotesToFile() {
        String directoryPath = "E:\\universityproject\\userfiles"; // Specify the desired directory path

        JFileChooser fileChooser = new JFileChooser(directoryPath);
        FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(txtFilter);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (!file.getName().endsWith(".txt")) {
                file = new File(file.getAbsolutePath() + ".txt");
            }
            try {
                FileWriter writer = new FileWriter(file);
                for (JTextArea note : notesList) {
                    writer.write(note.getText() + "\n");
                }
                writer.close();
                JOptionPane.showMessageDialog(this, "Notes saved successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving notes: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void changeFont() {
        Font selectedFont = JFontChooser.showDialog(this, "Choose Font", notesList.get(0).getFont());
        if (selectedFont != null) {
            for (JTextArea note : notesList) {
                note.setFont(selectedFont);
            }
        }
    }

    private int inchesToPixels(double inches) {
        return (int) (inches * Toolkit.getDefaultToolkit().getScreenResolution());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StickyNotesApp();
            }
        });
    }
}
