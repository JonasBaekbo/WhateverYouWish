package com.example.whateveryouwish.controllers;

import com.example.whateveryouwish.functions.Wish;
import com.example.whateveryouwish.db.DB;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
public class MainController {

    DB db = new DB();


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Forside");
        return "index";
    }


    @GetMapping("/createuser")
    public String createUser(Model model) {
        model.addAttribute("title", "Opret bruger");
        return "createUser";
    }

    @PostMapping(value = "/createuser")
    public String createNewUser(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
        boolean testEmail = db.hasUserNameAllReady(username);
        if (!testEmail) {
            db.addUserToDB(username, password);
            return "redirect:/login";
        } else {
            model.addAttribute("UNError", true);
            return "createUser";
        }
    }

    @GetMapping("/make-a-wish")
    public String showWishlist(Authentication auth, Model model) {
        int userID = db.getUserIdFromName(auth.getName());
        ArrayList<Wish> wishList = db.getWishListForUser(userID);
        model.addAttribute("wishList", wishList);
        model.addAttribute("title", "Make A Wish!");
        return "make-a-wish";
    }

    @PostMapping("/make-a-wish")
    public String createWish(@RequestParam("itemName") String itemName, @RequestParam("description") String description,
                             @RequestParam("quantity") int quantity, Authentication auth) {
        int userID = db.getUserIdFromName(auth.getName());
        db.makeWish(itemName, description, quantity, userID);
        return "redirect:/make-a-wish";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("id") String wishID) {
        db.removeWish(wishID);
        return "redirect:/make-a-wish";
    }


    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
