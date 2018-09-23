package com.mvc.controller;


import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    public LoginServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userNameInput = request.getParameter("usernameInput");
        String passwordInput = request.getParameter("passwordInput");

        LoginBean loginBeanInput = new LoginBean(); // Bean classes are efficiently used to access user information wherever required in the application.

        loginBeanInput.setUserName(userNameInput);
        loginBeanInput.setPassword(passwordInput);

        LoginDao loginDao = new LoginDao();

        String userValidate = loginDao.authenticateUser(loginBeanInput);

        if(userValidate.equals("SUCCESS")){
            System.out.print("SUCCESSyes");
            request.setAttribute("userNameInput", userNameInput); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
            request.getRequestDispatcher("/Home.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
        }

        else{
            System.out.print("SUCCESSno");
            request.setAttribute("errMessage", userValidate); // Here the error message returned from function has been stored in a errMessage key.
            request.getRequestDispatcher("/Login.jsp").forward(request, response);//forwarding the request
        }
    }

}