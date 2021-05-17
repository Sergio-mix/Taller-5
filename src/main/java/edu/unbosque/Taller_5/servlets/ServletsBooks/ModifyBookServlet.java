package edu.unbosque.Taller_5.servlets.ServletsBooks;

import edu.unbosque.Taller_5.services.AuthorService;
import edu.unbosque.Taller_5.services.BookService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "modifyBookServlet", value = "/modify-book")
public class ModifyBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        Integer bookId = Integer.parseInt(request.getParameter("bookId"));

        String titles = request.getParameter("title");
        String isbn = request.getParameter("isbn");
        String genre = request.getParameter("genre");

        BookService bookService= new BookService();
        bookService.modifyBook(bookId,titles,isbn,genre);

        response.sendRedirect("./book.jsp");
    }
}
