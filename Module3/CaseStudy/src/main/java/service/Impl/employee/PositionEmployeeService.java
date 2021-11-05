package service.Impl.employee;

import model.Position;
import repository.Impl.employee.PositionEmployeeRepository;
import repository.IPositionEmployeeRepository;
import service.IPositionEmployeeService;

import java.util.List;

public class PositionEmployeeService implements IPositionEmployeeService {
    IPositionEmployeeRepository positionEmployeeRepository = new PositionEmployeeRepository();
    @Override
    public List<Position> getAllPosition() {
        return this.positionEmployeeRepository.getAllPosition();
    }

    @Override
    public Position getPositionEmployee(int id) {
        return this.positionEmployeeRepository.getPositionEmployee(id);
    }
}
