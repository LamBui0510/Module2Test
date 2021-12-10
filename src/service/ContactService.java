package service;

import model.Contact;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactService implements IContact<Contact> {
    Scanner sc = new Scanner(System.in);
    public String PATH = "C:\\Users\\Admin\\IdeaProjects\\module2test\\src\\contact.csv";
    List<Contact> contactList = new ArrayList<>();
    public void readFile() {
        try {
            FileReader fileReader = new FileReader(PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                String[] contactsLine = line.split(",");
                String phoneNum = contactsLine[0];
                String group = contactsLine[1];
                String name = contactsLine[2];
                String gender = contactsLine[3];
                String address = contactsLine[4];
                String birth = contactsLine[5];
                String email = contactsLine[6];
                Contact contactNew = new Contact(phoneNum,group,name,gender,address, birth, email);
                save(contactNew);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter(PATH);
            for (Contact contacts:contactList) {
                fileWriter.write(contacts.toString());
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contact> findAll() {
        return contactList;
    }

    @Override
    public void save(Contact contact) {
        contactList.add(contact);
    }

    @Override
    public void delete(int index) {
        contactList.remove(index);
    }

    @Override
    public void edit(int index, Contact contact) {
        contactList.set(index, contact);
    }

    public int findIndexbyPhoneNum(String phoneNum) {
        for (int i = 0; i < contactList.size(); i++) {
            if (phoneNum.equals(contactList.get(i).getPhoneNum()))  {
                return i;
            }
        }
        return -1;
    }


}
