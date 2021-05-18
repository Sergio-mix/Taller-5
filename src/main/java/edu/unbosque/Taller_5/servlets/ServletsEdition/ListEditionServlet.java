package edu.unbosque.Taller_5.servlets.ServletsEdition;

import com.google.gson.Gson;
import edu.unbosque.Taller_5.services.EditionService;
import edu.unbosque.Taller_5.servlets.pojos.EditionPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * List Edition Servlet
 */
@WebServlet(name = "listEditionServlet", value = "/list-edition")
public class ListEditionServlet extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        EditionService customerEdition= new EditionService();
        List<EditionPOJO> editions = customerEdition.listEditions();

        String customersJsonString = new Gson().toJson(editions);

        PrintWriter out = response.getWriter();
        out.print(customersJsonString);
        out.flush();

    }

}
