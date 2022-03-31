package com.example.whateveryouwish;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.*;

public class DB {
    private Statement stmt;
    private String sqlString;
    private static Connection con;

    public DB() {
       connectDB();
    }


   public static void connectDB() {
        try {
            String url = "jdbc:mysql://whateveryouwishdb.mysql.database.azure.com/whateveryouwishdb";
            con = DriverManager.getConnection(url, "Themasterofall@whateveryouwishdb", "77tgbv77.");
            System.out.println("Ok, we have a connection.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUserToDB(String username, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = password;
        String encodedPassword = encoder.encode(rawPassword);
        try {
            stmt = con.createStatement();

            sqlString = "Insert INTO whateveryouwishdb.users" +
                    "(username, password, role, enabled) " + "VALUES ('" + username + "','" + encodedPassword + "','" + "ROLE_USER','1')";
            stmt.executeUpdate(sqlString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addWishToDB(Wish wish) {
        try {
            stmt = con.createStatement();
            sqlString = "Insert INTO whateveryouwishdb.wish" +
                    "(id_list, name, description, quantity) VALUES ('" + 1 + "','" + wish.getItemName() + "','"
                    + wish.getDescription() + "','" + wish.getQuantity() + "')";
            stmt.executeUpdate(sqlString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean hasUserNameAllReady(String user) {
        try {
            String searchForUser = "SELECT COUNT(*) FROM whateveryouwishdb.users WHERE `username` = ?";
            PreparedStatement stmt = con.prepareStatement(searchForUser);
            stmt.setString(1, user);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();
            rs.next();
            int numEmail = rs.getInt(1);

            return numEmail != 0;
        } catch (SQLException e) {
            System.out.println("error in hasEmail-method");
            return false;
        }
    }

    public Connection getCon() {
        return con;
    }
}