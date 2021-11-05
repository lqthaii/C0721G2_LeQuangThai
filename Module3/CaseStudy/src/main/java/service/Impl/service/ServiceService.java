package service.Impl.service;

import model.Service;
import repository.IServiceRepository;
import repository.Impl.service.ServiceRepository;
import service.IServiceService;

import java.util.List;

public class ServiceService implements IServiceService {
    IServiceRepository serviceRepository = new ServiceRepository();
    @Override
    public void addService(Service service) {
        this.serviceRepository.addService(service);
    }

    @Override
    public Service getService(String id) {
        return this.serviceRepository.getService(id);
    }

    @Override
    public List<Service> getAllService() {
        return this.serviceRepository.getAllService();
    }
}
