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

    void editContact(){
        System.out.println("Enter the first name of person to edit");
        String firstName = scr.next();
        if(firstName.equals(contact.getFirstName())){
            System.out.println("Edit the details of person");
            System.out.println("Enter first name");
            contact.setFirstName(scr.next());

            System.out.println("Enter last Name");
            contact.setLastName(scr.next());

            System.out.println("Enter Email");
            contact.setEmail(scr.next());

            System.out.print("Enter address:  ");
            scr.nextLine();
            contact.setAddress(scr.nextLine());

            System.out.println("Enter phone number");
            contact.setPhoneNumber(scr.nextLong());

            System.out.println("Enter state");
            contact.setState(scr.next());

            System.out.println("Enter city");
            contact.setCity(scr.next());

            System.out.println("Enter zip");
            contact.setZip(scr.nextInt());

        }
        else
        {
            System.out.println("Person not found");
        }

    }

    Contacts display(){
        return contact;
    }
}



