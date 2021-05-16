package edu.unbosque.Taller_5.servlets;

import edu.unbosque.Taller_5.services.AuthorService;
import edu.unbosque.Taller_5.services.BookService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteBookServlet", value = "/delete-book")
public class DeleteBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer bookId = Integer.parseInt(request.getParameter("bookId"));


        BookService bookService = new BookService();
        bookService.deleteBook(bookId);

        response.sendRedirect("./book.jsp");
    }


}
