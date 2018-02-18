package com.bgoggin.customerfield;

public class Main {

    public static void main(String[] args) {
	    setUpCustomers();
    }

    private static void setUpCustomers() {
        Customer cust = new Customer();
        cust.id = 0;
        cust.name = "Bill Goggin";
        cust.address = "7 Heatherwood Grn, Cromwell, CT 06416";
        cust.state = "CT";
        cust.domain = "bgoggin.com";
        cust.primaryContact = "Sheri Goggin";
        cust.enabled = true;
        Customer.allCustomers.add(cust);
        cust = new Customer();
        cust.id = 1;
        cust.name = "Sheri Goggin";
        cust.address = "7 Heatherwood Grn, Cromwell, CT 06416";
        cust.state = "CT";
        cust.domain = "me.com";
        cust.primaryContact = "Bill Goggin";
        cust.enabled = true;
        Customer.allCustomers.add(cust);
        cust = new Customer();
        cust.id = 2;
        cust.name = "Sarah Goggin";
        cust.address = "7 Heatherwood Grn, Cromwell, CT 06416";
        cust.domain = "wm.edu";
        cust.primaryContact = "Sean";
        cust.enabled = true;
        Customer.allCustomers.add(cust);
        cust = new Customer();
        cust.name = "Leah Goggin";
        cust.id = 3;
        cust.address = "7 Heatherwood Grn, Cromwell, CT 06416";
        cust.domain = "mit.edu";
        cust.primaryContact = "Sheri Goggin";
        cust.enabled = true;
        Customer.allCustomers.add(cust);
        cust = new Customer();
        cust.id = 4;
        cust.name = "Sally Yobst";
        cust.address = "489 Forest St., East Hartford, CT";
        cust.domain = "snet.net";
        cust.primaryContact = "Sheri Goggin";
        cust.enabled = false;
        Customer.allCustomers.add(cust);
    }
}


