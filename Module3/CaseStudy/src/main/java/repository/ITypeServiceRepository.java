package repository;

import model.TypeRent;
import model.TypeService;

import java.util.List;

public interface ITypeServiceRepository {
    public List<TypeService> getAllTypeService();
    public TypeService getTypeService(String id);
}
