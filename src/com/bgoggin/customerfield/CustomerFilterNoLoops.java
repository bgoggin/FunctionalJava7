package com.bgoggin.customerfield;

import java.util.ArrayList;
import java.util.List;

public class CustomerFilterNoLoops { // Name is just to avoid collision, really just Customer
    static public ArrayList<CustomerFilterNoLoops> allCustomers = new ArrayList<CustomerFilterNoLoops>();
    public Integer id = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContact = "";
    public String domain = "";
    public Boolean enabled = true;
    public Contract contract = new Contract(ContractUtil.parseDateString("2018=01-01"));



    public CustomerFilterNoLoops() {
    }

    // Get back CustomerFilters by some filtering method
    // not pure because refrences CustomerFilterNoLoops,
    // same as CustomerFilter, but remove many repetitious loops
    public static ArrayList<CustomerFilterNoLoops> filter(Function1<CustomerFilterNoLoops, Boolean> test) {
        ArrayList<CustomerFilterNoLoops> outlist = new ArrayList<>();
        for (CustomerFilterNoLoops customer : CustomerFilterNoLoops.allCustomers) {
            if (test.call(customer)) {
                outlist.add(customer);
            }
        }
        return outlist;
    }

    // pure version of filter
    public static ArrayList<CustomerFilterNoLoops> filter(ArrayList<CustomerFilterNoLoops> inList,
                                                          Function1<CustomerFilterNoLoops, Boolean> test) {
        ArrayList<CustomerFilterNoLoops> outList = new ArrayList<>();
        for (CustomerFilterNoLoops customer : inList) {
            if (test.call(customer)) {
                outList.add(customer);
            }
        }
        return outList;
    }

    // Get field from other classes using filter
    public static <B> List<B> getField(Function1<CustomerFilterNoLoops, Boolean> test,
                                       Function1<CustomerFilterNoLoops, B> func) {
        ArrayList<B> outlist = new ArrayList<>();
        for (CustomerFilterNoLoops customer : CustomerFilterNoLoops.filter(test)) {
            outlist.add(func.call(customer));
        }
        return outlist;
    }

    // getCustomerById using filter
    public static ArrayList<CustomerFilterNoLoops> getCustomerById(final Integer customerIdIn) {
        return CustomerFilterNoLoops.filter(new Function1<CustomerFilterNoLoops, Boolean>() {
            public Boolean call(CustomerFilterNoLoops customer) {
                return customer.id.equals(customerIdIn);
            }
        });
    }

    // get customerId purified calling purified filter
    // now they can chain inlist
    public static ArrayList<CustomerFilterNoLoops> getCustomerById(ArrayList<CustomerFilterNoLoops> inlist,
                                                                   final Integer customerIdIn) {
        return CustomerFilterNoLoops.filter(inlist, new Function1<CustomerFilterNoLoops, Boolean>() {
            public Boolean call(CustomerFilterNoLoops customer) {
                return customer.id == customerIdIn;
            }
        });
    }

    // Uses forEach instead of looping, but still modifies state, so has side effects
    public static void setContractEnabledForCustomer(Integer customerId) {
        CustomerFilterNoLoops.forEach(
                CustomerFilterNoLoops.getCustomerById(CustomerFilterNoLoops.allCustomers, customerId),
                new ForEach1<CustomerFilterNoLoops>() {
                    public void call(CustomerFilterNoLoops customer) {
                        customer.contract.enabled = true;
                    }
                }
        );
    }

    // Now only need one for each
    public static void forEach(ArrayList<CustomerFilterNoLoops> inlist,
                               ForEach1<CustomerFilterNoLoops> func) {
        for (CustomerFilterNoLoops customer : inlist) {
            func.call(customer);
        }
    }
}
