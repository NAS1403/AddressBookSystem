package com.bridgelabz.addressbooksystem;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        HashMap<String, AddressBook> map = new HashMap<>();
        Scanner scr = new Scanner(System.in);
        System.out.println("Welcome to Address Book Program");
            AddressBook add = new AddressBook();
            System.out.println("Enter address book name");
            String addressBookName = scr.next();
            map.put(addressBookName, add);
            boolean exit = true;
            do {
                System.out.println("""
                        Enter options:
                        1) To add contact
                        2) To edit Contact
                        3) To display Contacts
                        4) To delete contact
                        5) To exit""");
                int option = scr.nextInt();
                switch (option) {
                    case 1:
                        add.addContact();
                        break;
                    case 2:
                        add.editContact();
                        break;
                    case 3:
                        add.displayContacts();
                        break;
                    case 4:
                        add.deleteContact();
                        break;
                    case 5:
                        exit = false;
                    default:
                        break;
                }
            } while (exit);
            System.out.println(map);
    }
}



