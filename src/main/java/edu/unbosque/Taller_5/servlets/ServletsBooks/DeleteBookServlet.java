package edu.unbosque.Taller_5.servlets.ServletsBooks;

import edu.unbosque.Taller_5.services.AuthorService;
import edu.unbosque.Taller_5.services.BookService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Delete Book Servlet
 */
@WebServlet(name = "deleteBookServlet", value = "/delete-book")
public class DeleteBookServlet extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer bookId = Integer.parseInt(request.getParameter("bookId"));


        BookService bookService = new BookService();
        bookService.deleteBook(bookId);

        response.sendRedirect("./book.jsp");
    }


}
