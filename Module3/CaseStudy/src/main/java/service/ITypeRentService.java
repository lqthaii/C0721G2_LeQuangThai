package service;

import model.TypeRent;

import java.util.List;

public interface ITypeRentService {
    public List<TypeRent> getAllTypeRent();
    public TypeRent getTypeRent(String id);
}
