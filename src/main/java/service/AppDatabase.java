
package service;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.Meal;
import org.example.Main;
import utils.Constants;

public class AppDatabase {
    private static Connection connect() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Constants.connectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }


    //check if a country already exists
    public static boolean checkIfExistInDB(String str,String value) {
        Boolean bl =false;
        try{
            Connection connection = connect();
            String selectSQL = value;
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, str);
            ResultSet rs = preparedStatement.executeQuery();
            //String message;
            bl= rs.next();
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            System.out.println(throwables.getLocalizedMessage());

    }
        return bl;
    }

    public void updateAreas() {
        FetchMealFromApi fAreas = new FetchMealFromApi();
        int i = 0;
        for (String area : fAreas.getAreasAPI()) {
            if (!checkIfExistInDB(area,Constants.checkAreaIfExistQ)) {
                try {
                    Connection connection = connect();
                    String insertSQL = Constants.insertIntoAreas;
                    PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
                    preparedStatement.setInt(1,i);
                    preparedStatement.setString(2, area);
                    int count = preparedStatement.executeUpdate();
                    if (count > 0) {
                        System.out.println(count + " record updated");
                    } else {
                        System.out.println("Something went wrong. Check the exception");
                    }
                    preparedStatement.close();
                    connection.close();
                    System.out.println("Done!");
                    i++;
                } catch(SQLException throwables){
                    System.out.println(throwables.getLocalizedMessage());
                }
                }
            }


    }
    public void updateCategories(){
        FetchMealFromApi fCategories = new FetchMealFromApi();
        int i = 0;
        for (String category : fCategories.getCategoriesAPI()) {
            if (!checkIfExistInDB(category,Constants.checkCategoryifExistQ)) {
                try {
                    Connection connection = connect();
                    String insertSQL = Constants.insertIntoCategories;
                    PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
                    preparedStatement.setInt(1,i);
                    preparedStatement.setString(2, category);
                    int count = preparedStatement.executeUpdate();
                    if (count > 0) {
                        System.out.println(count + " record updated");
                    } else {
                        System.out.println("Something went wrong. Check the exception");
                    }
                    preparedStatement.close();
                    connection.close();
                    System.out.println("Done!");
                    i++;
                } catch(SQLException throwables){
                    System.out.println(throwables.getLocalizedMessage());
                }
            }
        }


    }
    }


