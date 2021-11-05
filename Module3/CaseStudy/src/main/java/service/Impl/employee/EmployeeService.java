package service.Impl.employee;

import model.Employee;
import repository.IEmployeeRepository;
import repository.Impl.employee.EmployeeRepository;
import service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> getAllEmployee() {
        return this.employeeRepository.getAllEmployee();
    }

    @Override
    public Employee getEmployee(String id) {
        return this.employeeRepository.getEmployee(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        this.employeeRepository.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        this.employeeRepository.deleteEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        this.employeeRepository.updateEmployee(employee);
    }
}
