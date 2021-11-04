package repository.customer;

import model.TypeCustomer;

import java.util.List;

public interface ICustomerTypeRepository {
    public List<TypeCustomer> getAllCustomerType();
    public TypeCustomer getTypeCustomer(String id);
}
