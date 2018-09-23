<%--
  Created by IntelliJ IDEA.
  User: p096593
  Date: 21/09/2018
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>My Home Page</title>
  </head>
  <body>


  <center><h2>My Home Page</h2></center>

  Welcome <%=request.getAttribute("userName") %>

  <div style="text-align: right">
    <a href="LogoutServlet">Logout</a>
  </div>

  </body>

</html>
