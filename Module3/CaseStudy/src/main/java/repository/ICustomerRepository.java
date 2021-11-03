package repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    public List<Customer> getAllCustomer();
    public Customer getCustomer(String id);
    public void addCusomer(Customer customer);
}
