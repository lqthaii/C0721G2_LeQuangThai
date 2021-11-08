package service;

import model.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> getAllEmployee();
    public Employee getEmployee(String id);
    public void addEmployee(Employee employee);
    public void deleteEmployee(int id);
    public void updateEmployee(Employee employee);
    public List<Employee> searchEmployee(String name);
}