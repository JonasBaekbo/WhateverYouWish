package com.example.whateveryouwish;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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



    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String rawPassword = "Parameter fra HTTP";
    String encodedPassword = encoder.encode(rawPassword);
    //sout(EncodedPassword);
    public void addWishToDB(Wish wish) {
        try {
            stmt = con.createStatement();
            sqlString = "Insert INTO wish" +
                "(id_list, name, description, quantity) VALUES ('" + 1 + "','" + wish.getItemName() + "','"
                + wish.getDescription()+"','" + wish.getQuantity()+"')";
            stmt.executeUpdate(sqlString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}