package com.bridgelabz.addressbooksystem;


public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressBook add = new AddressBook();

      add.addContact();
        System.out.println(add.display());

    }
}



