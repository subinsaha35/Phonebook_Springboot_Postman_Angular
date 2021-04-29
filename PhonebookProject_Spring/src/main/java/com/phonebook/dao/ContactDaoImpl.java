package com.phonebook.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phonebook.entity.Contact;

@Repository
public class ContactDaoImpl implements ContactDao{

	public ContactDaoImpl() {
		super();
	}
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<Contact> getAllContacts(){
		Query query = entityManager.createQuery(" from Contact");
		List<Contact> contactList = query.getResultList();
		return contactList;
	}
      @Override
      @Transactional
      public Contact getOneContact(int id) {
    	  
    	  try {
			Contact ct= entityManager.find(Contact.class, id);
				System.out.println("FirstName is "+ct.getFirstName()+". LastName is "+ct.getLastName()+". PhoneNumber is "+ct.getPhoneNumber()+". Email is "+ct.getEmail());
				return ct;
		} catch (Exception e) {
			System.out.println("Contact not found");
			return null;
		}
		}

    	  @Override
    	  @Transactional
    	  public void addContact(Contact ref) {
    			entityManager.persist(ref);
    		}
    	  
    	    @Override
    		@Transactional
    		public void deleteContact(int id) {
    			try {
    				Contact ct = entityManager.find(Contact.class, id);
    				entityManager.remove(ct);
    			}catch(Exception ex) {
    				System.out.println("ID DOES NOT EXIST");
    			}
    		}


}
