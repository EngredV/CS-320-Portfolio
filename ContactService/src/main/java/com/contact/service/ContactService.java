package main.java.com.contact.service;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	private Map<String, Contact> contacts;

	// Constructor responsible for initializing the contacts map
    public ContactService() {
        contacts = new HashMap<>();
    }

    // Method for adding contacts.
    public boolean addContact(Contact contact) {
    	// Conditional check to ensure that the contact does not already exist.
        if (contacts.containsKey(contact.getContactId())) {
        	 // If the contact ID already exists then it won't be created or added.
            return false;
        }
        // But if the contact ID does not exist, then a new contact is added.
        contacts.put(contact.getContactId(), contact);
        return true;
    }

    // Method for deleting contacts by contact ID.
    public boolean deleteContact(String contactId) {
    	// Conditional check to ensure that the contact exists.
        if (!contacts.containsKey(contactId)) {
        	// If the contact ID does not exist then it can't be deleted.
            return false;
        }
        // But if the contact ID does exist, then the contact is deleted.
        contacts.remove(contactId);
        return true;
    }

    // Method for updating a contact's fields by contact ID.
    public boolean updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        // Conditional check to ensure that the contact exists.
    	if (!contacts.containsKey(contactId)) {
    		// If the contact ID does not exist then it cannot be updated.
            return false;
        }
    	// But if the contact ID exists, then its fields are updated.
        Contact contact = contacts.get(contactId);
        // Conditional check to ensure that the first name is not null.
        // If it is not null then it proceeds to set (update) the first name.
        if (firstName != null) contact.setFirstName(firstName);
        // Conditional check to ensure that the last name is not null.
        // If it is not null then it proceeds to set (update) the last name.
        if (lastName != null) contact.setLastName(lastName);
        // Conditional check to ensure that the phone number is not null.
        // If it is not null then it proceeds to set (update) the phone number.
        if (phone != null) contact.setPhone(phone);
        // Conditional check to ensure that the address field is not null.
        // If it is not null then it proceeds to set (update) the address.
        if (address != null) contact.setAddress(address);
        return true;
    }

    // Method for retrieving a contact from the contacts map by using the contactId.
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
