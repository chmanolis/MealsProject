package gui;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.jdi.Value;
import models.Meal;
import service.AppDatabase;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class StatisticsFrame extends JFrame {

    private JTable statsTable;
    private JButton pdfBtn;
    private JButton exitBtn;
    private JPanel jpanel1;
    private JScrollPane scrPan;


    public StatisticsFrame() {

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
                    PdfWriter.getInstance(document, new FileOutputStream("MealStats"+java.time.LocalDate.now()+".pdf"));

            document.open();
            AppDatabase appdb= new AppDatabase();
            PdfContentByte cb = writer.getDirectContent();
            int i = 0;
            PdfPTable table = new PdfPTable(3);

            //fill pdf table with useful details of meal objects

            table.addCell("No");
            table.addCell("Name");
            table.addCell("Views");
            for (Meal meal : appdb.generateStats()) {
                i++;
                table.addCell(String.valueOf(i));
                table.addCell(meal.getMealName());
                table.addCell(String.valueOf(meal.getMealViews()));

            }
            document.add(table);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        document.close();
    }


}
