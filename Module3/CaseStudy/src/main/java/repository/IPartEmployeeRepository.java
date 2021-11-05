package repository;

import model.Part;
import model.Position;

import java.util.List;

public interface IPartEmployeeRepository {
    public List<Part> getAllPart();
    public Part getPartEmployee(int id);
}
