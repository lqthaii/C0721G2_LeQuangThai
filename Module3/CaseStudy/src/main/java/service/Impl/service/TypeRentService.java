package service.Impl.service;

import model.TypeRent;
import repository.ITypeRentRepository;
import repository.Impl.service.TypeRentRepository;
import service.ITypeRentService;

import java.util.List;

public class TypeRentService implements ITypeRentService {
    ITypeRentRepository typeRentRepository = new TypeRentRepository();
    @Override
    public List<TypeRent> getAllTypeRent() {
        return this.typeRentRepository.getAllTypeRent();
    }

    @Override
    public TypeRent getTypeRent(String id) {
        return this.typeRentRepository.getTypeRent(id);
    }
}
