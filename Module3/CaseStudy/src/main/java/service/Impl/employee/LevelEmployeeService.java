package service.Impl.employee;

import model.Level;
import repository.ILevelEmployeeRepository;
import repository.Impl.employee.LevelEmployeeRepository;
import service.ILevelEmployeeService;

import java.util.List;

public class LevelEmployeeService implements ILevelEmployeeService {
    ILevelEmployeeRepository levelEmployeeRepository = new LevelEmployeeRepository();
    @Override
    public List<Level> getAllLevel() {
        return this.levelEmployeeRepository.getAllLevel();
    }

    @Override
    public Level getLevelEmployee(int id) {
        return this.levelEmployeeRepository.getLevelEmployee(id);
    }
}
