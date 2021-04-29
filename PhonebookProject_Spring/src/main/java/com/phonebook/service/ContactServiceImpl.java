package com.phonebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.dao.ContactDao;
import com.phonebook.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	ContactDao contactDao;
	

	@Override
	public List<Contact> allContacts(){
		
		return contactDao.getAllContacts();
		
	}
	@Override
	public Contact OneContact(int id) {
		Contact ct = contactDao.getOneContact(id);
       return ct;
	}
	
	
	@Override
	public  void  addYourContact(Contact ref) {
		contactDao.addContact(ref);
		
	}
	
	@Override
	public void deleteYourContact(int id) {
		contactDao.deleteContact(id);
	}
}


