package test.java.com.contact.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import main.java.com.contact.service.Contact;
import main.java.com.contact.service.ContactService;


class ContactServiceTest {

	private ContactService service;
    private Contact contact;

    // This method sets up the test environment and therefore it is executed before each test case.
    @BeforeEach
    public void setUp() {
    	
    	// Initializes the ContactService object that is responsible for managing the contacts.
        service = new ContactService();
        
        // A sample Contact object containing specific attributes (fields) is created.
        contact = new Contact("A1B2C345", "Engred", "Vanegas", "8006681249", "2500 N River Rd");
        
        // The sample Contact is added to the ContactService via the 'addContact()' method. This helps
        // ensure that there is a contact present for appropriate testing.
        service.addContact(contact);
    }

    @Test
    public void testAddContact() {
    	// Creates a new Contact object that contains a unique contact ID and valid fields. 
        Contact newContact = new Contact("A12BC3D45", "Engred", "Vanegas", "8006681249", "555 Elm Street");
        
        // Tests if adding a new contact that contains a unique ID indeed returns true. This also helps
        // ensure that the the contact has been successfully added to the ContactService.
        assertTrue(service.addContact(newContact));
        
        // Tests if adding a duplicate contact returns false. This also helps ensure that the ContactService
        // does not allow any addition of duplicate contact IDs.
        assertFalse(service.addContact(contact)); 
    }

    @Test
    public void testDeleteContact() {
    	
    	// Creates a new contact for this test in order to ensure it is independent from the other tests.
    	Contact newContact = new Contact("B10CD8E14", "Carlos", "Vanegas", "7188351360", "2900 Bedford Ave");
    	service.addContact(newContact);
    	
    	// Tests if deleting an existing contact through the use of the contact ID returns true. This also 
    	// helps ensure that the contact has been successfully removed from the ContactService.
        assertTrue(service.deleteContact(contact.getContactId()));
        
        // Tests if an attempt to delete a non-existing contact returns false. This also helps ensure that
        // the ContactService can handle the deletion of non-existing contacts correctly.
        assertFalse(service.deleteContact("nonexistent")); 
    }

    @Test
    public void testUpdateContact() {
    	
    	// Uses assertAll in order to group multiple assertions.
    	assertAll("updateContact",
    	
    	// Tests if updating only the first name of an existing contact by its contact ID returns true. This helps
    	// ensure that the ContactService updates specified contact fields correctly.
    	() -> {
    		assertTrue(service.updateContact(contact.getContactId(), "Emi", null, null, null));
    		assertEquals("Emi", service.getContact(contact.getContactId()).getFirstName());
    	},
        // Tests if updating only the last name of an existing contact by its contact ID returns true. This helps
        // ensure that the ContactService updates specified contact fields correctly.
    	() -> {
    		assertTrue(service.updateContact(contact.getContactId(), null, "Davis", null, null));
    		assertEquals("Davis", service.getContact(contact.getContactId()).getLastName());
    	},       
        // Tests updating only the phone number of an existing contact by its contact ID returns true. This helps
        // ensure that the ContactService updates specified contact fields correctly.
    	() -> {
    		assertTrue(service.updateContact(contact.getContactId(), null, null, "8006681249", null));
    		assertEquals("8006681249", service.getContact(contact.getContactId()).getPhone());
    	},        
        // Tests updating only the address of an existing contact by its contact ID return true. This helps ensure
        // that the ContactService updates specified contact fields correctly.
    	() -> {
    		assertTrue(service.updateContact(contact.getContactId(), null, null, null, "2500 N River Rd"));
    		assertEquals("2500 N River Rd", service.getContact(contact.getContactId()).getAddress());
    	},              
        // Tests if an attempt to update a non-existing contact returns false. This helps ensure that the ContactService
        // can handle updating non-existent contacts correctly.
    	() -> assertFalse(service.updateContact("nonexistent", "Sophia", null, null, null))
        );   
    }
    
    @Test
    public void testUpdateContactFirstNameOnly() {
        assertTrue(service.updateContact(contact.getContactId(), "NewName", null, null, null));
        assertEquals("NewName", service.getContact(contact.getContactId()).getFirstName());
    }

    @Test
    public void testUpdateContactLastNameOnly() {
        assertTrue(service.updateContact(contact.getContactId(), null, "NewLast", null, null));
        assertEquals("NewLast", service.getContact(contact.getContactId()).getLastName());
    }

    @Test
    public void testUpdateContactPhoneOnly() {
        assertTrue(service.updateContact(contact.getContactId(), null, null, "1234567890", null));
        assertEquals("1234567890", service.getContact(contact.getContactId()).getPhone());
    }

    @Test
    public void testUpdateContactAddressOnly() {
        assertTrue(service.updateContact(contact.getContactId(), null, null, null, "New Address 123"));
        assertEquals("New Address 123", service.getContact(contact.getContactId()).getAddress());
    }

    
    @Test
    public void testGetContact() {
        // Tests if retrieving an existing contact by its contact ID does not return null. Meaning that the contact with
    	// the specified ID does exist in the ContactService and can therefore be retrieved successfully. 
        assertNotNull(service.getContact(contact.getContactId()));

        // Tests if retrieving a non-existent contact returns null. This means that the ContactService can properly handle
        // any attempt that involves retrieving a contact that does not exist in the 'contacts' map.
        assertNull(service.getContact("nonexistent"));
    }

}
