package com.bridgelabz.addressbooksystem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class AddressBookMain {
    static Scanner scr = new Scanner(System.in);
    static AddressBook addressBook;
    static HashMap<String, AddressBook> map = new HashMap<>();
    public static ArrayList<String> addressBooks = new ArrayList<>();
    static String currentAddressBook;
    static String addressBookName;

    public static void main(String[] args) throws SQLException {

        System.out.println("Welcome to Address Book Program");

        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    \nEnter options:
                    1) To add contact
                    2) To edit Contact
                    3) To view Contacts by city or state across all addressBooks
                    4) To delete contact
                    5) To add address book or select addressBook
                    6) To view contact in current addressBook
                    7) To write addressBook to Files
                    8) To Read addressBook from files
                    9) TO update database contacts                  
                    10) To exit""");

            int option = scr.nextInt();
            switch (option) {
                case 1:
                    try {
                        map.get(currentAddressBook).addContact();
                    } catch (Exception e) {
                        System.out.println("\nNo AddressBook Found\n");
                    }
                    break;
                case 2:
                    try {
                        map.get(currentAddressBook).editContact();
                    } catch (Exception e) {
                        System.out.println("\nNo AddressBook Found\n");
                    }
                    break;
                case 3:
                    try {
                        addressBook.viewContacts();
                    } catch (Exception e) {
                        System.out.println("\nNo AddressBook Found\n");
                    }
                    break;
                case 4:
                    try {
                        map.get(currentAddressBook).deleteContact();
                    } catch (Exception e) {
                        System.out.println("\nNo AddressBook Found\n");
                    }
                    break;
                case 5:
                    chooseAddressBook();
                    break;
                case 6:
                    try {
                        map.get(currentAddressBook).displayContact();
                    } catch (Exception e) {
                        System.out.println("\nNo AddressBook Found\n");
                    }
                    break;
                case 7:
                    try {
                        map.get(currentAddressBook).writeAddressBook(map.get(currentAddressBook).list, currentAddressBook);
                    } catch (IOException e) {
                        System.out.println("Catch BLock");
                    }
                    break;
                case 8:
                    try {
                        AddressBook.readAddressBook();
                    } catch (IOException | SQLException e) {
                        System.out.println("Catch BLock");
                    }
                    break;
                case 9:
                    try {
                        DatabaseOperations.updateData();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 10:
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }

    static void chooseAddressBook() {
        System.out.println("""
                Press 1 to add AddressBook
                Press 2 to select AddressBook""");

        int option = scr.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter address book name");
                addressBookName = scr.next().toLowerCase();
                if (map.containsKey(addressBookName)) {
                    System.out.println("\nAddress book already exist\n");
                    chooseAddressBook();
                } else {
                    addressBook = new AddressBook();
                    map.put(addressBookName, addressBook);
                    currentAddressBook = addressBookName;
                }
                addressBooks.add(addressBookName);
                break;
            case 2:
                System.out.println("Enter address book name");
                addressBookName = scr.next().toLowerCase();
                if (!map.containsKey(addressBookName)) {
                    System.out.println("\nAddressBook not Found\n");
                    chooseAddressBook();
                } else
                    currentAddressBook = addressBookName;
                break;
            default:
                break;
        }
    }
}



