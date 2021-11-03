package service.Impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.Impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> getAllCustomer() {
        return this.customerRepository.getAllCustomer();
    }

    @Override
    public Customer getCustomer(String id) {
        return null;
    }
}
