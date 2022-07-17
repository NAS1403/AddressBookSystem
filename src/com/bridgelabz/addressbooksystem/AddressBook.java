package com.bridgelabz.addressbooksystem;

import java.util.Scanner;

public class AddressBook {
    Contacts contact = new Contacts();
    Scanner scr = new Scanner(System.in);

    void addContact(){

        System.out.println("Enter first name");
        contact.setFirstName(scr.next());
        System.out.println("Enter last name");
        contact.setLastName(scr.next());
        System.out.println("Enter city");
        contact.setCity(scr.next());
        System.out.println("Enter state");
        contact.setState(scr.next());
        System.out.print("Enter address:  ");
        scr.nextLine();
        contact.setAddress(scr.nextLine());
        System.out.println("Enter Zipcode");
        contact.setZip(scr.nextInt());
        System.out.println("Enter phone Number");
        contact.setPhoneNumber(scr.nextLong());
        System.out.println("Enter email address");
        contact.setEmail(scr.next());

    }

    Contacts display(){
        return contact;
    }
}



