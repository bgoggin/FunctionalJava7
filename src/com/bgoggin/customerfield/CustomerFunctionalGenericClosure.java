package com.bgoggin.customerfield;

import java.util.ArrayList;
import java.util.List;

public class CustomerFunctionalGenericClosure {
    static public ArrayList<CustomerFunctionalGenericClosure> allCustomers = new ArrayList<CustomerFunctionalGenericClosure>();
    public Integer id = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContact = "";
    public String domain = "";
    public Boolean enabled = true;

    public CustomerFunctionalGenericClosure() {
    }

    // Same as Lambda, but new requirement to add
    // prepended string to domains, demonstrates
    // how closure preserves state of instance

    public static <B> List<B> getEnabledCustomerField(Function1<Customer, B> func) {
        ArrayList<B> outlist = new ArrayList<>();
        for (Customer customer : Customer.allCustomers) {
            if (customer.enabled) {
                outlist.add(func.call(customer));
            }
        }
        return outlist;
    }

    // Of course, could just call above directly, but demonstrates
    // one way repetition could be reduced
    // check out getEnabledCustomerSomeoneEmail
    public static List<String> getEnabledCustomerNames() {
        return getEnabledCustomerField(
                //Anonymous inner class implementing Function1
                new Function1<Customer, String>() {
                    public String call(Customer customer) {
                        return customer.name;
                    }
                });
    }

    public static List<String> getEnabledCustomerStates() {
        return getEnabledCustomerField(
                new Function1<Customer, String>() {
                    public String call(Customer customer) {
                        return customer.state;
                    }
                });
    }

    public static List<String> getEnabledCustomerPrimaryContacts() {
        return getEnabledCustomerField(
                new Function1<Customer, String>() {
                    public String call(Customer customer) {
                        return customer.primaryContact;
                    }
                });
    }

    public static List<String> getEnabledCustomerDomains() {
        return getEnabledCustomerField(
                new Function1<Customer, String>() {
                    public String call(Customer customer) {
                        return customer.domain;
                    }
                });
    }

    public static List<String> getEnabledCustomerAddresses() {
        return getEnabledCustomerField(
                new Function1<Customer, String>() {
                    public String call(Customer customer) {
                        return customer.address;
                    }
                });
    }

    public static List<Customer> getEnabledCustomers() {
        return getEnabledCustomerField(
                new Function1<Customer, Customer>() {
                    public Customer call(Customer customer) {
                        return customer;
                    }
                });
    }

    // Note inner class param has to be final to close over class variable
    // Normally somone wouldn't be visible to getEnabledCustomerField(), but
    // closure makes it visible
    public static List<String> getEnabledCustomerSomeoneEmail(final String someone) {
        return getEnabledCustomerField(
                new Function1<Customer, String>() {
                    public String call(Customer customer) {
                        return someone + "@" + customer.domain;
                    }
                });
    }

}



