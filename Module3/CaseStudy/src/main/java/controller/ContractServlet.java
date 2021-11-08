package controller;


import model.Contract;
import model.Customer;
import model.Employee;
import model.Service;
import service.IContractService;
import service.ICustomerService;
import service.IEmployeeService;
import service.IServiceService;
import service.Impl.contract.ContractService;
import service.Impl.customer.CustomerService;
import service.Impl.employee.EmployeeService;
import service.Impl.service.ServiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    IContractService contractService = new ContractService();
    ICustomerService customerService = new CustomerService();
    IEmployeeService employeeService = new EmployeeService();
    IServiceService serviceService = new ServiceService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreateContract(request, response);
                break;
            case "delete":
                deleteContract(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            default:
                showListContract(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContract(request, response);
                break;
            case "edit":

                break;
            default:

        }
    }

    private void showListContract(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contracts = this.contractService.getAllContract();
        request.setAttribute("contracts", contracts);
        try {
            request.getRequestDispatcher("furama/list_contract.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.contractService.deleteContract(id);
        showListContract(request, response);
    }

    private void showFormCreateContract(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = this.customerService.getAllCustomer();
        List<Employee> employees = this.employeeService.getAllEmployee();
        List<Service> services = this.serviceService.getAllService();
        request.setAttribute("customers", customers);
        request.setAttribute("employees", employees);
        request.setAttribute("services", services);
        try {
            request.getRequestDispatcher("furama/create_contract.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Employee employee = this.employeeService.getEmployee(request.getParameter("employee"));
        Customer customer = this.customerService.getCustomer(request.getParameter("customer"));
        Service service = this.serviceService.getService(request.getParameter("service"));
        String datecreateContract = request.getParameter("dateCreateContract");
        String dateEnd = request.getParameter("dateEnd");
        int deposits = Integer.parseInt(request.getParameter("deposits"));
        int totalMoney = Integer.parseInt(request.getParameter("totalMoney"));
        Contract contract = new Contract(id, employee, customer, service, datecreateContract, dateEnd, deposits, totalMoney);
        this.contractService.addContract(contract);
        showListContract(request, response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        Contract contract = this.contractService.getContract(request.getParameter("id"));
        List<Customer> customers = this.customerService.getAllCustomer();
        List<Employee> employees = this.employeeService.getAllEmployee();
        List<Service> services = this.serviceService.getAllService();
        request.setAttribute("contract", contract);
        request.setAttribute("customers", customers);
        request.setAttribute("employees", employees);
        request.setAttribute("services", services);
        try {
            request.getRequestDispatcher("furama/edit_contract.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}