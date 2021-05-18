package edu.unbosque.Taller_5.servlets.ServletsCustomer;

import edu.unbosque.Taller_5.services.CustomerService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Delete Customer Servlet
 */
@WebServlet(name = "deleteCustomerServlet", value = "/delete-customer")
public class DeleteCustomerServlet extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String customerEmail = request.getParameter("email");

        CustomerService customerService = new CustomerService();
        customerService.deleteCustomer(customerEmail);

        response.sendRedirect("./customer.jsp");
    }
}
