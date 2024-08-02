/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roughfiles;

/**
 *
 * @author Arsh
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SimplePowerPointApp extends JFrame {

    private List<String> slides;
    private int currentSlideIndex;
    private JTextArea slideTextArea;
    private JButton prevButton;
    private JButton nextButton;

    public SimplePowerPointApp() {
        setTitle("Simple PowerPoint App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        slides = new ArrayList<>();
        currentSlideIndex = -1;

        slideTextArea = new JTextArea();
        slideTextArea.setEditable(false);
        slideTextArea.setLineWrap(true);
        slideTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(slideTextArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton addSlideButton = new JButton("Add Slide");
        addSlideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSlide();
            }
        });
        buttonPanel.add(addSlideButton);

        prevButton = new JButton("Previous");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPreviousSlide();
            }
        });
        buttonPanel.add(prevButton);

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextSlide();
            }
        });
        buttonPanel.add(nextButton);

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        updateButtons();

        showNextSlide();
    }

    private void addSlide() {
        slides.add("");
        currentSlideIndex = slides.size() - 1;
        slideTextArea.setText("");
        updateButtons();
    }

    private void showPreviousSlide() {
        if (currentSlideIndex > 0) {
            currentSlideIndex--;
            slideTextArea.setText(slides.get(currentSlideIndex));
            updateButtons();
        }
    }

    private void showNextSlide() {
        if (currentSlideIndex < slides.size() - 1) {
            currentSlideIndex++;
            slideTextArea.setText(slides.get(currentSlideIndex));
            updateButtons();
        }
    }

    private void updateButtons() {
        prevButton.setEnabled(currentSlideIndex > 0);
        nextButton.setEnabled(currentSlideIndex < slides.size() - 1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SimplePowerPointApp().setVisible(true);
        });
    }
}

