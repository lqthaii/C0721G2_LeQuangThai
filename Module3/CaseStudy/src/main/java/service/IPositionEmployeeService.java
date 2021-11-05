package service;

import model.Position;

import java.util.List;

public interface IPositionEmployeeService {
    public List<Position> getAllPosition();
    public Position getPositionEmployee(int id);
}
