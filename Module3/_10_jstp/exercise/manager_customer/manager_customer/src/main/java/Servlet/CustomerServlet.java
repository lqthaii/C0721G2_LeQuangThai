package Servlet;

import Bean.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Nguyen Van A","1/1/1990","Da Nang"));
        customers.add(new Customer("Huynh Thi B","3/1/1990","Ha Noi"));
        customers.add(new Customer("Hoang Van C","6/1/1990","HCM"));
        customers.add(new Customer("Le Thi B","1/12/1997","Dak Lak"));
        customers.add(new Customer("Duong Thi D","14/12/1990","Gia Lai"));
        request.setAttribute("customerServlet",customers);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}}
