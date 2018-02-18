package com.bgoggin.customerfield;

import java.util.ArrayList;
import java.util.List;

public class CustomerFunctionalGenericLambda {
    static public ArrayList<CustomerFunctionalGenericLambda> allCustomers = new ArrayList<CustomerFunctionalGenericLambda>();
    public Integer id = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContact = "";
    public String domain = "";
    public Boolean enabled = true;

    public CustomerFunctionalGenericLambda() {
    }

    // Generic implementation, inner classes gone, but type safe,
    // however can now also return any type, note CustomerAsCustomer
    // also see first <B> in getEnabledCustomerField for how to make
    // generic. Still lots of verbosity.

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

}



