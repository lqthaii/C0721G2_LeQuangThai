package service.Impl.customer;

import model.Customer;
import repository.ICustomerRepository;
import repository.Impl.customer.CustomerRepository;
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
        return this.customerRepository.getCustomer(id);
    }

    @Override
    public void addCusomer(Customer customer) {
        this.customerRepository.addCusomer(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        this.customerRepository.deleteCustomer(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        this.customerRepository.updateCustomer(customer);
    }
}
