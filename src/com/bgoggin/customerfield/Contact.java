package com.bgoggin.customerfield;

public class Contact {

    public Integer contactId = 0;
    public String firstName = "";
    public String lastName = "";
    public String email = "";
    public Boolean enabled = true;

    public Contact(Integer contact_id,
                   String firstName,
                   String lastName,
                   String email,
                   Boolean enabled) {
        this.contactId = contact_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enabled = enabled;
    }

    public void sendEmail(String message) {
        System.out.println(message);
    }
}