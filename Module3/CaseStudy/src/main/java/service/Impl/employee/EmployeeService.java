package service.Impl.employee;

import model.Employee;
import repository.employee.IEmployeeRepository;
import repository.Impl.employee.EmployeeRepository;
import service.iemployee.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> getAllEmployee() {
        return this.employeeRepository.getAllEmployee();
    }

    @Override
    public Employee getEmployee(String id) {
        return null;
    }

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(int id) {
        this.employeeRepository.deleteEmployee(id);
    }
}
