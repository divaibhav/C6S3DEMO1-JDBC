package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseOperations {
    //define method for getting connection
    //define method for creating table

    //connection
    public Connection getDbConnection(){
        Connection connection = null;
        try {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/salesdata";
            String user = "root";
            String password = "root@123";
            //get the connection using DriverManager
            connection = DriverManager.getConnection(url, user, password);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return connection;
    }
}
