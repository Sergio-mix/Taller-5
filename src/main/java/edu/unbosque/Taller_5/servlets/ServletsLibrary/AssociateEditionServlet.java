package edu.unbosque.Taller_5.servlets.ServletsLibrary;

import edu.unbosque.Taller_5.services.LibraryService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "associateEditionServlet", value = "/Associate-edition")
public class AssociateEditionServlet  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        Integer libraryId = Integer.parseInt(request.getParameter("libraryId"));
        Integer  Id = Integer.parseInt(request.getParameter("name"));

        LibraryService libraryService = new LibraryService();
        libraryService.associate_edit(Id, libraryId);

        response.sendRedirect("./library.jsp");
    }
}
