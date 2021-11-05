package repository;

import model.Level;
import model.Position;

import java.util.List;

public interface ILevelEmployeeRepository {
    public List<Level> getAllLevel();
    public Level getLevelEmployee(int id);
}
