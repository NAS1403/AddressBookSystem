package com.bridgelabz.addressbooksystem;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressBook add = new AddressBook();
        Scanner scr = new Scanner(System.in);
        boolean exit = true;
        do {
        System.out.println("Enter options:\n1) To add contact\n2) To edit Contact\n3) To display Contacts\n4) To delete contact\n5) To exit");
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
        }while(exit);

    }
}



