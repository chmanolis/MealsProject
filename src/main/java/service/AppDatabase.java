
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
    private static boolean checkIfAreaExistInDB(String str) {
        if (str.equals(Constants.checkAreaIfExistQ + str)) {
            return true;
        } else {
            return false;
        }
    }

    public void updateAreas() {
        int i = 0;
        for (String category : fAreas.getAreasAPI()) {
            if (!checkIfAreaExistInDB(category)) {

                try {
                    FetchMealFromApi fAreas = new FetchMealFromApi();
                    Connection connection = connect();
                    String insertSQL = "Insert into MEALS.AREA values(?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);

                    //preparedStatement.setInt(1,i);
                    preparedStatement.setString(1, "dummyArea");

                }
            }

            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println(count + " record updated");
            } else {
                System.out.println("Something went wrong. Check the exception");
            }
            preparedStatement.close();
            connection.close();
            System.out.println("Done!");
        } catch(SQLException throwables){
            System.out.println(throwables.getLocalizedMessage());
        }
    }

}
