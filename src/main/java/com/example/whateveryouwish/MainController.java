package com.example.whateveryouwish;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    DB db = new DB();

    ListOfWish list = new ListOfWish();

    @GetMapping("/")
    public String index(Model m) {
        m.addAttribute("title", "Forside");
        DB.connectDB();
        return "index";
    }

    @GetMapping("/make-a-wish")
    public String makeAWish(Model m) {
        m.addAttribute("title", "Make a wish!");
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
            return "make-a-wish";
        } else {
            return "please-try-again";
        }
    }

    @PostMapping("/make-a-wish")
    public String createWish(@RequestParam("itemName") String itemName, @RequestParam("description") String description,
                             @RequestParam("quantity") int quantity) {
        list.addwish(itemName, description, quantity);
        return "redirect:/make-a-wish";
    }



}

