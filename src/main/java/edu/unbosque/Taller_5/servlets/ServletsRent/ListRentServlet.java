package edu.unbosque.Taller_5.servlets.ServletsRent;

import com.google.gson.Gson;
import edu.unbosque.Taller_5.jpa.entities.Rent;
import edu.unbosque.Taller_5.services.LibraryService;
import edu.unbosque.Taller_5.services.RentService;
import edu.unbosque.Taller_5.servlets.pojos.LibraryPOJO;
import edu.unbosque.Taller_5.servlets.pojos.RentPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listRentServlet", value = "/list-Rent")
public class ListRentServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        RentService rentService = new RentService();
        List<RentPOJO> rent =  rentService.listRent();

        String rentJsonString = new Gson().toJson(rent);

        PrintWriter out = response.getWriter();
        out.print(rentJsonString);
        out.flush();

    }
}
