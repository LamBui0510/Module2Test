package service;


import model.Contact;

import java.util.List;

public interface IContact<Contact> {
    List<Contact> findAll();
    void save(Contact contact);
    void delete(int index);
    void edit(int index, Contact contact);
}
