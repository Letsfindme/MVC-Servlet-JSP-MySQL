package com.mvc.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mvc.bean.LoginBean;
import com.mvc.util.DBConnection;
import com.mysql.jdbc.Connection;


public class LoginDao {


    public String authenticateUser(LoginBean loginBeanInput) {

        String userNameInput = loginBeanInput.getUserName(); //Keeping user entered values in temporary variables.
        String passwordInput = loginBeanInput.getPassword();

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String userNameDB = "";
        String passwordDB = "";

        try {
            con = DBConnection.createConnection(); //establishing connection
            statement = con.createStatement(); //Statement is used to write queries.
            resultSet = statement.executeQuery("SELECT userName,password FROM hello.usres");


            // Until next row is present otherwise it return false
            while (resultSet.next()){

                userNameDB = resultSet.getString("userName"); //fais attention c'est les valeurs du DB
                passwordDB = resultSet.getString("password");

                if (userNameInput.equals(userNameDB) && passwordInput.equals(passwordDB)) {
                    return "SUCCESS";
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("Invalid user credentials");
        return "Invalid user credentials";

    }
}