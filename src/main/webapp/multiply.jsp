<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="file.css" />
    <title></title>
</head>
<body>



 <% out.println("<table border='0'>");

    int n = Integer.parseInt(request.getParameter("n"));
    for(int x=1;x<=n;x++){
       out.println("<tr>");
       for (int y=1;y<=n;y++){
       out.println("<td>" + x * y + "</td>");
    }
    out.println("</tr>");
  }
out.println("</table>");
 %>

</body>
</html>
