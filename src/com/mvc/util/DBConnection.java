package com.mvc.util;


import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection createConnection(){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/hello"; 
        String username = "root";
        String password = "root";


        try {

            Class.forName("com.mysql.jdbc.Driver"); //loading mysql driver
            con = (Connection) DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
            System.out.println("Printing connection object "+con);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }



        return con;
    }
}
