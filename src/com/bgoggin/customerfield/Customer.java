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
}
