package main.java.com.contact.service;

public class Contact {

	// The final keyword is used here to ensure that the contactId variable can only
	// be assigned once.
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		System.out.println("Creating Contact with ID: " + contactId);
		validateContactId(contactId);
	    validateName(firstName, "First Name");
	    validateName(lastName, "Last Name");
	    validatePhone(phone);
	    validateAddress(address);

		// contact field initializations and validations
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	/** Getters for all contact fields */
	
	// The getContactID() method retrieves and returns the unique contact ID of the contact from the 'contact' object.
	public String getContactId() {
		return contactId;
	}

	// The getFirstName() method retrieves and returns the first name of the contact.
	// It does so by retrieving the 'firstName' field from the 'Contact' object and returning it.
	public String getFirstName() {
		return firstName;
	}

	// The getLastName() method retrieves and returns the last name of the contact.
	// It does so by retrieving the 'lastName' field from the 'Contact' object and returning it.
	public String getLastName() {
		return lastName;
	}
	
	// The getPhone() method retrieves and returns the phone number of the contact.
	// It does so by retrieving the 'phone' field from the 'Contact' object and returning it.
	public String getPhone() {
		return phone;
	}

	// The getAdress() method retrieves and returns the address of the contact.
	// It does so by retrieving the 'address' field from the 'Contact' object and returning it.
	public String getAddress() {
		return address;
	}

	/**
	 * Setters for all other contact fields except contactId. This helps ensure that
	 * there won't be any way to change the contactId value from outside the Contact
	 * class. Which further enforces the contact ID's immutability.
	 */
	
	public void setFirstName(String firstName) {
		 validateName(firstName, "First Name");
		 this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		validateName(lastName, "Last Name");
		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		validatePhone(phone);
		this.phone = phone;
	}

	public void setAddress(String address) {
		validateAddress(address);
		this.address = address;
	}
	
	// Conditional check to make sure that the contactId string is not null nor is longer than 10 (>10)
	// characters. If it is then an IllegalArgumentException is thrown.
	private void validateContactId(String contactId) {
        if (contactId == null || contactId.length() > 10) {
        	System.out.println("Invalid Contact ID: " + contactId);
            throw new IllegalArgumentException("Invalid Contact ID");
        }
    }

	// Conditional check to make sure that both the firstName and lastName strings are not null nor are longer 
	// than 10 (>10) characters. If it is then an IllegalArgumentException is thrown.
    private void validateName(String name, String fieldName) {
        if (name == null || name.length() > 10) {
            throw new IllegalArgumentException("Invalid " + fieldName);
        }
    }

    // Conditional check to make sure that the phone string is not null and is exactly 10 (==10) digits.
 	// If it is then an IllegalArgumentException is thrown.
    private void validatePhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }
    }

    // Conditional check to make sure that the address string is not null nor is longer than 30 (>30)
 	// characters. If it is then an IllegalArgumentException is thrown.
    private void validateAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid Address");
        }
    }
}
