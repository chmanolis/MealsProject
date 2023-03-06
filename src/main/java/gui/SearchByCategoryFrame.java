package gui;

import controllers.MealController;
import service.FetchMealFromApi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SearchByCategoryFrame extends  JFrame{
    private JPanel jpanel1;
    private JComboBox comboBox1;
    private JButton okBtn;
    private JButton exitBtn;
    private JLabel jlb2;
    private JComboBox comboBox2;
    private JButton OK2Btn;

    public SearchByCategoryFrame() {

        FetchMealFromApi fmc= new FetchMealFromApi();
        MealController mc=new MealController();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        setContentPane(jpanel1);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

        //pass values in combo box from categories API
        comboBox1.setModel(new DefaultComboBoxModel<String>(fmc.getCategoriesAPI().toArray(new String[0])));
        comboBox2.setVisible(false);
        jlb2.setVisible(false);
        OK2Btn.setVisible(false);
        OK2Btn.setBackground(new java.awt.Color(0,204,204));
        okBtn.setBackground(new java.awt.Color(0,204,204));

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox2.setModel(new DefaultComboBoxModel<String>(fmc.getMealsByCategory(comboBox1.getSelectedItem().toString()).toArray(new String[0])));
                comboBox2.setVisible(true);
                OK2Btn.setVisible(true);
                jlb2.setVisible(true);
            }
        });
        OK2Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                MealFrame mlfm = new MealFrame(Objects.requireNonNull(comboBox2.getSelectedItem()).toString());
                mlfm.setVisible(true);
                dispose();
            }
        });
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
