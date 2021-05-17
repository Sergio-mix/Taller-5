package edu.unbosque.Taller_5.servlets.ServletsCustomer;

import edu.unbosque.Taller_5.services.CustomerService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "modifyCustomerServlet", value = "/modify-customer")
public class ModifyCustomerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");


        String email = request.getParameter("email");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String gender = request.getParameter("gender");
        Integer age = Integer.parseInt(request.getParameter("age"));

        CustomerService customerService = new CustomerService();
        customerService.modifyCustomer(email, first_name, last_name, gender, age);

        response.sendRedirect("./customer.jsp");
    }
}
