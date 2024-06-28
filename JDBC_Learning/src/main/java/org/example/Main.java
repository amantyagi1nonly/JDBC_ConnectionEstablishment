package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final String Url = "jdbc:mysql://127.0.0.1:3306/jdbc_learning";
        final String Username = "root";
        final String Password = "Aman@1306";

        String withdrawQuery = "UPDATE tranasction SET balance = balance - ? WHERE accountNumber = ?";
        String DepositQuery = "UPDATE tranasction SET balance = balance + ? WHERE accountNumber = ?";
        // Transaction Handling Using JDBC


        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Using for loading driver for jdbc
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(Url, Username, Password);  // establishing connection
            connection.setAutoCommit(false);// Making auto commit false
            try {
                PreparedStatement preparedwithdrawQuery = connection.prepareStatement(withdrawQuery);
                PreparedStatement preparedDepositQuery = connection.prepareStatement(DepositQuery);

                preparedwithdrawQuery.setDouble(1,500);
                preparedwithdrawQuery.setString(2,"12345");
                preparedwithdrawQuery.execute();

                preparedDepositQuery.setDouble(1,500);
                preparedDepositQuery.setString(2,"9876545");
                preparedDepositQuery.execute();

                connection.commit();
                System.out.println("Transaction succs !");

            } catch (SQLException e) {
                connection.rollback();
                System.out.println("Transaction Failed !");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }








































//    /*  final String QueryRetrive = "SELECT * FROM clientdetails";
//        final String QueryInsert = "INSERT INTO clientdetails(ClientName, ClientAddr) VALUES ('Uttam Tyagi', 'Shikarpur')";
//        final String QueryDelete = "DELETE FROM clientdetails WHERE ClientId = 1";
//        final String QueryuPDATE = "update clientdetails SET ClientName = 'Aman Tyagi' WHERE ClientId = 2";
//    */
//
//        final String PreparedStatementQuery = "INSERT INTO ClientPhotos(ImageData) VALUES(?)";
//        final String ImagePath = "C:\\Users\\asus\\Pictures\\Screenshots\\Screenshot (4).png";
//
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver"); // Using for loading driver for jdbc
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        // ******************** This code of block is used for saving image to database ********************
//
//        try {
//            Connection connection = DriverManager.getConnection(Url, Username, Password);  // establishing connection
//            FileInputStream fileInputStream = new FileInputStream(ImagePath);
//            byte[] imageData = new byte[fileInputStream.available()];
//            fileInputStream.read(imageData);
//            PreparedStatement preparedStatement = connection.prepareStatement(PreparedStatementQuery);
//            preparedStatement.setBytes(1,imageData);
//
//            System.out.println(preparedStatement.executeUpdate());
//
//        } catch (SQLException | IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        // ******************** This code of block is used for using Prepared Statement ********************
//
//      /*  try {
//            Connection connection = DriverManager.getConnection(Url, Username, Password);  // establishing connection
//            PreparedStatement preparedStatement = connection.prepareStatement(PreparedStatementQuery);
//
//            Scanner sc = new Scanner(System.in);
//            System.out.println("Enter your id");
//            int id = sc.nextInt();
//
//            preparedStatement.setInt(1,id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                System.out.println("ID - " + resultSet.getInt("ClientId") + ", ClientName - " + resultSet.getString("ClientName"));
//            }
//
//            resultSet.close();
//            preparedStatement.close();
//            connection.close();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } */
//
//                        // ******************** This code of block is used for using execute statement query ********************
//      /*  try {
//            Connection connection = DriverManager.getConnection(Url, Username, Password);  // establishing connection
//            Statement statement = connection.createStatement(); // took zero argument
//            int RowsAffected = statement.executeUpdate(QueryuPDATE);
//            int RowsAffected = statement.executeUpdate(QueryInsert); // Insert operation
//            ResultSet resultSet = statement.executeQuery(QueryRetrive); // told how many rows affected
//            System.out.println(RowsAffected);
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("ClientName"));
//            }
//
//            resultSet.close();
//            statement.close();
//            connection.close(); // close Connection in reverse order
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } */

    }
}