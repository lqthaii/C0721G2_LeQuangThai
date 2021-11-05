package service.Impl.service;

import model.TypeRent;
import model.TypeService;
import repository.ITypeServiceRepository;
import repository.Impl.service.TypeServiceRepository;
import service.ITypeRentService;
import service.ITypeServiceService;

import java.util.List;

public class TypeServiceService implements ITypeServiceService {
    ITypeServiceRepository typeServiceRepository = new TypeServiceRepository();

    @Override
    public List<TypeService> getAllTypeService() {
        return this.typeServiceRepository.getAllTypeService();
    }

    @Override
    public TypeService getTypeService(String id) {
        return this.typeServiceRepository.getTypeService(id);
    }
}
