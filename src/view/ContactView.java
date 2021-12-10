package view;


import controller.ContactController;
import model.Contact;
import service.ContactService;
import service.Regex;

import java.util.List;
import java.util.Scanner;

public class ContactView {
    ContactController contactController = new ContactController();
    ContactService contactService = new ContactService();
    Scanner sc = new Scanner(System.in);
    public void showContactMenu() {
        while (true) {
            int choice = Integer.parseInt(Regex.NUMBER);
            switch (choice) {
                case 1:
                contactController.showContacts();
                break;
                case 2: addContact();
                break;
                case 3: editContact();
                break;
                case 4: deleteContact();
                break;
                case 5: contactService.readFile();
                break;
                case 6: contactService.writeToFile();
                case 7: return;
            }
        }
    }

    public Contact createContact() {
        while (true) {
            String phoneNum =Regex.validate("Enter Phone number", "Wrong type, Enter 8 number from 0-9", Regex.NUMBER);
            String group = Regex.validateNotNull("Enter group", "not null");
            String name = Regex.validateNotNull("Enter name", "not null");
            String gender = Regex.validateNotNull("Enter gender", "Not null");
            String address = Regex.validateNotNull("Enter address", "Not null");
            String birth = Regex.validateNotNull("Enter birth", "Not null");
            String email = Regex.validate("Enter email", "Not null", Regex.EMAIL);
            Contact contact = new Contact(phoneNum, group, name, gender, address, birth, email);
            return contact;
        }
    }

    public void addContact() {
        while (true) {
            System.out.println("Enter contact Infomation");
            createContact();
            System.out.println("add contact success!!");
            System.out.println("Press any key to CONTINUE or ENTER QUIT BACK to menu-");
            String back = sc.nextLine();
            if (back.equalsIgnoreCase("quit")) {
                return;
            }
        }
    }

    public void editContact() {
        String phoneNum = Regex.validate("Enter Phone number to edit", "Wrong type, Enter 8 number from 0-9", Regex.NUMBER);
        int index = contactController.findContactByNumber(phoneNum);
        if (index > -1) {
            contactController.editContact(index, createContact());
            System.out.println(" Edit success - Plz Enter any key to continue or Enter quit to get back to menu");
            String back = sc.next();
            if (back.equalsIgnoreCase("quit")) {
                return;
            }

        } else {
            System.err.println("Phone number not found - Plz try again or Enter quit to get back to menu");
            String back = sc.next();
            if (back.equalsIgnoreCase("quit")) {
                return;
            }
        }
    }

    public void deleteContact() {
        String phoneNum = Regex.validate("Enter Phone number to edit", "Wrong type, Enter 8 number from 0-9", Regex.NUMBER);
        int index = contactController.findContactByNumber(phoneNum);
        if (index > -1) {
            System.out.println("Would you like to discharge the bill?- Enter Yes ");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                contactController.deleteContact(index);
                System.out.println(" Edit success - Plz Enter any key to continue or Enter quit to get back to menu");
                sc.nextLine();
                return;
            } else {
                System.err.println("Phone number not found - Plz try again or Enter to get back to menu");
                sc.nextLine();
                return;
            }
        }

    }
}
