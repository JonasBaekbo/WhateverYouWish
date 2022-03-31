package com.example.whateveryouwish;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


@Controller
public class MainController {
    static Statement stmt;

    static ResultSet rs;

    static String sqlString;

    static Connection con;

    ListOfWish l = new ListOfWish();

    User u = new User("", "");


    @GetMapping("/")
    public String index(Model m) {
        m.addAttribute("title", "Forside");
        DB.connectDB();
        return "index";
    }

    @GetMapping("/make-a-wish")
    public String makeawish(Model m) {
        m.addAttribute("title", "Make a wish!");
        return "make-a-wish";
    }

    @GetMapping("/createuser")
    public String createuser() {
        return "createuser";
    }

    @PostMapping(value = "/createuser")
    public String createNewUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        DB.addUserToDB(username, password);
        return "login";
    }

    @PostMapping("/make-a-wish")
    public String createwish(@RequestParam("itemName") String itemName, @RequestParam("description") String description,
                             @RequestParam("quantity") int quantity) {
        l.addwish(itemName, description, quantity);
        return "redirect:/make-a-wish";
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
}

