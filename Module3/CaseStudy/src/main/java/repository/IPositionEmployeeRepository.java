package repository;

import model.Position;
import model.TypeCustomer;

import java.util.List;

public interface IPositionEmployeeRepository {
    public List<Position> getAllPosition();
    public Position getPositionEmployee(int id);
}
