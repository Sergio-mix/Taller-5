package edu.unbosque.Taller_5.servlets.ServletsLibrary;

import edu.unbosque.Taller_5.services.LibraryService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Modify Library Servlet
 */
@WebServlet(name = "modifyLibraryServlet", value = "/modify-library")
public class ModifyLibraryServlet extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String name = request.getParameter("name");
        Integer libraryId = Integer.parseInt(request.getParameter("libraryId"));

        LibraryService libraryService = new LibraryService();
        libraryService.modifyLibrary(libraryId,name);

        response.sendRedirect("./library.jsp");
    }

}
