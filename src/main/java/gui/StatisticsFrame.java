package gui;

import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import models.Meal;
import service.AppDatabase;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

public class StatisticsFrame extends JFrame {

    private JTable statsTable;
    private JButton pdfBtn;
    private JButton exitBtn;
    private JPanel jpanel1;
    private JScrollPane scrPan;


    public StatisticsFrame() {

        //tableModel.setColumnIdentifiers(colNames);
        String[] colNames = {"No", "MEAL", "VIEWS"};
        setPreferredSize(new Dimension(800, 600));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(jpanel1);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        AppDatabase appdb = new AppDatabase();
        DefaultTableModel tableModel = new DefaultTableModel(colNames,0);



        int i = 0;

        //fill table with useful details of meal objects
        for (Meal meal : appdb.generateStats()) {
            i++;
            Object[] mealOb = new Object[3];
            mealOb[0] = i;
            mealOb[1] = meal.getMealName();
            mealOb[2] = meal.getMealViews();
            tableModel.addRow(mealOb);

        }



        statsTable.setModel(tableModel);
        pdfBtn.setBackground(new java.awt.Color(0, 204, 204));
        exitBtn.setBackground(new java.awt.Color(0, 204, 204));


        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame mfm = new MainFrame();
                mfm.setVisible(true);
                dispose();
            }
        });
        pdfBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               print();
            }
        });

    }
    public static void main(String[] args) {
        new StatisticsFrame();
    }
    private void print() {
        com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4.rotate());
        try {
            PdfWriter writer =
                    PdfWriter.getInstance(document, new FileOutputStream("MealStats.pdf"));

            document.open();
            PdfContentByte cb = writer.getDirectContent();

            // Create the graphics as shapes
            cb.saveState();

            Graphics2D g2 = cb.createGraphicsShapes(800, 600);
            // Print the table to the graphics
            Shape oldClip = g2.getClip();
            g2.clipRect(0, 0, 800, 600);
            scrPan.print(g2);
            g2.setClip(oldClip);
            g2.dispose();
            cb.restoreState();
            document.newPage();

            // Create the graphics with pdf fonts
            /*
            cb.saveState();
            g2 = cb.createGraphics(500, 500);
*/
            // Print the table to the graphics
            /*
            oldClip = g2.getClip();
            g2.clipRect(0, 0, 500, 500);
            scrPan.print(g2);
            g2.setClip(oldClip);

            g2.dispose();
            cb.restoreState();*/

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        document.close();
    }


}
