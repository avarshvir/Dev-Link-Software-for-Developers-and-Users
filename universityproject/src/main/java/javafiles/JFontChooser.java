/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafiles;

/**
 *
 * @author Arsh
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFontChooser extends JDialog implements ActionListener {
    private JComboBox<String> fontNameComboBox;
    private JComboBox<Integer> fontSizeComboBox;
    private JButton okButton;
    private JButton cancelButton;
    private Font selectedFont;

    public JFontChooser(JFrame parent, Font defaultFont) {
        super(parent, "Font Chooser", true);
        setLayout(new BorderLayout());

        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontNameComboBox = new JComboBox<>(fontNames);
        fontNameComboBox.setSelectedItem(defaultFont.getFontName());
        add(fontNameComboBox, BorderLayout.NORTH);

        Integer[] fontSizes = {8, 10, 12, 14, 16, 18, 20, 24, 28, 32, 36, 40, 48, 56, 72};
        fontSizeComboBox = new JComboBox<>(fontSizes);
        fontSizeComboBox.setSelectedItem(defaultFont.getSize());
        add(fontSizeComboBox, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        okButton.addActionListener(this);
        cancelButton.addActionListener(this);

        pack();
        setLocationRelativeTo(parent);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            String fontName = (String) fontNameComboBox.getSelectedItem();
            int fontSize = (int) fontSizeComboBox.getSelectedItem();
            selectedFont = new Font(fontName, Font.PLAIN, fontSize);
        } else {
            selectedFont = null;
        }
        dispose();
    }

    public Font getSelectedFont() {
        return selectedFont;
    }

    public static Font showDialog(JFrame parent, String choose_Font, Font defaultFont) {
        JFontChooser dialog = new JFontChooser(parent, defaultFont);
        dialog.setVisible(true);
        return dialog.getSelectedFont();
    }
}

