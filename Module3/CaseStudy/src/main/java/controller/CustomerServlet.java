package controller;

import model.Customer;
import model.TypeCustomer;
import service.ICustomerService;
import service.ICustomerTypeService;
import service.Impl.customer.CustomerService;
import service.Impl.customer.CustomerTypeService;
import validation.Validate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerService();
    ICustomerTypeService customerTypeService = new CustomerTypeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "edit":
                showFormEditCustomer(request, response);
                break;
            default:
                showListCustomer(request, response);
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
                createCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "search":
                searchCustomer(request,response);
                break;
            default:
                showListCustomer(request, response);
        }

    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = this.customerService.getAllCustomer();
        try {
            request.setAttribute("customerList", customers);
            request.getRequestDispatcher("furama/list_customer.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int flag = 0;
        String phoneError = null, emailError = null;
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String identityCard = request.getParameter("identity_card");
        String numberPhone = request.getParameter("number_phone");
        if(!Validate.validate(numberPhone,Validate.REGEX_PHONE)){
            phoneError = "Số điện thoại bạn nhập không đúng!";
            flag++;
        }
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        if(!Validate.validate(email,Validate.REGEX_EMAIL)){
            emailError = "Email bạn nhập không đúng!";
            flag++;
        }
        TypeCustomer typeCustomer = this.customerTypeService.getTypeCustomer(request.getParameter("typeCustomer"));
        Customer customer = new Customer(id, typeCustomer, name, birthday, identityCard, email, address, numberPhone);
        try {
        if(flag!=0){
            request.setAttribute("phoneError",phoneError);
            request.setAttribute("emailError",emailError);
            request.setAttribute("customer",customer);
            request.getRequestDispatcher("furama/createCustomer.jsp").forward(request,response);
        }else{
            String success = "Thêm thành công";
            this.customerService.addCusomer(customer);
            request.setAttribute("success", success);
            request.getRequestDispatcher("furama/createCustomer.jsp").forward(request,response);
        }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreateCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<TypeCustomer> typeCustomers = this.customerTypeService.getAllCustomerType();
        request.setAttribute("typeCustomer", typeCustomers);
        try {
            request.getRequestDispatcher("furama/createCustomer.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.customerService.deleteCustomer(id);
        showListCustomer(request, response);
    }

    private void showFormEditCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<TypeCustomer> typeCustomers = this.customerTypeService.getAllCustomerType();
        Customer customer = this.customerService.getCustomer(request.getParameter("id"));
        try {
            request.setAttribute("typeCustomer", typeCustomers);
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("furama/edit_customer.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String identityCard = request.getParameter("identity_card");
        String numberPhone = request.getParameter("number_phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        TypeCustomer typeCustomer = this.customerTypeService.getTypeCustomer(request.getParameter("typeCustomer"));
        Customer customer = new Customer(id, typeCustomer, name, birthday, identityCard, email, address, numberPhone);
        this.customerService.updateCustomer(customer);
        showListCustomer(request, response);
    }
    private void searchCustomer(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("search");
        List <Customer> customers = this.customerService.searchCustomer(name);
        request.setAttribute("customerList",customers);
        try {
            request.getRequestDispatcher("furama/list_customer.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
