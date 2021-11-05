package service;

import model.Level;

import java.util.List;

public interface ILevelEmployeeService {
    public List<Level> getAllLevel();
    public Level getLevelEmployee(int id);
}
