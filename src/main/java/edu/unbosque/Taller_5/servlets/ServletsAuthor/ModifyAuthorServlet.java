package edu.unbosque.Taller_5.servlets.ServletsAuthor;

import edu.unbosque.Taller_5.services.AuthorService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "modifyAuthorServlet", value = "/modify-author")
public class ModifyAuthorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

       Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        AuthorService authorService = new AuthorService();
        authorService.modifyAuthor(id,name);

        response.sendRedirect("./index.jsp");
    }

}