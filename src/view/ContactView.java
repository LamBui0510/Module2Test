package view;


import controller.ContactController;
import model.Contact;
import service.ContactService;
import service.Regex;

import java.util.Scanner;

public class ContactView {
    ContactController contactController = new ContactController();
    ContactService contactService = new ContactService();
    Scanner sc = new Scanner(System.in);

    public void showContactMenu() {
        while (true) {
            System.out.println("1. Show contact");
            System.out.println("2. Add contact");
            System.out.println("3. Edit contact");
            System.out.println("4. Delete contact");
            System.out.println("5. Read contact");
            System.out.println("6. Write contact");
            System.out.println("7. Find number");
            System.out.println("8. Exit");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    showContacts();
                    break;
                case 2:
                    addContact();break;

                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    contactService.readFile();
                    break;
                case 6:
                    contactService.writeToFile();
                    break;
                case 7:
                    findByPhoneNum();
                    break;
                case 8: return;
            }
        }

    }

    public Contact createContact() {
        while (true) {
            String phoneNum = Regex.validate("Enter Phone number", "Wrong type, Enter 8 number from 0-9", Regex.NUMBER);
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
            contactController.addContact(createContact());
            System.out.println("add contact success!!");
            System.out.println("Press any key to CONTINUE or ENTER quit to BACK to menu-");
            String back = sc.nextLine();
            if (back.equalsIgnoreCase("quit")) {
                return;
            }
        }
    }

    public void editContact() {
        while (true) {
            String phoneNum = Regex.validate("Enter Phone number to edit", "Wrong type, Enter 8 number from 0-9", Regex.NUMBER);
            int index = contactController.findContactByNumber(phoneNum);
            if (index > -1) {
                contactController.editContact(index, createContact());
                System.out.println(" Edit success - Plz Enter any key to continue or Enter  to get back to menu");
                String back = sc.next();
                if (back.equalsIgnoreCase("quit")) {
                    return;
                }

            } else {
                System.err.println("Phone number not found - Plz try again or Enter  to get back to menu");
                String back = sc.next();
                if (back.equalsIgnoreCase("quit")) {
                    return;
                }
            }
        }
    }

    public void deleteContact() {
        while (true) {
            String phoneNum = Regex.validate("Enter Phone number to edit", "Wrong type, Enter 8 number from 0-9", Regex.NUMBER);
            int index = contactController.findContactByNumber(phoneNum);
            if (index > -1) {
                System.out.println("Would you like to delete?- Enter Yes ");
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("yes")) {
                    contactController.deleteContact(index);
                    System.out.println(" Edit success - Plz Enter any key to continue or Enter to get back to menu");
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

    public void findByPhoneNum() {
        while (true) {
            System.out.println("enter phoneNum");
            String number = sc.nextLine();
            for (Contact c : contactController.showContact()) {
                if (c.getPhoneNum().contains(number)) {
                    System.out.println(c);
                }
            }
        }
    }
    public void showContacts() {
        for (int i = 0; i < contactController.showContact().size(); i++) {
            System.out.println(contactController.showContact().get(i).toString());
            if (i % 5 == 0 && i != 0) {
                sc.nextLine();
            }
        }
    }
}
