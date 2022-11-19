package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    //creating table
    public boolean createTable(){
        boolean response = false;
        //connection
        Connection connection = getDbConnection();
        try {
            //statement
            Statement statement = connection.createStatement();
            //sql
            String sql = "Create table if not exists salesperson(sales_id int, salesperson_name varchar(200), salesperson_city varchar(200), sales_commission float )";
            //execute sql
            response = statement.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return response;
    }

    //insert data
    public int insertDataIntoTable(int id, String name, String city, float rate){
        //connection
        //statement
        //use executeUpdate method
        int response = 0;
        Connection dbConnection = getDbConnection();
        try {
            Statement statement = dbConnection.createStatement();
            String sql = "INSERT INTO SALESPERSON VALUES(" + id + ",'" + name + "','" + city + "'," + rate + ")";
            response = statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return response;
    }
    //getting data from db
    public List<SalesPerson> getAllSalesPerson(){
        List<SalesPerson> list = new ArrayList<>();
        //connection
        Connection connection = getDbConnection();
        //statement
        try {
            Statement statement = connection.createStatement();
            String sql = "Select * from salesperson";
            ResultSet resultSet = statement.executeQuery(sql);
            //process result set by iterating
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String city = resultSet.getString(3);
                float rate = resultSet.getFloat(4);

                SalesPerson salesPerson = new SalesPerson(id, name, city, rate);
                //adding salesperson to list
                list.add(salesPerson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
