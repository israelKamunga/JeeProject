package com.culinarysharing.culinarysharing.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    public static Connection getInstance(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/CulinarySharing";
            String user = "root";
            String password = "";

            Connection connection = DriverManager.getConnection(url,user,password);
            return connection;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
