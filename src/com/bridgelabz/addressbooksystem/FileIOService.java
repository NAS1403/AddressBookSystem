package com.bridgelabz.addressbooksystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIOService {

    private final String FILE_PATH = "C:\\Users\\abhis\\IdeaProjects\\AddressBookSystem\\src\\com\\bridgelabz\\addressbooksystem\\contacts.txt";

    public boolean writeData() throws IOException {
        int i=0;
        StringBuffer buffer = new StringBuffer();
        for (AddressBook addressBook : AddressBookMain.map.values()) {
            String addressBookName = AddressBookMain.addressBooks.get(i++);
            buffer.append(addressBookName);
          addressBook.list.forEach(empData -> {
                String empDataString = empData.toString().concat("\n");
                buffer.append(empDataString);
            });
        }

        Path path = Files.write(Paths.get(FILE_PATH),buffer.toString().getBytes());
        return path != null ? true : false;
    }


    public void readData() throws IOException {
        Files.lines(new File(FILE_PATH).toPath()).forEach(System.out::println);
    }

}
