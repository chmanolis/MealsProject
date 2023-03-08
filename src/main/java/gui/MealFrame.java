package gui;

import controllers.MealController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MealFrame extends JFrame {
    private JButton exitBtn;
    private JButton saveBtn;
    private JTextField searchField;
    private JButton searchBtn;
    private JTextArea instrArea;
    private JLabel areaLb;
    private JLabel category;
    private JPanel panel1;


    public MealFrame(String mealName) {
        MealController mc = new MealController();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        setContentPane(panel1);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

        instrArea.setLineWrap(true);
        instrArea.setWrapStyleWord(true);


        mc.searchForMeal(mealName);
        searchField.setText(mc.getMealDetails().getMealName());
        category.setText("ΚΑΤΗΓΟΡΙΑ : " + mc.getMealDetails().getCategory());
        areaLb.setText("ΠΡΟΕΛΕΥΣΗ : " + mc.getMealDetails().getArea());
        instrArea.setText(mc.getMealDetails().getInstructions());
        instrArea.add(new JScrollPane());


        exitBtn.setBackground(new java.awt.Color(0, 204, 204));
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame mfm = new MainFrame();
                mfm.setVisible(true);
                dispose();
            }
        });
        searchBtn.setBackground(new java.awt.Color(0, 204, 204));

        searchBtn.setText("ΑΝΖΗΤΗΣΗ");
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mc.searchForMeal(searchField.getText());
                category.setText("ΚΑΤΗΓΟΡΙΑ : " + mc.getMealDetails().getCategory());
                areaLb.setText("ΠΡΟΕΛΕΥΣΗ : " + mc.getMealDetails().getArea());
                instrArea.setText(mc.getMealDetails().getInstructions());
            }
        });
        saveBtn.setBackground(new java.awt.Color(0, 204, 204));

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mc.setMealInstructions(instrArea.getText());
            }
        });

    }

    public static void main(String[] args) {
        new MealFrame("random");
    }


}

