package com.bridgelabz;

import java.sql.*;


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

    public void getAllContacts() {
        String query = "SELECT * FROM contacts";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("First Name: " + resultSet.getString("first_name"));
                System.out.println("Last Name: " + resultSet.getString("last_name"));
                System.out.println("Address: " + resultSet.getString("address"));
                System.out.println("City: " + resultSet.getString("city"));
                System.out.println("State: " + resultSet.getString("state"));
                System.out.println("ZIP: " + resultSet.getString("zip"));
                System.out.println("Phone: " + resultSet.getString("phone_number"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void updateContact(int id, String phoneNumber, String email) {
        String query = "UPDATE contacts SET phone_number = ?, email = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, phoneNumber);
            statement.setString(2, email);
            statement.setInt(3, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Contact updated successfully.");
            } else {
                System.out.println("Contact not found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

