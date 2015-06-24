package be.vdab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeansmits on 24/06/15.
 */
@WebServlet (urlPatterns = "/test")
public class SessionServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();


//        String name= req.getParameter("name");
//        List<String> names=(List<String>) session.getAttribute("names");
//        if(names==null){
//            names =  new ArrayList<>();
//        }
//        else {
//
//        }


        Integer count = (Integer) session.getAttribute("count");
        if (count != null){
            session.setAttribute("count", count +1);
        }
        else {
            session.setAttribute("count", 1);
        }

        resp.getWriter().print("sample " + count);
    }
}
