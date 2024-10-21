package com.bridgelabz;

public class AddressBookApp {
        public static void main(String[] args) {
            AddressBookDAO addressBookDAO = new AddressBookDAO();

            // Add a new contact
            addressBookDAO.addContact("Nivrutti", "Wagh", "Pimpri chinchwad", "Pune", "Maharashtra", "412109", "8626045676", "nivrutti@gmail.com");

            // Fetch all contacts
            System.out.println("Contacts in Address Book:");
            addressBookDAO.getAllContacts();
            
        }
    }

