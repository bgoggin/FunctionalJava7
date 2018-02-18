package com.bgoggin.customerfield;

import java.util.ArrayList;
import java.util.List;

public class CustomerFilter { // Name is just to avoid collision, really just Customer
    static public ArrayList<CustomerFilter> allCustomers = new ArrayList<CustomerFilter>();
    public Integer id = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContact = "";
    public String domain = "";
    public Boolean enabled = true;
    public Contract contract = new Contract();

    public CustomerFilter() {
    }

    // Get back CustomerFilters by some filtering method
    // not pure because refrences CustomerFilter.allCustomers
    public static ArrayList<CustomerFilter> filter(Function1<CustomerFilter, Boolean> test) {
        ArrayList<CustomerFilter> outlist = new ArrayList<>();
        for (CustomerFilter customer:CustomerFilter.allCustomers) {
            if(test.call(customer)) {
                outlist.add(customer);
            }
        }
        return outlist;
    }

    // pure version of filter
    public static ArrayList<CustomerFilter> filter(ArrayList<CustomerFilter> inList,
                                              Function1<CustomerFilter, Boolean> test) {
        ArrayList<CustomerFilter> outList = new ArrayList<>();
        for(CustomerFilter customer : inList) {
            if(test.call(customer)) {
                outList.add(customer);
            }
        }
        return outList;
    }

    // Get field from other classes using filter
    public static <B> List<B> getField(Function1<CustomerFilter, Boolean> test,
                                       Function1<CustomerFilter, B> func) {
        ArrayList<B> outlist = new ArrayList<>();
        for(CustomerFilter customer:CustomerFilter.filter(test)) {
            outlist.add(func.call(customer));
        }
        return outlist;
    }

    // getCustomerById using filter
    public static ArrayList<CustomerFilter> getCustomerById(final Integer customerIdIn) {
        return CustomerFilter.filter(new Function1<CustomerFilter, Boolean>() {
           public Boolean call(CustomerFilter customer) {
               return customer.id.equals(customerIdIn);
           }
        });
    }

    // get customerId purified calling purified filter
    // now they can chain inlist
    public static ArrayList<CustomerFilter> getCustomerById(ArrayList<CustomerFilter> inlist,
                                                            final Integer customerIdIn) {
        return CustomerFilter.filter(inlist, new Function1<CustomerFilter, Boolean>() {
            public Boolean call(CustomerFilter customer) {
                return customer.id == customerIdIn;
            }
        });
    }

    public static void setContractEnabledForCustomer(Integer customer_id) {
        for(CustomerFilter customer : CustomerFilter.getCustomerById(CustomerFilter.allCustomers,
                customer_id)) {
            customer.contract.enabled = true;
        }
    }
}
