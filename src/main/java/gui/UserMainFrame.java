package gui;

import org.example.MainScreen;

import javax.swing.*;

public class UserMainFrame extends JFrame{
    private JButton seacrhButton;
    private JTextField textField1;
    private JLabel label1;
    private JPanel labelSearch;

    public static void main(String[] args) {
        new MainScreen();
        // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMainFrame().setVisible(true);

            }
        });

    }
}
