<%@ page import="java.util.List" %>
<%@ page import="be.vdab.MovieRepository" %>
<%@ page import="be.vdab.Movie" %>
<%--
  Created by IntelliJ IDEA.
  User: jeansmits
  Date: 24/06/15
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<table border=2px>
    <%
        List<Movie> movies = (List<Movie>) request.getAttribute("filmLijst");

        for (Movie movie : movies) {
           out.println("<tr><td>" + movie.getTitle() + "</td><td>" + movie.getDirector() + "</td><td>" + movie.getYear() + "</td></tr>");
        }
    %>
</table>
</body>
</html>
