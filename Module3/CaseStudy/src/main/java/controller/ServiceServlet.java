package controller;

import model.*;
import service.IServiceService;
import service.ITypeRentService;
import service.ITypeServiceService;
import service.Impl.service.ServiceService;
import service.Impl.service.TypeRentService;
import service.Impl.service.TypeServiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    ITypeRentService typeRentService = new TypeRentService();
    ITypeServiceService typeServiceService = new TypeServiceService();
    IServiceService service = new ServiceService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TypeRent> typeRents = this.typeRentService.getAllTypeRent();
        List<TypeService> typeServices = this.typeServiceService.getAllTypeService();
        request.setAttribute("typeRents",typeRents);
        request.setAttribute("typeServices",typeServices);
        request.getRequestDispatcher("furama/create_service.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if (action == null) {
            action = "";
        }
        switch(action){
            case "create":
                createService(request,response);
                break;
            default:
        }
    }
    private void createService(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String area = request.getParameter("area");
        String numberFloors = request.getParameter("numberFloors");
        String maximumPeople = request.getParameter("maximumPeople");
        String status = request.getParameter("status");
        String priceType = request.getParameter("priceType");
        TypeRent typeRent = this.typeRentService.getTypeRent(request.getParameter("typeRent"));
        TypeService typeService = this.typeServiceService.getTypeService(request.getParameter("typeService"));
        Service service = new Service(id,area,numberFloors,maximumPeople,priceType,typeRent,typeService,status);
        this.service.addService(service);
        try {
            response.sendRedirect("index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}