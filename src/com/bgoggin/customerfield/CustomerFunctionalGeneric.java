package com.bgoggin.customerfield;

import java.util.ArrayList;
import java.util.List;

public class CustomerFunctionalGeneric {
    static public ArrayList<CustomerFunctionalGeneric> allCustomers = new ArrayList<CustomerFunctionalGeneric>();
    public Integer id = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContact = "";
    public String domain = "";
    public Boolean enabled = true;

    public CustomerFunctionalGeneric() {
    }

    // Generic implementation, but still very verbose
    // lots of extra inner classes, but type safe, unlike if/else
    // however can now also return any type, note CustomerAsCustomer
    // also see first <B> in getEnabledCustomerField for how to make
    // generic

    public static <B> List<B> getEnabledCustomerField(Function1<Customer, B> func) {
        ArrayList<B> outlist = new ArrayList<>();
        for(Customer customer:Customer.allCustomers) {
            if(customer.enabled) {
                outlist.add(func.call(customer));
            }
        }
        return outlist;
    }

    static private class CustomerName implements Function1<Customer, String> {
        public String call(Customer customer) {
            return customer.name;
        }
    }

    static private class CustomerState implements Function1<Customer, String> {
        public String call(Customer customer) {
            return customer.state;
        }
    }

    static private class CustomerPrimaryContact implements Function1<Customer, String> {
        public String call(Customer customer) {
            return customer.primaryContact;
        }
    }

    static private class CustomerDomain implements Function1<Customer, String> {
        public String call(Customer customer) {
            return customer.domain;
        }
    }

    static private class CustomerAddress implements Function1<Customer, String> {
        public String call(Customer customer) {
            return customer.address;
        }
    }

    static private class CustomerAsCustomer implements Function1<Customer, Customer> {
        public Customer call(Customer customer) { return customer;}
    }

    // Of course, could just call above directly, but demonstrates
    // one way repetition could be reduced
    public static List<String> getEnabledCustomerNames() {
        return getEnabledCustomerField(new CustomerName());
    }

    public static List<String> getEnabledCustomerStates() {
        return getEnabledCustomerField(new CustomerState());
    }

    public static List<String> getEnabledCustomerPrimaryContacts() {
        return getEnabledCustomerField(new CustomerPrimaryContact());
    }

    public static List<String> getEnabledCustomerDomains() {
        return getEnabledCustomerField(new CustomerDomain());
    }

    public static List<String> getEnabledCustomerAddresses() {
        return getEnabledCustomerField(new CustomerAddress());
    }

    public static List<Customer> getEnabledCustomers() {
        return getEnabledCustomerField(new CustomerAsCustomer());
    }

}



