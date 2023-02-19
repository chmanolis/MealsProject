package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form1 extends JFrame{
    private JPanel panel1;
    private JButton button1;
    private JLabel label1;

    public Form1() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 450));
        setContentPane(panel1);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = Main.selectLogin("Christina","c1234");
                label1.setText(result);
            }
        });
    }

    public static void main(String[] args) {
        new Form1();
    }
}
