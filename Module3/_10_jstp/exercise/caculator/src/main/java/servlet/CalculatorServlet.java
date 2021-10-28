package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/cal")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double numberOne = Double.parseDouble(request.getParameter("firtopera"));
        double numberTwo = Double.parseDouble(request.getParameter("secondopera"));
        String calculator = request.getParameter("operator");
        double result= 0;
        if(calculator.equals("+")){
            result = (numberOne + numberTwo);
        } else if(calculator.equals("-")){
            result = (numberOne - numberTwo);
        }else if(calculator.equals("*")){
            result = (numberOne * numberTwo);
        }else if(calculator.equals("/")){
            result = (numberOne / numberTwo);
        }
        request.setAttribute("result",String.valueOf(result));
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
