package controller;

import model.Product;
import service.IProductService;
import service.Impl.ProductServiceImpl;
import sun.rmi.server.Dispatcher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.beans.Customizer;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/products",""})
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
            case "edit":
                updateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditProduct(request,response);
                break;
            case "delete":
                showDeleteProduct(request,response);
                break;
            case "view":
                viewProduct(request,response);
                break;
            default:
                listProducts(request,response);
                break;
        }
    }
    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.findAll();
        request.setAttribute("productList", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void viewProduct(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        Product product = this.productService.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/view.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showEditProduct(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        Product product = this.productService.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher;
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        Product product = this.productService.findById(id);
        if(product!=null){
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            this.productService.update(id,product);
            request.setAttribute("product", product);
            request.setAttribute("messager","Product update successly!");
            dispatcher= request.getRequestDispatcher("product/edit.jsp");
        }else {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showDeleteProduct(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher;
        String id = request.getParameter("id");
        Product product = this.productService.findById(id);
        if(product!=null){
            request.setAttribute("product", product);
            dispatcher= request.getRequestDispatcher("product/delete.jsp");
        }else {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher;
        String id = request.getParameter("id");
        Product product = this.productService.findById(id);
        if(product!=null){
            this.productService.remove(id);
            request.setAttribute("product", product);
            try{
                response.sendRedirect("/products");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createProduct(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher;
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        Product product = new Product(id,name,price,description);
        this.productService.save(product);
        dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message", "Add Product success");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
