package com.bgoggin.customerfield;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    static public ArrayList<Customer> allCustomers = new ArrayList<Customer>();
    public Integer id = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContact = "";
    public String domain = "";
    public Boolean enabled = true;

    static {
        setUpCustomers();
    }
    public Customer() {
    }

    // Note quantity of repeated code in these methods
    // 6 lines of duplicated code per function
    // a verbose way to accomplish similar tasks

    public static List<String> getEnabledCustomerNames() {
        ArrayList<String> outlist = new ArrayList<String>();
        for (Customer customer: Customer.allCustomers) {
            if(customer.enabled) {
                outlist.add(customer.name);
            }
        }
        return outlist;
    }

    public static List<String> getEnabledCustomerStates() {
        ArrayList<String> outlist = new ArrayList<>();
        for(Customer customer :Customer.allCustomers) {
            if(customer.enabled) {
                outlist.add(customer.state);
            }
        }
        return outlist;
    }

    public static List<String> getEnabledCustomerPrimaryContacts() {
        ArrayList<String> outlist = new ArrayList<>();
        for (Customer customer:Customer.allCustomers) {
            if (customer.enabled) {
                outlist.add(customer.primaryContact);
            }
        }
        return outlist;
    }

    public static List<String> getEnabledCustomerDomains() {
        ArrayList<String> outlist = new ArrayList<String>();
        for (Customer customer :Customer.allCustomers) {
            if(customer.enabled) {
                outlist.add(customer.domain);
            }
        }
        return outlist;
    }

    public static List<String> getEnabledCustomerAddresses() {
        ArrayList<String> outlist = new ArrayList<>();
        for(Customer customer:Customer.allCustomers) {
            if (customer.enabled) {
                outlist.add(customer.address);
            }
        }
        return outlist;
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
