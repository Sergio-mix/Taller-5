package edu.unbosque.Taller_5.servlets.ServletsAuthor;

import com.google.gson.Gson;
import edu.unbosque.Taller_5.services.AuthorService;
import edu.unbosque.Taller_5.servlets.pojos.AuthorPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * List Author Servlet
 */
@WebServlet(name = "listAuthorsServlet", value = "/list-authors")
public class ListAuthorsServlet extends HttpServlet {
    /**
     * @param request
     * @param response
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        AuthorService authorService = new AuthorService();
        List<AuthorPOJO> authors =  authorService.listAuthors();

        String authorsJsonString = new Gson().toJson(authors);

        PrintWriter out = response.getWriter();
        out.print(authorsJsonString);
        out.flush();

    }

}
