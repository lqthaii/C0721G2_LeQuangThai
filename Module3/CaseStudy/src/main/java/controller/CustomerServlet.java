package controller;

import model.Customer;
import service.ICustomerService;
import service.Impl.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                showListCustomer(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      createCustomer(request,response);
    }
    private void showListCustomer(HttpServletRequest request, HttpServletResponse response){
        List <Customer> customers = this.customerService.getAllCustomer();
        try {
            request.setAttribute("customerList",customers);
            request.getRequestDispatcher("furama/list_customer.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createCustomer(HttpServletRequest request, HttpServletResponse response){
        String action = request.getParameter("actionUser");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String identityCard = request.getParameter("identity_card");
        String numberPhone = request.getParameter("number_phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        request.setAttribute("messager","Thêm thành công");
        try {
            request.getRequestDispatcher("furama/list_customer.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
