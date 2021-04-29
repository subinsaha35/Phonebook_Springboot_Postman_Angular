package com.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.entity.Contact;
import com.phonebook.service.ContactService;

@RestController
@CrossOrigin
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	
	@GetMapping(path = "/getAllContacts.api", produces = "application/json")
    public List<Contact> getAllContact(){    
        List<Contact> contactList=contactService.allContacts();
        return contactList;
    }
	
	@PutMapping(value = "/getContact.api/{id}")
	public Contact getOneContact(@PathVariable int id) {
		Contact ct=contactService.OneContact(id);
		return ct;
	}

	

	@RequestMapping("/contacts/{id}/delete")
    protected void deleteContact(@PathVariable int id) {
         contactService.deleteYourContact(id);
    }

	@RequestMapping("/contacts/save")
    protected void addContact(@RequestBody Contact ref) {
        contactService.addYourContact(ref);
    }
}
		
	



