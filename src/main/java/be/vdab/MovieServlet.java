package be.vdab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by jeansmits on 24/06/15.
 */
@WebServlet(urlPatterns = "/movie")
public class MovieServlet extends HttpServlet{
    private MovieRepository repository=new MovieRepository();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         List<Movie> movieList= repository.findAllMovies();

        req.setAttribute("filmLijst", movieList);

        req.getRequestDispatcher("/movie.jsp").forward(req,resp);
    }
}
