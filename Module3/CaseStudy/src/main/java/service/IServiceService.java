package service;

import model.Service;

import java.util.List;

public interface IServiceService {
    public void addService(Service service);
    public Service getService(String id);
    public List<Service> getAllService();
}
