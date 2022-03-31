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
    public static void addUserToDB(String username, String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = password;
        String encodedPassword = encoder.encode(rawPassword);
        connectDB();
        try {
            stmt = con.createStatement();

            sqlString = "Insert INTO users" +
                    "(username, password, role, enabled) " + "VALUES ('" + username + "','" + encodedPassword + "','" + "ROLE_USER','1')";
            stmt.executeUpdate(sqlString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


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