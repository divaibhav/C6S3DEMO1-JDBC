package com.example;

import java.sql.Connection;
import java.util.List;

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
        boolean result = databaseOperations.createTable();
        if(!result){
            System.out.println("table created");
        }else {
            System.out.println("table not created");
        }
        int noOfRowsAffected = databaseOperations.insertDataIntoTable(1010, "Suresh", "Indore", 45.0f);
        if(noOfRowsAffected == 1){
            System.out.println("data inserted");
        }else {
            System.out.println("data not inserted");
        }

        List<SalesPerson> allSalesPerson = databaseOperations.getAllSalesPerson();
        System.out.println(allSalesPerson);
    }
}
