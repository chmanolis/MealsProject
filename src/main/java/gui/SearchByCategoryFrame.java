package gui;

import controllers.MealController;
import service.FetchMealFromApi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchByCategoryFrame extends  JFrame{
    private JPanel jpanel1;
    private JComboBox comboBox1;
    private JButton okBtn;
    private JList list1;
    private JButton exitBtn;

    public SearchByCategoryFrame() {

        FetchMealFromApi fmc= new FetchMealFromApi();
        MealController mc=new MealController();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        setContentPane(jpanel1);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);




        okBtn.setBackground(new java.awt.Color(0,204,204));

        exitBtn.setBackground(new java.awt.Color(0,204,204));
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame mfm = new MainFrame();
                mfm.setVisible(true);
                dispose();
            }
        });}
        public static void main(String[] args) {
            new SearchByCategoryFrame();
        }


    }
