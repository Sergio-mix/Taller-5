package edu.unbosque.Taller_5.servlets.ServletsBooks;

import com.google.gson.Gson;
import edu.unbosque.Taller_5.services.AuthorService;
import edu.unbosque.Taller_5.services.BookService;
import edu.unbosque.Taller_5.servlets.pojos.AuthorPOJO;
import edu.unbosque.Taller_5.servlets.pojos.BookPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * List Books Servlet
 */
@WebServlet(name = "listBooksServlet", value = "/list-books")
public class ListBooksServlet extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        BookService bookService = new BookService();
        List<BookPOJO> books =  bookService.listBooks();

        String booksJsonString = new Gson().toJson(books);

        PrintWriter out = response.getWriter();
        out.print(booksJsonString);
        out.flush();

    }
}
