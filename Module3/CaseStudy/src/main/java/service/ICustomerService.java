package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> getAllCustomer();
    public Customer getCustomer(String id);
}
