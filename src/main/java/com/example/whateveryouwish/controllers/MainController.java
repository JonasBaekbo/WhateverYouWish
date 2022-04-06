package com.example.whateveryouwish.controllers;

import com.example.whateveryouwish.functions.Wish;
import com.example.whateveryouwish.db.DB;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;


@Controller
public class MainController {

    DB db = new DB();


    @GetMapping("/")
    public String index(Model m) {
        m.addAttribute("title", "Forside");
        return "index";
    }


    @GetMapping("/createuser")
    public String createUser() {
        return "createUser";
    }

    @PostMapping(value = "/createuser")
    public String createNewUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        boolean testEmail = db.hasUserNameAllReady(username);
        if (!testEmail) {
            db.addUserToDB(username, password);
            return "redirect:/login";
        } else {
            return "redirect:/please-try-again";
        }
    }

    @GetMapping("/make-a-wish")
   public String showWishlist(Principal principal, Model model)
     {
       int userID= db.getUserIdFromRequest(principal.getName());
        ArrayList<Wish> wishList = db.getWishListForUser(userID);
        model.addAttribute("wishList", wishList);
        return "make-a-wish";
    }

    @PostMapping("/make-a-wish")
    public String createWish( @RequestParam("itemName") String itemName, @RequestParam("description") String description,
                             @RequestParam("quantity")int quantity, Principal principal) {
        int userID=db.getUserIdFromRequest(principal.getName());
        db.makeWish(itemName, description, quantity, userID);
        return "redirect:/make-a-wish";
    }
    @GetMapping("/remove")
    public String remove(@RequestParam("id") String wishID){
        db.removeWish(wishID);
        return "redirect:/make-a-wish";
    }

    @GetMapping("/please-try-again")
    public String pleaseTryAgain(){
        return "please-try-again";
    }
}