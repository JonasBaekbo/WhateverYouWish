package com.example.whateveryouwish;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@Controller
public class MainController {

    DB db = new DB();

    ListOfWish list = new ListOfWish();

    @GetMapping("/")
    public String index(Model m) {
        m.addAttribute("title", "Forside");
        return "index";
    }

    @GetMapping("/make-a-wish")
    public String makeAWish(HttpServletRequest request, Model model) {
        int userID = db.getUserIdForRequest(request);
        ArrayList<Wish> wishList = db.getWishListForUser(userID);
        model.addAttribute("wishList", wishList);
        return "make-a-wish";
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

    @PostMapping("/make-a-wish")
    public String createWish( @RequestParam("itemName") String itemName, @RequestParam("description") String description,
                             @RequestParam("quantity")int quantity, HttpServletRequest request) {
        int userID = db.getUserIdForRequest(request);
        list.addwish(itemName, description, quantity, userID);
        return "redirect:/make-a-wish";
    }

    @GetMapping("/please-try-again")
    public String pleasTryAgain(){
        return "please-try-again";
    }


}

