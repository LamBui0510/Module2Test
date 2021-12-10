package controller;

import model.Contact;
import service.ContactService;

import java.util.List;

public class ContactController {
    ContactService contactService = new ContactService();
    public List<Contact> showContact(){
    return contactService.findAll();
    }
    public void addContact(Contact contact){
        contactService.save(contact);
    }
    public void editContact(int index, Contact contact){
        contactService.edit(index,contact);
    }
    public void deleteContact(int index){
        contactService.delete(index);
    }
    public int findContactByNumber(String phoneNumber){
       return contactService.findIndexbyPhoneNum(phoneNumber);
    }

}
