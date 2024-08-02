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
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpreadsheetApp extends JFrame {
    
    private JTable table;
    private JTextField formulaField;
    
    public SpreadsheetApp() {
        setTitle("Simple Spreadsheet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        
        table = new JTable(new SpreadsheetTableModel());
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        formulaField = new JTextField();
        JButton evaluateButton = new JButton("Evaluate");
        evaluateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateFormula();
            }
        });
        
        JPanel formulaPanel = new JPanel();
        formulaPanel.setLayout(new BorderLayout());
        formulaPanel.add(new JLabel("Enter formula:"), BorderLayout.WEST);
        formulaPanel.add(formulaField, BorderLayout.CENTER);
        formulaPanel.add(evaluateButton, BorderLayout.EAST);
        getContentPane().add(formulaPanel, BorderLayout.SOUTH);
    }
    
    private void evaluateFormula() {
        String formula = formulaField.getText();
        // Implement your formula evaluation logic here
        // For simplicity, we'll just display the formula result in a message dialog
        JOptionPane.showMessageDialog(this, "Result: " + formula);
    }
    
    class SpreadsheetTableModel extends AbstractTableModel {
        private final int rows = 10;
        private final int cols = 5;
        private final Object[][] data = new Object[rows][cols];
        
        @Override
        public int getRowCount() {
            return rows;
        }
        
        @Override
        public int getColumnCount() {
            return cols;
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }
        
        @Override
        public void setValueAt(Object value, int rowIndex, int columnIndex) {
            data[rowIndex][columnIndex] = value;
        }
        
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SpreadsheetApp().setVisible(true);
            }
        });
    }
}

