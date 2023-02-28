package gui;

import controllers.MealController;
import org.example.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MealFrame extends JFrame{
    private JButton exitBtn;
    private JButton saveBtn;
    private JTextField searchField;
    private JButton searchBtn;
    private JTextArea instrArea;
    private JLabel areaLb;
    private JLabel category;
    private JPanel panel1;


    public MealFrame() {
        MealController mc=new MealController();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        setContentPane(panel1);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);



        exitBtn.setBackground(new java.awt.Color(0,204,204));

        exitBtn.setMaximumSize(new java.awt.Dimension(350, 50));
        exitBtn.setMinimumSize(new java.awt.Dimension(350, 50));
        exitBtn.setPreferredSize(new java.awt.Dimension(350, 50));
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame mfm = new MainFrame();
                mfm.setVisible(true);
                dispose();
            }
        });
        searchBtn.setBackground(new java.awt.Color(0,204,204));
        searchBtn.setMaximumSize(new java.awt.Dimension(350, 50));
        searchBtn.setMinimumSize(new java.awt.Dimension(350, 50));
        searchBtn.setPreferredSize(new java.awt.Dimension(350, 50));
        searchBtn.setText("ΑΝΖΗΤΗΣΗ");
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mc.searchForMeal(searchField.getText());
                category.setText("ΚΑΤΗΓΟΡΙΑ : "+mc.getMealDetails().getCategory());
                areaLb.setText("ΠΡΟΕΛΕΥΣΗ : " +mc.getMealDetails().getArea());
                instrArea.setLineWrap(true);
                instrArea.setText(mc.getMealDetails().getInstructions());
            }
        });
        saveBtn.setBackground(new java.awt.Color(0,204,204));
        saveBtn.setMaximumSize(new java.awt.Dimension(350, 50));
        saveBtn.setMinimumSize(new java.awt.Dimension(350, 50));
        saveBtn.setPreferredSize(new java.awt.Dimension(350, 50));
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             mc.setMealInstructions(instrArea.getText());


            }
        });
    }

        public static void main(String[] args) {
            new MealFrame();
        }


}

