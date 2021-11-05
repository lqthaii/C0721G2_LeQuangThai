package repository;

import model.TypeRent;

import java.util.List;

public interface ITypeRentRepository {
    public List<TypeRent> getAllTypeRent();
    public TypeRent getTypeRent(String id);
}
