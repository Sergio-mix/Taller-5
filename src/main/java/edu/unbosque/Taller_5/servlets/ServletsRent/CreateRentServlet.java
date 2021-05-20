package edu.unbosque.Taller_5.servlets.ServletsRent;

import edu.unbosque.Taller_5.jpa.entities.Rent;
import edu.unbosque.Taller_5.services.LibraryService;
import edu.unbosque.Taller_5.services.RentService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "cretateRentServlet", value = "/create-Rent")
public class CreateRentServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String email = request.getParameter("email");

        String date = current_date();
        Integer edition_id = Integer.parseInt(request.getParameter("editionId"));
        RentService rentService = new RentService();
        rentService.saveRent(email, edition_id, date);

//        response.sendRedirect("./library.jsp");
    }
    public String current_date(){
        Date date= new Date();
        SimpleDateFormat f= new SimpleDateFormat("dd/MM/YYYY");
        return f.format(date);
    }
}
