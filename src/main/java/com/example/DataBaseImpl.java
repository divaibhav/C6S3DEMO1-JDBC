package com.example;

import java.sql.Connection;

public class DataBaseImpl {
    public static void main(String[] args) {
        DatabaseOperations databaseOperations = new DatabaseOperations();

        Connection connection = databaseOperations.getDbConnection();
        if(connection != null){
            System.out.println("connection established");
        }
        else {
            System.out.println("connection failed");
        }
    }
}
