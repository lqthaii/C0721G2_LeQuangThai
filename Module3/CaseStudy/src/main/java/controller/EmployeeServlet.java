package controller;

import model.*;
import model.Part;
import service.IEmployeeService;
import service.ILevelEmployeeService;
import service.IPartEmployeeService;
import service.IPositionEmployeeService;
import service.Impl.employee.EmployeeService;
import service.Impl.employee.LevelEmployeeService;
import service.Impl.employee.PartEmployeeService;
import service.Impl.employee.PositionEmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService employeeService = new EmployeeService();
    IPartEmployeeService partEmployeeService = new PartEmployeeService();
    ILevelEmployeeService levelEmployeeService = new LevelEmployeeService();
    IPositionEmployeeService positionEmployeeService = new PositionEmployeeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if(action==null){
            action ="";
        }
        switch (action){
            case "delete":
                deleteEmployee(request,response);
                break;
            case "create":
                showFormCreateEmployee(request,response);
            case "edit":
                showFormEditEmployee(request,response);
            default:
                showEmployee(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if(action==null){
            action ="";
        }
        switch (action){
            case "edit":
                editEmployee(request,response);
                break;
            case "create":
                createEmployee(request,response);
                break;
            case "search":
                searchEmployee(request,response);
                break;
        }
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
    private void showFormCreateEmployee(HttpServletRequest request, HttpServletResponse response){
        List<Level> levels = this.levelEmployeeService.getAllLevel();
        List<Part> parts = this.partEmployeeService.getAllPart();
        List<Position> positions = this.positionEmployeeService.getAllPosition();
        request.setAttribute("levels",levels);
        request.setAttribute("parts",parts);
        request.setAttribute("positions",positions);
        try {
            request.getRequestDispatcher("furama/createEmployee.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showFormEditEmployee(HttpServletRequest request, HttpServletResponse response){
        List<Level> levels = this.levelEmployeeService.getAllLevel();
        List<Part> parts = this.partEmployeeService.getAllPart();
        List<Position> positions = this.positionEmployeeService.getAllPosition();
        Employee employee = this.employeeService.getEmployee(request.getParameter("id"));
        request.setAttribute("levels",levels);
        request.setAttribute("parts",parts);
        request.setAttribute("positions",positions);
        request.setAttribute("employee",employee);
        try {
            request.getRequestDispatcher("furama/edit_employee.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void editEmployee(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String identityCard = request.getParameter("identity_card");
        String numberPhone = request.getParameter("number_phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        double salary = Double.valueOf(request.getParameter("salary"));
        Position position = this.positionEmployeeService.getPositionEmployee(Integer.parseInt(request.getParameter("position")));
        Part part = this.partEmployeeService.getPartEmployee(Integer.parseInt(request.getParameter("part")));
        Level level = this.levelEmployeeService.getLevelEmployee(Integer.parseInt(request.getParameter("level")));
        Employee employee = new Employee(id,name,position,level,part,birthday,identityCard,salary,numberPhone,email,address);
        this.employeeService.updateEmployee(employee);
        showEmployee(request,response);
    }
    private void createEmployee(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String identityCard = request.getParameter("identity_card");
        String numberPhone = request.getParameter("number_phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        double salary = Double.valueOf(request.getParameter("salary"));
        Position position = this.positionEmployeeService.getPositionEmployee(Integer.parseInt(request.getParameter("position")));
        Part part = this.partEmployeeService.getPartEmployee(Integer.parseInt(request.getParameter("part")));
        Level level = this.levelEmployeeService.getLevelEmployee(Integer.parseInt(request.getParameter("level")));
        Employee employee = new Employee(id,name,position,level,part,birthday,identityCard,salary,numberPhone,email,address);
        this.employeeService.addEmployee(employee);
        request.setAttribute("messager","Thêm thành công");
        showEmployee(request,response);
    }
    private void searchEmployee(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("search");
        List <Employee> employees = this.employeeService.searchEmployee(name);
        request.setAttribute("employeeList",employees);
        try {
            request.getRequestDispatcher("furama/list_employee.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
