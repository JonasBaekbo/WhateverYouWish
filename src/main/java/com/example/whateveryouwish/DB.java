package com.example.whateveryouwish;

import java.io.File;
import java.sql.*;
import java.util.Scanner;

public class DB {
    static Statement stmt;
    static ResultSet rs;
    static String sqlString;
    static Connection con;


    public static void connectDB() {
        try {
            String url = "jdbc:mysql://whateveryouwishdb.mysql.database.azure.com/whateveryouwishdb";
            con = DriverManager.getConnection(url, "Themasterofall@whateveryouwishdb", "77tgbv77.");
            System.out.println("Ok, we have a connection.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}