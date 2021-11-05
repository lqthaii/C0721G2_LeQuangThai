package service;

import model.Part;

import java.util.List;

public interface IPartEmployeeService {
    public List<Part> getAllPart();
    public Part getPartEmployee(int id);
}
