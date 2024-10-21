package com.bridgelabz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressBookDAO {
    public void addContact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        String query = "INSERT INTO contacts (first_name, last_name, address, city, state, zip, phone_number, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, address);
            statement.setString(4, city);
            statement.setString(5, state);
            statement.setString(6, zip);
            statement.setString(7, phoneNumber);
            statement.setString(8, email);

            statement.executeUpdate();
            System.out.println("Contact added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

