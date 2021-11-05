package repository;

import model.Service;

import java.util.List;

public interface IServiceRepository {
    public void addService(Service service);
    public Service getService(String id);
    public List<Service> getAllService();
}
