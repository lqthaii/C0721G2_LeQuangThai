package repository.employee;

import model.Customer;
import model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    public List<Employee> getAllEmployee();
    public Employee getEmployee(String id);
    public void addEmployee(Employee employee);
    public void deleteEmployee(int id);
}
