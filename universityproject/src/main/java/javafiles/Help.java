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

public class Help extends JFrame {

    public Help() {
        initComponents();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Help - DevLink");

        JPanel mainPanel = new JPanel();
        GroupLayout layout = new GroupLayout(mainPanel);
        mainPanel.setLayout(layout);

        JLabel titleLabel = new JLabel("Welcome to DevLink Help");
        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 18));

        JTextArea helpTextArea = new JTextArea();
        helpTextArea.setEditable(false);
        helpTextArea.setColumns(40);
        helpTextArea.setLineWrap(true);
        helpTextArea.setRows(20);
        helpTextArea.setText(
                "Welcome to DevLink Help!\n\n" +
                "DevLink is a software built for developers, providing various tools and applications for development purposes.\n\n" +
                "1. Login/SignUp:\n" +
                "   - If you're a new user, click on 'New User? Click here' to create an account.\n" +
                "   - If you're an existing user, click on 'Already a User? Click here' to log in.\n\n" +
                "2. Profile:\n" +
                "   - Check your profile information by clicking on the 'Profile' option.\n\n" +
                "3. Help:\n" +
                "   - You are currently in the Help section. Find information about the various features and tools available in DevLink here.\n\n" +
                "4. Application Section:\n" +
                "   - Notepad/Textpad\n" +
                "   - Spreadsheet\n" +
                "   - Presentation app\n" +
                "   - Drawing app\n" +
                "   - Todo list\n" +
                "   - Sticky note apps\n\n" +
                "5. Tools:\n" +
                "   - Share\n" +
                "   - Email\n" +
                "   - GitHub\n" +
                "   - File converter\n" +
                "   - Calendar\n" +
                "   - Calculator\n\n" +
                "6. Other Options:\n" +
                "   - Your projects\n" +
                "   - Time app\n" +
                "   - Reminder\n" +
                "   - Video meet\n" +
                "   - Whiteboard\n" +
                "   - Screenshot\n" +
                "   - Task manager\n" +
                "   - Terminal calculator\n" +
                "   - IP tool\n" +
                "   - Reverse engineering tool\n" +
                "   - My AI\n\n" +
                "7. Workspace:\n" +
                "   - Utilize the spacious workspace to manage your projects efficiently.\n\n" +
                "8. Embedded Browser:\n" +
                "   - Access web content directly within DevLink.\n\n" +
                "For any further assistance, feel free to reach out to us at jaihodigital.onrender.com/\n\n" +
                "Developed by JaihoDigital"
        );

        JScrollPane scrollPane = new JScrollPane(helpTextArea);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(titleLabel)
                                .addContainerGap(250, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(titleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(mainPanel);
        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Help().setVisible(true);
        });
    }
}
