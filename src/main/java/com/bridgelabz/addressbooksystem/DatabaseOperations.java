package com.bridgelabz.addressbooksystem;

import java.sql.*;
import java.util.Scanner;

public class DatabaseOperations {
    static Connection connection;
    static Scanner scanner = new Scanner(System.in);
    static DBConnector dbConnector = new DBConnector();

    static void displayContacts() throws SQLException {
        String sql = "select * from AddressBookTable";

        PreparedStatement preparedStatement = dataBase(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " +
                    resultSet.getString(2) + " " +
                    resultSet.getString(3) + " " +
                    resultSet.getString(4) + " " +
                    resultSet.getString(5) + " " +
                    resultSet.getString(6) + " " +
                    resultSet.getString(7) + " " +
                    resultSet.getString(8) + " " +
                    resultSet.getString(9) + " " +
                    resultSet.getString(10) + " " +
                    resultSet.getString(11) + " " +
                    resultSet.getDate(12));
        }
        connection.close();
    }

    static void updateData() throws SQLException {
        System.out.println("Enter the first name of contact to edit");
        String firstName = scanner.next();
        String sql = "update AddressBookTable set firstName=?, lastName=?, address=?, city=?, state=?, zip=?, phone_number=?, email=? where firstName=?";
        PreparedStatement preparedStatement = dataBase(sql);
        System.out.println("Enter first name of contact");
        preparedStatement.setString(1, scanner.next());
        System.out.println("Enter Second name of contact");
        preparedStatement.setString(2, scanner.next());
        System.out.println("Enter Address");
        preparedStatement.setString(3, scanner.next());
        System.out.println("enter city ");
        preparedStatement.setString(4, scanner.next());
        System.out.println("Enter state");
        preparedStatement.setString(5, scanner.next());
        System.out.println("Enter zip");
        preparedStatement.setString(6, scanner.next());
        System.out.println("Enter phone number");
        preparedStatement.setString(7, scanner.next());
        System.out.println("Enter email of contact");
        preparedStatement.setString(8, scanner.next());
        preparedStatement.setString(9, firstName);

        int update = preparedStatement.executeUpdate();
        if (update > 0) {
            System.out.println("\nUpdate Successful\n");
        } else {
            System.out.println("\nNo update done\n");
        }
        connection.close();

    }

    static void addContactToDatabase(Contacts contact) throws SQLException {
        String sql = "insert into AddressBookTable(firstName, lastName, address, city, state, zip, phone_number, email,addressBook_name)values(?,?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = dataBase(sql);
        preparedStatement.setString(1, contact.getFirstName());
        preparedStatement.setString(2, contact.getLastName());
        preparedStatement.setString(4, contact.getCity());
        preparedStatement.setString(5, contact.getState());
        preparedStatement.setString(3, contact.getAddress());
        preparedStatement.setString(6, contact.getZip());
        preparedStatement.setString(7, contact.getPhoneNumber());
        preparedStatement.setString(8, contact.getEmail());
        preparedStatement.setString(9, AddressBookMain.currentAddressBook);
        boolean query = preparedStatement.execute();
        if (!query) {
            System.out.println("\nContact added to dataBase");
        } else {
            System.out.println("Error in adding contact to data base");
        }
        connection.close();
    }

    static void retrieveDataByDates() throws SQLException {
        String sql = "select * from AddressBookTable where date_added between ? and ?";
        PreparedStatement preparedStatement = dataBase(sql);
        preparedStatement.setDate(1, java.sql.Date.valueOf("2022-08-11"));
        preparedStatement.setDate(2, java.sql.Date.valueOf("2022-08-14"));
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " +
                    resultSet.getString(2) + " " +
                    resultSet.getString(3) + " " +
                    resultSet.getString(4) + " " +
                    resultSet.getString(5) + " " +
                    resultSet.getString(6) + " " +
                    resultSet.getString(7) + " " +
                    resultSet.getString(8) + " " +
                    resultSet.getString(9) + " " +
                    resultSet.getString(10) + " " +
                    resultSet.getString(11) + " " +
                    resultSet.getDate(12));
        }
        connection.close();
    }

    static PreparedStatement dataBase(String sql) throws SQLException {
        connection = dbConnector.getConnection();
        return connection.prepareStatement(sql);
    }

}
