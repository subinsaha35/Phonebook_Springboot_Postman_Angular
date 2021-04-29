package com.phonebook.dao;

import java.util.List;

import com.phonebook.entity.Contact;

public interface ContactDao {
	List<Contact> getAllContacts();
	Contact getOneContact(int id);
	void addContact(Contact ref);
	void deleteContact(int id);

}
