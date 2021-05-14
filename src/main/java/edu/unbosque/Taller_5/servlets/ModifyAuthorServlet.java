package edu.unbosque.Taller_5.servlets;

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

        String name = request.getParameter("name");

        AuthorService authorService = new AuthorService();
        try {
            authorService.modifyAuthor(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        response.sendRedirect("./index.jsp");
    }

}