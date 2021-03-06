package com.example.whateveryouwish.db;

import com.example.whateveryouwish.functions.Wish;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.*;
import java.util.ArrayList;

public class DB {
    private static Connection con;

    public DB() {
        connectDB();
    }

    public static Connection connectDB() {

        try {
            String url = "jdbc:mysql://whateveryouwishdb.mysql.database.azure.com:3306/whateveryouwishdb";
            con = DriverManager.getConnection(url, "Themasterofall@whateveryouwishdb", "77tgbv77.");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    public int getUserIdFromName(String userName) {
        connectDB();
        try {
            String searchForUser = "SELECT user_id FROM whateveryouwishdb.users WHERE `username` = ?";
            PreparedStatement stmt = con.prepareStatement(searchForUser);
            stmt.setString(1, userName);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();
            rs.next();
            int userID = rs.getInt(1);
            return userID;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void addUserToDB(String username, String password) {
        connectDB();
        System.out.println("addUserToDB");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = password;
        String encodedPassword = encoder.encode(rawPassword);
        try {
            String insert = "INSERT INTO whateveryouwishdb.users (`username`, `password`, `role`, `enabled`) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(insert);
            stmt.setString(1, username);
            stmt.setString(2, encodedPassword);
            stmt.setString(3, "ROLE_USER");
            stmt.setInt(4, 1);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeWish(String itemName, String description, int quantity, int userID) {
        Wish wish = new Wish(itemName, description, quantity, userID);
        addWishToDB(wish);
    }

    public void addWishToDB(Wish wish) {
        try {
            String insert = "INSERT INTO whateveryouwishdb.wish (`user_id`, `name`, `description`, `quantity`) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(insert);
            stmt.setInt(1, wish.getUserId());
            stmt.setString(2, wish.getItemName());
            stmt.setString(3, wish.getDescription());
            stmt.setInt(4, wish.getQuantity());
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean hasUserNameAllReady(String user) {
        connectDB();
        try {
            String searchForUser = "SELECT COUNT(*) FROM whateveryouwishdb.users WHERE `username` = ?";
            PreparedStatement stmt = con.prepareStatement(searchForUser);
            stmt.setString(1, user);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();
            rs.next();
            int numUsers = rs.getInt(1);

            return numUsers != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Wish> getWishListForUser(int currentUserID) {
        ArrayList<Wish> wishList = new ArrayList<>();

        try {
            String select = "SELECT * FROM whateveryouwishdb.wish, whateveryouwishdb.users WHERE whateveryouwishdb.wish.user_id = whateveryouwishdb.users.user_id AND whateveryouwishdb.wish.user_id = ?";
            PreparedStatement stmt = con.prepareStatement(select);
            stmt.setInt(1, currentUserID);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                String itemName = rs.getString("name");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                int userID = rs.getInt("user_id");
                int wishID = rs.getInt("id_wish");

                Wish wish = new Wish(wishID, itemName, description, quantity, userID);
                wishList.add(wish);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return wishList;
    }

    public void removeWish(String wishID) {
        connectDB();
        try {
            String removeWishID = "DELETE FROM whateveryouwishdb.wish WHERE `id_wish` = ?";
            PreparedStatement stmt = con.prepareStatement(removeWishID);
            stmt.setString(1, wishID);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}