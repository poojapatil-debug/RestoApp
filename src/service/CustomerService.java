package service;


import model.Customer;
import exception.*;

import java.util.HashMap;

public class CustomerService {

    private HashMap<Integer, Customer> customerMap = new HashMap<>();

    public void addCustomer(Customer c) throws DuplicateEntryException {
        if (customerMap.containsKey(c.getId())) {
            throw new DuplicateEntryException("Customer ID already exists!");
        }
        customerMap.put(c.getId(), c);
    }

    public HashMap<Integer, Customer> getAllCustomers() {
        return customerMap;
    }

    public void updateCustomer(int id, String name, String phone) throws ResourceNotFoundException {
        Customer c = customerMap.get(id);
        if (c == null) throw new ResourceNotFoundException("Customer not found!");

        c.setName(name);
        c.setPhone(phone);
    }

    public void deleteCustomer(int id) throws ResourceNotFoundException {
        if (customerMap.remove(id) == null)
            throw new ResourceNotFoundException("Customer not found!");
    }
}
