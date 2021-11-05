package service.Impl.service;

import model.Service;
import repository.IServiceRepository;
import repository.Impl.service.ServiceRepository;
import service.IServiceService;

public class ServiceService implements IServiceService {
    IServiceRepository serviceRepository = new ServiceRepository();
    @Override
    public void addService(Service service) {
        this.serviceRepository.addService(service);
    }
}
