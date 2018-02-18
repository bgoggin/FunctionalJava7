package com.bgoggin.customerfield;

import java.util.ArrayList;
import java.util.List;

public class CustomerIfElse {
    static public ArrayList<CustomerIfElse> allCustomers = new ArrayList<CustomerIfElse>();
    public Integer id = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContact = "";
    public String domain = "";
    public Boolean enabled = true;

    public CustomerIfElse() {
    }

    // Less repetition than plain Customer, but relies on getting
    // strings right (though could use enumeration)
    public static List<String> getEnabledCustomerField(String field) {
        ArrayList<String> outlist = new ArrayList<>();
        for(CustomerIfElse customer:CustomerIfElse.allCustomers) {
            if(customer.enabled) {
                if(field.equalsIgnoreCase("name")) {
                    outlist.add(customer.name);
                } else if (field.equalsIgnoreCase("state")) {
                    outlist.add(customer.state);
                } else if (field.equalsIgnoreCase("primaryContact")) {
                    outlist.add(customer.primaryContact);
                } else if (field.equalsIgnoreCase("domain")) {
                    outlist.add(customer.domain);
                } else if (field.equalsIgnoreCase("address")) {
                    outlist.add(customer.address);
                } else {
                    throw new IllegalArgumentException("Unknown field");
                }
            }
        }
        return outlist;
    }

    // Of course, could just call above directly, but demonstrates
    // one way repetition could be reduced
    public static List<String> getEnabledCustomerNames() {
        return getEnabledCustomerField("name");
    }

    public static List<String> getEnabledCustomerStates() {
        return getEnabledCustomerField("state");
    }

    public static List<String> getEnabledCustomerPrimaryContacts() {
        return getEnabledCustomerField("primaryContact");
    }

    public static List<String> getEnabledCustomerDomains() {
        return getEnabledCustomerField("domain");
    }

    public static List<String> getEnabledCustomerAddresses() {
        return getEnabledCustomerField("address");
    }
}
