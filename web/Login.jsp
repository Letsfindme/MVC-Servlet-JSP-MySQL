<%--
  Created by IntelliJ IDEA.
  User: p096593
  Date: 21/09/2018
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login home page</title>

    <script>

        function validate(){
            var username = document.form.username.value;
            var password = document.form.password.value;

            if (username==null || username==""){
                alert("Please fill the username field!");
                return false;

            }else if(password==null || password==""){
                alert("Please fill the password field!");
                return false;
            }

        }

    </script>




</head>
<body>
    <div style="background-color:DodgerBlue;text-align:center"><h1>Login form in Java using MVC and MySQL </h1> </div>
    <br>
    <form style="background-color:DodgerBlue; width:320px; float: right;" name="form" action="LoginServlet" method="post" onsubmit="return validate()">

        <table align="center">
            <tr>
                <td>Username</td>
                <td><input type="text" name="usernameInput" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="passwordInput" /></td>
            </tr>
            <tr>
                <td>
                    <span style="background-color:DodgerBlue; color:red ; hight:100px; width:300px;">
                        <%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%>
                    </span>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Login"></input>
                    <input type="reset" value="Reset"></input>
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
