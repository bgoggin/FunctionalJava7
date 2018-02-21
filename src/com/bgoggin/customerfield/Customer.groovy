package com.bgoggin.customerfield

class Customer {
    static public List<Customer> allCustomers = new ArrayList<>();
    public Integer id = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContact = "";
    public Boolean enabled = true;
    public Contract contract;
    public List<Contact> allContacts = new ArrayList<>();

    public Customer() {}

    public Customer setCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public Customer setState(String state) {
        this.state = state;
        return this;
    }

    public Customer setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public Customer setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Customer setContract(Contract contract) {
        this.contract = contract;
        return this;
    }

    static def EnabledCustomer = { customer -> customer.enabled == true }

    static def DisabledCustomer = { customer -> customer.enabled = false }

    public static List<String> getDisabledCustomerNames() {
        Customer.allCustomers.findAll(DisabledCustomer).collect({customer -> customer.name})
    }

    public static List<String> getEnabledCustomerStates() {
        Customer.allCustomers.findAll(EnabledCustomer).collect({customer -> customer.state})
    }

    public static List<String> getEntabledCustomerDomains() {
        Customer.allCustomers.findAll(EnabledCustomer).collect({customer -> customer.domain})
    }

    public static List<String> getEnabledCustomerSomeoneEmail(String someone) {
        Customer.allCustomers.findAll(EnabledCustomer).collect({customer -> someone + "@" + customer.domain})
    }

    public static ArrayList<Customer> getCustomerById(ArrayList<Customer> inList,
        final Integer customerId) {
        inList.findAll({customer -> customer.customerId == customerId})
    }

    public static void sendEnabledCustomersEmails(String msg) {
        Customer.eachEnabledContact({ contact -> contact.sendEmail(msg) })
    }

    public static void eachEnabledContact(Closure cls) {
        Customer.allCustomers.findAll { customer ->
            customer.enabled && customer.contract.enabled
        }.each { customer ->
            customer.contacts.each(cls)
        }
    }

}
