package controller;

import model.Employee;
import service.iemployee.IEmployeeService;
import service.Impl.employee.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        switch (action){
            case "delete":
                deleteEmployee(request,response);
                break;
            default:
                showEmployee(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void showEmployee(HttpServletRequest request, HttpServletResponse response){
        List<Employee> employees = this.employeeService.getAllEmployee();
        try {
            request.setAttribute("employeeList",employees);
            request.getRequestDispatcher("furama/list_employee.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        this.employeeService.deleteEmployee(id);
        showEmployee(request,response);
    }
}
