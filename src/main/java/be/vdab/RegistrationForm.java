package be.vdab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jeansmits on 23/06/15.
 */


@WebServlet(urlPatterns = "/form")
public class RegistrationForm extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(CONTENT_TYPE);
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Hello World</title></head>");
        out.println("<body>");
        out.println("<h1>User Registration<h1>");
        out.println("<form action='form' method='post'> First name: <input type='text' name='firstName'/><br /> Last name: <input type='text' name='lastName'/> Leeftijd<input type='number' name='leeftijd'/><br /> <input type='submit' value='REGISTREER NU!'></form>");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(CONTENT_TYPE);
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head> <link rel=\"stylesheet\" type=\"text/css\" href=\"file.css\" /><title>Hello World</title></head>");
        out.println("<body>");
        out.println("Registratie <h1 text-color=green>GELUKT</h1><p>Welkom</p>");
        out.println(req.getParameter("firstName"));
        out.println(req.getParameter("lastName"));
        if (Integer.parseInt(req.getParameter("leeftijd")) < 18){
            out.println("u bent " + Integer.parseInt(req.getParameter("leeftijd")) + ". U moet 18 zijn voor u te registreren");
        }

    }


}
