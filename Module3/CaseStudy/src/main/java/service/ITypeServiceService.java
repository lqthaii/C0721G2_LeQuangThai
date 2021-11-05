package service;

import model.TypeService;

import java.util.List;

public interface ITypeServiceService {
    public List<TypeService> getAllTypeService();
    public TypeService getTypeService(String id);
}
