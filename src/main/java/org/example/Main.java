package org.example;


import service.LoadData;

import java.sql.*;
public class Main {
    public static void main(String[] args) {
//        createTableAndData();
//        selectAll();
//        insertNewUser(2,"Christina","c1234");
//        selectLogin("Christina","c1234");
//        new Form1();
       LoadData ld = new LoadData();
       ld.loadCategories();








    }

    static String selectLogin(String username, String password){
        try{
            Connection connection = connect();
            String selectSQL = "Select ID from D_USER where USERNAME=? and PASSWORD=?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            String message;
            if (rs.next()) {
                System.out.println("Success! UID:"+rs.getInt(1));
                message = "Success! UID:"+rs.getInt(1);
            }else{
                System.out.println("Wrong username and/or password");
                message = "Wrong username and/or password";
            }
            preparedStatement.close();
            connection.close();
            System.out.println("Done!");
            return message;
        } catch (SQLException throwables) {
            System.out.println(throwables.getLocalizedMessage());
        }
        return "";
    }
    private static void insertNewUser(int id,String username, String password){
        try{
            Connection connection = connect();
            String insertSQL = "Insert into D_USER values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            int count = preparedStatement.executeUpdate();
            if (count>0) {
                System.out.println(count+" record updated");
            }else{
                System.out.println("Something went wrong. Check the exception");
            }
            preparedStatement.close();
            connection.close();
            System.out.println("Done!");
        } catch (SQLException throwables) {
            System.out.println(throwables.getLocalizedMessage());
        }
    }
    private static void selectAll(){
        try{
            Connection connection = connect();
            Statement statement = connection.createStatement();
            String selectSQL = "Select * from D_USER";
            ResultSet rs = statement.executeQuery(selectSQL);
            while (rs.next()) {
                System.out.println(rs.getInt("ID")+","+rs.getString("USERNAME")+","+rs.getString("PASSWORD"));
            }
            statement.close();
            connection.close();
            System.out.println("Done!");
        } catch (SQLException throwables) {
            System.out.println(throwables.getLocalizedMessage());
        }
    }
    private static void createTableAndData(){
        try{
            Connection connection = connect();
            Statement statement = connection.createStatement();
            String createSQL = "CREATE TABLE D_USER" +
                    "(ID INTEGER NOT NULL PRIMARY KEY," +
                    "USERNAME VARCHAR(20)," +
                    "PASSWORD VARCHAR(20))";
            statement.executeUpdate(createSQL);
            String insertSQLv1 = "INSERT INTO D_USER VALUES(1,'bob','b12345')";
            statement.executeUpdate(insertSQLv1);
            statement.close();
            connection.close();
            System.out.println("Done!");
        } catch (SQLException throwables) {
            System.out.println(throwables.getLocalizedMessage());
        }
    }
    private static Connection connect(){
        String connectionString = "jdbc:derby:derbydemo3;create=true";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}