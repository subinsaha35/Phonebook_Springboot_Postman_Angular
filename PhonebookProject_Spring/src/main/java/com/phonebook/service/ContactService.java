package com.phonebook.service;

import java.util.List;

import com.phonebook.entity.Contact;

public interface ContactService {
	List<Contact> allContacts();
	Contact OneContact(int id);
	void  addYourContact(Contact ref);
	void deleteYourContact(int id);

}
