package test.java.com.contact.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.java.com.contact.service.Contact;

class ContactTest {

	@Test
	void testContact() {
		System.out.println("Running testContact");
		// Tests when a customer ID is less than 10 (<10) characters long. If it is, then it is accepted.
	    Contact contactShortId = new Contact("A1B2C345", "Engred", "Vanegas", "8006681249", "2500 N River Rd");
	    assertEquals("A1B2C345", contactShortId.getContactId());

	    // Tests when a customer ID equals exactly 10 (==10) characters long. If it is, then it is accepted.
	    Contact contactExactId = new Contact("1A2B34C567", "Engred", "Vanegas", "8006681249", "2500 N River Rd");
	    assertEquals("1A2B34C567", contactExactId.getContactId());

	    // Tests when a first name equals exactly 10 (==10) characters long. If it is, then it is accepted.
	    Contact contactFirstNameExact = new Contact("A1B2C345", "Maximilian", "Miller", "8006681249", "2500 N River Rd");
	    assertEquals("Maximilian", contactFirstNameExact.getFirstName());

	    // Tests when a first name is less than 10 (<10) characters long. If it is, then it is accepted.
	    Contact contactFirstNameShort = new Contact("A1B2C345", "Engred", "Vanegas", "8006681249", "2500 N River Rd");
	    assertEquals("Engred", contactFirstNameShort.getFirstName());

	    // Tests when a last name equals exactly 10 (==10) characters long. If it is, then it is accepted.
	    Contact contactLastNameExact = new Contact("A1B2C345", "Taylor", "Willoughby", "8006681249", "2500 N River Rd");
	    assertEquals("Willoughby", contactLastNameExact.getLastName());

	    // Tests when a last name is less than 10 (<10) characters long. If it is, then it is accepted.
	    Contact contactLastNameShort = new Contact("1A2B34C567", "Engred", "Vanegas", "8006681249", "2500 N River Rd");
	    assertEquals("Vanegas", contactLastNameShort.getLastName());

	    // Tests when a phone number equals exactly 10 (==10) digits long. If it is, then it is accepted.
	    Contact contactPhoneExact = new Contact("1A2B34C567", "Engred", "Vanegas", "8006681249", "2500 N River Rd");
	    assertEquals("8006681249", contactPhoneExact.getPhone());

	    // Tests when an address is less than 30 (<30) characters long. If it is, then it is accepted.
	    Contact contactAddressShort = new Contact("1A2B34C567", "Engred", "Vanegas", "8006681249", "2500 N River Rd");
	    assertEquals("2500 N River Rd", contactAddressShort.getAddress());

	    // Tests when an address equals exactly 30 (==30) characters long. If it is, then it is accepted.
	    Contact contactAddressExact = new Contact("1A2B34C567", "Engred", "Vanegas", "8006681249", "555 Elm St Manchester NH 03101");
	    assertEquals("555 Elm St Manchester NH 03101", contactAddressExact.getAddress());
	}
	
	@Test
    void testInvalidContactId() {
		System.out.println("Running testInvalidContactId");
		// Tests when a customer ID is null. If it is then an IllegalArgumentException is thrown.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	System.out.println("Testing null contactId");
            new Contact(null, "Engred", "Vanegas", "8006681249", "2500 N River Rd");
        });
        // Tests when a customer ID is greater than 10 (>10) characters long.
        // If it is then an IllegalArgumentException is thrown.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1AB23C4D567", "Engred", "Vanegas", "8006681249", "2500 N River Rd");
        });
    }

    @Test
    void testInvalidFirstName() {
    	System.out.println("Running testInvalidFirstName");
    	// Tests when a first name is null. If it is then an IllegalArgumentException is thrown.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("A1B2C345", null, "Vanegas", "8006681249", "2500 N River Rd");
        });
        // Tests when a first name is greater than 10 (>10) characters long.
        // If it is then an IllegalArgumentException is thrown.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	System.out.println("Testing contactId greater than 10 characters");
            new Contact("A1B2C345", "Aleksandrina", "Vanegas", "8006681249", "2500 N River Rd");
        });
    }

    @Test
    void testInvalidLastName() {
    	System.out.println("Running testInvalidLastName");
    	// Tests when a last name is null. If it is then an IllegalArgumentException is thrown.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1A2B34C567", "Engred", null, "8006681249", "2500 N River Rd");
        });
        // Tests when a last name is greater than 10 (>10) characters long.
        // If it is then an IllegalArgumentException is thrown.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1A2B34C567", "Engred", "Hollingsworth", "8006681249", "2500 N River Rd");
        });
    }

    @Test
    void testInvalidPhone() {
    	System.out.println("Running testInvalidPhone");
    	// Tests when a phone number is null. If it is then an IllegalArgumentException is thrown.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("A1B2C345", "Engred", "Vanegas", null, "2500 N River Rd");
        });
        // Tests when a phone number is less than 10 (<10) characters long.
        // If it is then an IllegalArgumentException is thrown.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("A1B2C345", "Engred", "Vanegas", "6681249", "2500 N River Rd");
        });
        // Tests when a phone number is more than 10 (>10) characters long.
        // If it is then an IllegalArgumentException is thrown.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("A1B2C345", "Engred", "Vanegas", "18006681249", "2500 N River Rd");
        });
    }

    @Test
    void testInvalidAddress() {
    	System.out.println("Running testInvalidAddress");
    	// Tests when an address is null. If it is then an IllegalArgumentException is thrown.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1A2B34C567", "Engred", "Vanegas", "8006681249", null);
        });
        // Tests when an address is more than 30 (>30) characters long.
        // If it is then an IllegalArgumentException is thrown.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1A2B34C567", "Engred", "Vanegas", "8006681249", "2500 North River Rd Manchester NH 03106");
        });
    }
    
    @Test
    void testSetFirstName() {
    	System.out.println("Running testSetFirstName");
        Contact contact = new Contact("A1B2C345", "Engred", "Vanegas", "8006681249", "2500 N River Rd");
        contact.setFirstName("NewName");
        assertEquals("NewName", contact.getFirstName());
    }
    
    @Test
    void testSetFirstNameInvalid() {
    	System.out.println("Running testSetFirstNameInvalid");
        Contact contact = new Contact("A1B2C345", "Engred", "Vanegas", "8006681249", "2500 N River Rd");
        // Tests setting first name to null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
        // Tests setting first name to a value longer than 10 characters
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("ThisNameIsTooLong");
        });
    }

    @Test
    void testSetLastName() {
    	System.out.println("Running testSetLastName");
        Contact contact = new Contact("A1B2C345", "Engred", "Vanegas", "8006681249", "2500 N River Rd");
        contact.setLastName("NewLast");
        assertEquals("NewLast", contact.getLastName());
    }

    @Test
    void testSetLastNameInvalid() {
    	 System.out.println("Running testSetLastNameInvalid");
        Contact contact = new Contact("A1B2C345", "Engred", "Vanegas", "8006681249", "2500 N River Rd");
        // Tests setting last name to null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
        // Tests setting last name to a value longer than 10 characters
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("ThisLastNameIsTooLong");
        });
    }
    
    @Test
    void testSetPhone() {
    	System.out.println("Running testSetPhone");
        Contact contact = new Contact("A1B2C345", "Engred", "Vanegas", "8006681249", "2500 N River Rd");
        contact.setPhone("1234567890");
        assertEquals("1234567890", contact.getPhone());
    }

    @Test
    void testSetPhoneInvalid() {
    	 System.out.println("Running testSetPhoneInvalid");
        Contact contact = new Contact("A1B2C345", "Engred", "Vanegas", "8006681249", "2500 N River Rd");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("123456789012");
        });
    }
    
    @Test
    void testSetAddress() {
    	System.out.println("Running testSetAddress");
        Contact contact = new Contact("A1B2C345", "Engred", "Vanegas", "8006681249", "2500 N River Rd");
        contact.setAddress("New Address 123");
        assertEquals("New Address 123", contact.getAddress());
    }
    
    @Test
    void testSetAddressInvalid() {
    	System.out.println("Running testSetAddressInvalid");
        Contact contact = new Contact("A1B2C345", "Engred", "Vanegas", "8006681249", "2500 N River Rd");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("This address is definitely too long for the field");
        });
    }
}
