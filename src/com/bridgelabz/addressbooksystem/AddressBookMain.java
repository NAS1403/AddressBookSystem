package com.bridgelabz.addressbooksystem;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Contacts contact = new Contacts();
        contact.setFirstName("Abhishek");
        System.out.println(contact.getFirstName());
    }
}
