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
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class WikipediaCloneGUI extends JFrame {
    private JTextField searchField;
    private JTextArea contentArea;

    public WikipediaCloneGUI() {
        setTitle("Wikipedia Clone");
        setSize(200,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        searchField = new JTextField();
        JButton searchButton = new JButton("Search");
        contentArea = new JTextArea();
        contentArea.setEditable(false);

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BorderLayout());
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);

        add(searchPanel, BorderLayout.NORTH);
        add(new JScrollPane(contentArea), BorderLayout.CENTER);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = searchField.getText().trim();
                if (!query.isEmpty()) {
                    searchWikipedia(query);
                }
            }
        });
    }

    private void searchWikipedia(String query) {
        try {
            // Make a request to Wikipedia API
            String url = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&exintro&explaintext&titles=" + URLEncoder.encode(query, "UTF-8");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse JSON response
            String content = parseWikiResponse(response.toString());

            // Display content in text area
            contentArea.setText(content);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error fetching Wikipedia article: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String parseWikiResponse(String jsonResponse) {
        // Parse JSON response and extract article content
        // This is a simplified version, you may need to parse JSON properly
        // and handle different cases
        // For simplicity, assuming the article content is in "extract" field
        String content = jsonResponse.substring(jsonResponse.indexOf("\"extract\":\"") + "\"extract\":\"".length());
        content = content.substring(0, content.indexOf("\""));
        return content;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WikipediaCloneGUI gui = new WikipediaCloneGUI();
                gui.setVisible(true);
            }
        });
    }
}
