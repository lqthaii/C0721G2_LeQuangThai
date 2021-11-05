package service;

import model.TypeCustomer;

import java.util.List;

public interface ICustomerTypeService {
    public List<TypeCustomer> getAllCustomerType();
    public TypeCustomer getTypeCustomer(String id);
}
