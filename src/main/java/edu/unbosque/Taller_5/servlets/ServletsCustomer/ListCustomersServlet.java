package edu.unbosque.Taller_5.servlets.ServletsCustomer;

import com.google.gson.Gson;
import edu.unbosque.Taller_5.services.CustomerService;
import edu.unbosque.Taller_5.services.LibraryService;
import edu.unbosque.Taller_5.servlets.pojos.CustomerPOJO;
import edu.unbosque.Taller_5.servlets.pojos.LibraryPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * List Customer Servlet
 */
@WebServlet(name = "listCustomerServlet", value = "/list-customer")
public class ListCustomersServlet extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        CustomerService customerService = new CustomerService();
        List<CustomerPOJO> customers = customerService.listCustomers();

        String customersJsonString = new Gson().toJson(customers);

        PrintWriter out = response.getWriter();
        out.print(customersJsonString);
        out.flush();

    }

}
