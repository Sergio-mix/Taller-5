package edu.unbosque.Taller_5.servlets.ServletsLibrary;

import edu.unbosque.Taller_5.services.LibraryService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create Library Servlet
 */
@WebServlet(name = "cretateLibraryServlet", value = "/create-library")
public class CreateLibraryServlet extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     */

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String name = request.getParameter("name");

        LibraryService libraryService = new LibraryService();
        libraryService.saveLibrary(name);

        response.sendRedirect("./library.jsp");
    }

}
