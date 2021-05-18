package edu.unbosque.Taller_5.servlets.ServletsEdition;


import edu.unbosque.Taller_5.services.EditionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create Edition Servlet
 */
@WebServlet(name = "createEditionServlet", value = "/create-edition")
public class CreateEditionServlet extends HttpServlet {
    /**
     * @param request
     * @param response
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String description = request.getParameter("description");
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String release = request.getParameter("release");
        Date fecha = null;
        try {

            fecha = formatoDelTexto.parse(release);

        } catch (java.text.ParseException ex) {

            ex.printStackTrace();

        }

        Integer bookId = Integer.parseInt(request.getParameter("bookId"));
        EditionService editionService = new EditionService();
        editionService.saveEdition(description, fecha,bookId);

        response.sendRedirect("./edition.jsp");
    }

}
