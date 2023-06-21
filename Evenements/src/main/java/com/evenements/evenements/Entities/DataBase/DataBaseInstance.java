package com.evenements.evenements.Entities.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseInstance {
    public static Connection getInstance(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String DataBaseUrl = "jdbc:mysql://localhost:3306/Evenments";
            String DataBaseUser = "root";
            String DataBasePassword = "";
            Connection connexion = DriverManager.getConnection(DataBaseUrl,DataBaseUser,DataBasePassword);
            return connexion;
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
