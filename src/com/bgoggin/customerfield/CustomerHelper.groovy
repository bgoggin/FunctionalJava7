import com.bgoggin.customerfield.Customer

def getCustomerById(Integer customerId) {
    Customer.allCustomers.findAll({customer->customer.id == customerId})
}

print(this.getCustomerById(1))