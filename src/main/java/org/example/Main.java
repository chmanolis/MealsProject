package org.example;


import controllers.MealController;
import gui.MainFrame;
import models.Meal;
import service.AppDatabase;
import service.FetchMealFromApi;
import utils.Constants;
import java.security.Provider;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
       AppDatabase apdb= new AppDatabase();
       //update areas and categories in DB
       apdb.updateAreas();
       apdb.updateCategories();
       //start the app
       new MainFrame().setVisible(true);
    }
}