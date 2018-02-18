package com.bgoggin.customerfield;

import java.util.ArrayList;
import java.util.List;

public class CustomerFunctionalNamedInner {
    static public ArrayList<CustomerFunctionalNamedInner> allCustomers = new ArrayList<CustomerFunctionalNamedInner>();
    public Integer id = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContact = "";
    public String domain = "";
    public Boolean enabled = true;

    public CustomerFunctionalNamedInner() {
    }

    // Less repetition than plain Customer, but very verbose
    // lots of extra inner classes, but type safe, unlike if/else
    // however also can only handle returning String properties
    public static List<String> getEnabledCustomerField(ConversionFunction func) {
        ArrayList<String> outlist = new ArrayList<>();
        for(CustomerFunctionalNamedInner customer:CustomerFunctionalNamedInner.allCustomers) {
            if(customer.enabled) {
                outlist.add(func.call(customer));
            }
        }
        return outlist;
    }

    static private class CustomerName implements ConversionFunction {
        public String call(CustomerFunctionalNamedInner customer) {
            return customer.name;
        }
    }

    static private class CustomerState implements ConversionFunction {
        public String call(CustomerFunctionalNamedInner customer) {
            return customer.state;
        }
    }

    static private class CustomerPrimaryContact implements  ConversionFunction {
        public String call(CustomerFunctionalNamedInner customer) {
            return customer.primaryContact;
        }
    }

    static private class CustomerDomain implements ConversionFunction {
        public String call(CustomerFunctionalNamedInner customer) {
            return customer.domain;
        }
    }

    static private class CustomerAddress implements ConversionFunction {
        public String call(CustomerFunctionalNamedInner customer) {
            return customer.address;
        }
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

    private interface ConversionFunction {
        public String call(CustomerFunctionalNamedInner customer);
    }
}



