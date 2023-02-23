package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {
    private JPanel panel1;
    private JButton SingUp;
    private JLabel label1;
    private JButton Login;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JLabel Username;
    private JLabel Password;

    public MainScreen() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1280, 720));
        setContentPane(panel1);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        SingUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = Main.selectLogin("Christina", "c1234");
                label1.setText(result);
            }
        });
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //textArea1.setText("Bob and Alice");

                SingUp.setVisible(false);
                Login.setVisible(false);
                passwordField1.setVisible(false);
                textField1.setVisible(false);
                Password.setVisible(false);
                Username.setVisible(false);



            }
        });
    }

    public static void main(String[] args) {
        new MainScreen();
        // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);

            }
        });

    }
}
