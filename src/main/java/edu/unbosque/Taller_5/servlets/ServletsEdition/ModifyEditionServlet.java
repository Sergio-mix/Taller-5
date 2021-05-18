package edu.unbosque.Taller_5.servlets.ServletsEdition;

import edu.unbosque.Taller_5.services.CustomerService;
import edu.unbosque.Taller_5.services.EditionService;

import javax.mail.internet.ParseException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Modify Edition Servlet
 */
@WebServlet(name = "modifyEditionServlet", value = "/modify-edition")
public class ModifyEditionServlet extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer id = Integer.parseInt(request.getParameter("editionId"));
        String description = request.getParameter("description");

        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String release = request.getParameter("release");
        Date fecha=null;
        try {

            fecha = formatoDelTexto.parse(release);

        } catch (java.text.ParseException ex) {

            ex.printStackTrace();

        }


        EditionService editionService = new EditionService();
        editionService.modifyEdition(id,description, fecha);

        response.sendRedirect("./edition.jsp");
    }
}
