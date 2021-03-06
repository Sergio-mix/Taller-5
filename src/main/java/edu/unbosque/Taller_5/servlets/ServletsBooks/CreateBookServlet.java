package edu.unbosque.Taller_5.servlets.ServletsBooks;

import edu.unbosque.Taller_5.services.BookService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create Book Servlet
 */
@WebServlet(name = "createBookServlet", value = "/create-book")
public class CreateBookServlet extends HttpServlet {
    /**
     * @param request
     * @param response
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");
        String genre = request.getParameter("genre");
        Integer authorId = Integer.parseInt(request.getParameter("authorId"));

        BookService bookService = new BookService();
        bookService.saveBook(title, isbn,genre, authorId);

        response.sendRedirect("./index.jsp");

    }

}
