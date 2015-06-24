package be.vdab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeansmits on 24/06/15.
 */
@WebServlet(urlPatterns = "/productsession")
public class ProductSessionServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>shopping</title></head>");
        out.println("<body>");
        out.println("<h1>product kopen</h1>");
        out.println("<form action='productsession' method='post'> product: <input type='text' name='product'/><br /> prijs: <input type='text' name='prijs'/><br /> Aantal: <input type='number' name='aantal'/><br /> <input type='submit' value='Voegt toe aan bestelmand?!'></form>");
        out.println("</body>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head> <title>Controle bestelling</title></head>");
        out.println("<body>");
        out.println("<p>Controle bestelling</p>");

        List<OrderItem> order = addOrderItem(req);
        displayOrders(out, order);


//        if (Integer.parseInt(req.getParameter("leeftijd")) < 18){
//            out.println("u bent " + Integer.parseInt(req.getParameter("leeftijd")) + ". U moet 18 zijn voor u te registreren");
//        }

    }

    private List<OrderItem> addOrderItem(HttpServletRequest req) {
        HttpSession session = req.getSession();
        List<OrderItem> order = (List<OrderItem>) session.getAttribute("order");
        if(order == null) {
            order = new ArrayList<>();
        }

        String product = req.getParameter("product");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        order.add(new OrderItem(product, quantity, price));

        session.setAttribute("order", order);



        return order;
    }

    private void displayOrders(PrintWriter writer, List<OrderItem> orderList) {
        writer.println("<table border='1'>");

        writer.println("<tr>");
        writer.println("<td>Product</td>");
        writer.println("<td>Price</td>");
        writer.println("<td>Quantity</td>");
        writer.println("<td>Total</td>");
        writer.println("</tr>");

        for (OrderItem orderItem : orderList) {
            writer.println("<tr>");
            writer.println("<td>" + orderItem.getProduct() + "</td>");
            writer.println("<td>" + orderItem.getPrijs() + "</td>");
            writer.println("<td>" + orderItem.getAantal() + "</td>");
            writer.println("<td>" + orderItem.getTotal() + "</td>");
            writer.println("</tr>");
        }

        writer.println("</table>");

        double total = 0;
        for (OrderItem orderItem : orderList) {
            total += orderItem.getPrijs();
        }
        writer.println("<div>Grand total: " + total + "</div>");
        writer.println("<a href='form.html'>More tea</a>");
    }


}

