package edu.unbosque.Taller_5.servlets.ServletsAuthor;

import edu.unbosque.Taller_5.services.AuthorService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Modify Author Servlet
 */
@WebServlet(name = "modifyAuthorServlet", value = "/modify-author")
public class ModifyAuthorServlet extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

       Integer id = Integer.parseInt(request.getParameter("authorId"));
        String name = request.getParameter("name");
        String country = request.getParameter("country");

        AuthorService authorService = new AuthorService();
        authorService.modifyAuthor(id,name,country);

        response.sendRedirect("./index.jsp");
    }

}