package edu.unbosque.Taller_5.servlets;

import edu.unbosque.Taller_5.services.AuthorService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "modifyBookServlet", value = "/modify-book")
public class ModifyBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer authorId = Integer.parseInt(request.getParameter("authorId"));

        AuthorService authorService = new AuthorService();
        authorService.deleteAuthor(authorId);

        response.sendRedirect("./index.jsp");
    }
}
