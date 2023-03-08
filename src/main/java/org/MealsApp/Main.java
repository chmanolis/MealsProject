package org.MealsApp;


import gui.MainFrame;
import service.AppDatabase;

public class Main {
    public static void main(String[] args) {
        AppDatabase apdb = new AppDatabase();
        //update areas and categories in DB
        apdb.updateAreas();
        apdb.updateCategories();
        //start the app
        new MainFrame().setVisible(true);
    }
}