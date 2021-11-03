package controller;

import model.User;
import repository.Impl.UserRepository;
import service.Impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"","/users"})
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action ="";
        }
        switch (action){
            case "create":
                showCreateUser(request,response);
                break;
            case"view":
                showUser(request,response);
                break;
            case "sortbyname":
                sortByName(request,response);
                break;
            case "country":
                showFormSearch(request,response);
                break;
            default: showListUser(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action ="";
        }
        switch (action){
            case "create":
                createUser(request,response);
                break;
            case "country":
                searchCountry(request,response);
                break;
            default:
                break;
        }
    }
    private void showListUser(HttpServletRequest request, HttpServletResponse response){
        List<User> userList = userService.selectAllUsers();
        request.setAttribute("userList",userList);
        try {
            request.getRequestDispatcher("user/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showCreateUser(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("user/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createUser(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher requestDispatcher;
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id,name,email,country);
        try {
            this.userService.insertUser(user);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        requestDispatcher = request.getRequestDispatcher("user/create.jsp");
        request.setAttribute("messager","Add user success");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showUser(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        User user = this.userService.selectUser(id);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        request.setAttribute("userList",userList);
        try {
            request.getRequestDispatcher("user/view.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void sortByName(HttpServletRequest request, HttpServletResponse response){
        List<User> userList = userService.sortByName();
        request.setAttribute("userList",userList);
        try {
            request.getRequestDispatcher("user/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showFormSearch(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("user/country.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void searchCountry(HttpServletRequest request, HttpServletResponse response){
        String country = request.getParameter("country");
        List<User> userList = this.userService.searchUserCountry(country);
        request.setAttribute("userList",userList);
        try {
            request.getRequestDispatcher("user/view.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






















