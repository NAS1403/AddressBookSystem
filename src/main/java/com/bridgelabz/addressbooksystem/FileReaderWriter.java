package com.bridgelabz.addressbooksystem;

import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderWriter {
    static final String PATH = "C:\\Users\\abhis\\IdeaProjects\\AddressBookSystem\\src\\main\\resources\\";

    static void readTxtFile(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String string;
        while ((string = bufferedReader.readLine()) != null)
            System.out.println(string);
    }

    static void readCSVFile(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            System.out.print(scanner.next());
        }
        scanner.close();
    }

    public static void writeTxt(ArrayList<Contacts> list, String addressBookName) throws IOException {
        File file = new File(PATH + addressBookName + ".txt");
        FileWriter fileWriter = new FileWriter(file);
        String contactDataString = "";
        for (Contacts contacts : list)
            contactDataString = contactDataString.concat(contacts.toString().concat("\n"));
        fileWriter.write(contactDataString);
        fileWriter.close();
    }

    public static void writeCSV(ArrayList<Contacts> list, String addressBookName) throws IOException {
        File file = new File(PATH + addressBookName + ".csv");
        FileWriter fileWriter = new FileWriter(file);
        CSVWriter csvWriter = new CSVWriter(fileWriter);
        List<String[]> data = new ArrayList<>();
        String[] heading = new String[]{"FIRST_NAME", "LAST_NAME", "ADDRESS", "CITY", "STATE", "ZIP", "PHONE_NUMBER", "EMAIL"};
        csvWriter.writeNext(heading);
        for (Contacts contacts : list) {
            String[] contactData = new String[]{contacts.getFirstName(), contacts.getLastName(), contacts.getAddress(), contacts.getCity(), contacts.getState(), contacts.getZip(), contacts.getPhoneNumber(), contacts.getEmail()};
            data.add(contactData);
        }
        csvWriter.writeAll(data);
        fileWriter.close();
    }
}
