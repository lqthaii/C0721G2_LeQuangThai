package service.Impl.customer;

import model.TypeCustomer;
import repository.ICustomerTypeRepository;
import repository.Impl.customer.CustomerTypeRepository;
import service.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    ICustomerTypeRepository customerType = new CustomerTypeRepository();
    @Override
    public List<TypeCustomer> getAllCustomerType() {
        return customerType.getAllCustomerType();
    }

    @Override
    public TypeCustomer getTypeCustomer(String id) {
        return this.customerType.getTypeCustomer(id);
    }
}
