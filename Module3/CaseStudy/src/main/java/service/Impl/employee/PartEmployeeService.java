package service.Impl.employee;

import model.Part;
import repository.IPartEmployeeRepository;
import repository.Impl.employee.PartEmployeeRepository;
import service.IPartEmployeeService;

import java.util.List;

public class PartEmployeeService implements IPartEmployeeService {
    IPartEmployeeRepository partEmployeeRepository = new PartEmployeeRepository();
    @Override
    public List<Part> getAllPart() {
        return this.partEmployeeRepository.getAllPart();
    }

    @Override
    public Part getPartEmployee(int id) {
        return this.partEmployeeRepository.getPartEmployee(id);
    }
}
