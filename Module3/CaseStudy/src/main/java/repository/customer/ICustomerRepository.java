package repository.customer;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    public List<Customer> getAllCustomer();
    public Customer getCustomer(String id);
    public void addCusomer(Customer customer);
    public void deleteCustomer(int id);
    public void updateCustomer(Customer customer);
}
