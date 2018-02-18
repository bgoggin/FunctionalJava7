package com.bgoggin.customerfield;

import java.util.ArrayList;
import java.util.List;

public class CustomerHigherOrder {
    static public ArrayList<CustomerHigherOrder> allCustomers = new ArrayList<CustomerHigherOrder>();
    public Integer id = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContact = "";
    public String domain = "";
    public Boolean enabled = true;

    public CustomerHigherOrder() {
    }

    // Just like closure, but now pass a function into a
    // function in case we want to get disabled instead of
    // enabled note distinction between getField and
    // getEnabledCustomerField

    public static <B> List<B> getField(Function1<Customer, Boolean> test,
                                       Function1<Customer,B> func) {
        ArrayList<B> outlist = new ArrayList<B>();
        for(Customer customer:Customer.allCustomers) {
            if(test.call(customer)) {
                outlist.add(func.call(customer));
            }
        }
        return outlist;
    }

    //create 2 function variables, so anonymous class passing doesn't get crazy
    static final public Function1<Customer, Boolean> EnabledCustomer =
            new Function1<Customer, Boolean>()
            {
                public Boolean call(Customer customer) {
                    return customer.enabled = true;
                }
            };

    static final public Function1<Customer, Boolean> DisabledCustomer =
            new Function1<Customer, Boolean>()
            {
                public Boolean call(Customer customer) {
                    return customer.enabled = false;
                }
            };

    // Demonstrates calling higher order w/o
    // having to right 2 anonymos classes in
    // parameter list
    public static List<String> getDisabledCustomerNames() {
        return getField(
                DisabledCustomer, new Function1<Customer, String>() {
                    public String call(Customer customer) {
                        return customer.name;
                    }
                });
    }

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



