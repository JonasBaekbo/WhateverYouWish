package com.example.whateveryouwish.db;

import com.example.whateveryouwish.functions.Wish;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.sql.*;
import java.util.ArrayList;

public class DB {
    private static Connection con;

    public DB() {
        connectDB();
    }

    //https://www.geeksforgeeks.org/singleton-class-java/
    public static Connection connectDB() {
        if (con != null) {
            System.out.println("We reuse our connection");
            return con;
        }

        try {
            String url = "jdbc:mysql://whateveryouwishdb.mysql.database.azure.com/whateveryouwishdb";
            con = DriverManager.getConnection(url, "Themasterofall@whateveryouwishdb", "77tgbv77.");
            System.out.println("Ok, we have a connection.");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    public int getUserIdForName(String userName) {
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
            System.out.println("error in getUserIdForName-method");
            return 0;
        }
    }

    public void addUserToDB(String username, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = password;
        String encodedPassword = encoder.encode(rawPassword);
        try {
            String insert = "INSERT INTO whateveryouwishdb.users (username, password, role, enabled) VALUES (?, ?, ?, ?)";
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

    public void makeWish(String itemName, String description, int quantity,HttpServletRequest request){
        int userID = getUserIdFromRequest(request);
        Wish wish = new Wish(itemName,description,quantity,userID);
        addWishToDB(wish);
    }

    public void addWishToDB(Wish wish) {
        try {
            String insert = "INSERT INTO whateveryouwishdb.wish (user_id, name, description, quantity) VALUES (?, ?, ?, ?)";
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
            System.out.println("error in hasUser-method");
            return false;
        }
    }

    public ArrayList<Wish> getWishListForUser(HttpServletRequest request) {
        ArrayList<Wish> wishList = new ArrayList<>();
        int currentUserID = getUserIdFromRequest(request);

        try {
            String select = "select * from whateveryouwishdb.wish, whateveryouwishdb.users where whateveryouwishdb.wish.user_id = whateveryouwishdb.users.user_id and whateveryouwishdb.wish.user_id = ?";
            PreparedStatement stmt = con.prepareStatement(select);
            stmt.setInt(1, currentUserID);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                String itemName = rs.getString("name");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                int userID = rs.getInt("user_id");
                int wishID=rs.getInt("id_wish");

                Wish wish = new Wish(wishID,itemName, description, quantity, userID);
                wishList.add(wish);
            }
        } catch (Exception e) {
            System.out.println("something wen't wrong in getWishListForUser");

        }
        return wishList;
    }

    public int getUserIdFromRequest(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        String userName = principal.getName();
        int userID = getUserIdForName(userName);
        return userID;
    }

    public void removeWish(String wishID){
        try {
            String removeWishID = "DELETE FROM whateveryouwishdb.wish WHERE `id_wish` = ?";
            PreparedStatement stmt = con.prepareStatement(removeWishID);
            stmt.setString(1, wishID);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("error in removeWish-method");
        }
    }
}