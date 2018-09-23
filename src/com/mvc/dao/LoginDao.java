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
            statement = con.createStatement(); //Statement is used to write queries. Read more about it.
            resultSet = statement.executeQuery("SELECT userName,password FROM hello.usres"); //Here table name is users and userNameInput,passwordInput are columns. fetching all the records and storing in a resultSet.

            while (resultSet.next()) // Until next row is present otherwise it return false
            {
                userNameDB = resultSet.getString("userNameInput"); //fetch the values present in database
                passwordDB = resultSet.getString("passwordInput");

                if (userNameInput.equals(userNameDB) && passwordInput.equals(passwordDB)) {
                    return "SUCCESS";
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("nooooooooooooooooooooooooooooooooooooooooo");
        return "Invalid user credentials";

    }
}