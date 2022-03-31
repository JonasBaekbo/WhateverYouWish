package com.example.whateveryouwish;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import java.util.ArrayList;


@Controller
public class MainController {
    ListOfWish l = new ListOfWish();
    User u = new User("", "");
    ListOfUser listOfUser = new ListOfUser();
    @GetMapping("/")
    public String index(Model m){
        m.addAttribute("title","Forside");
        DB.connectDB();
        return "index";
    }

    @GetMapping("/make-a-wish")
    public String makeawish(Model m){
        m.addAttribute("title","Make a wish!");
        return "make-a-wish";
    }
    @GetMapping("/createuser")
    public String createuser(){
        return "createuser";
    }
    @PostMapping(value = "/createuser")
    public String createNewUser(@RequestParam("username") String username, @RequestParam("password") String password){
        listOfUser.addUser(username, password);
        System.out.println(listOfUser.toString());
        return "login";
    }
    @PostMapping("/make-a-wish")
    public String createwish(@RequestParam("itemName") String itemName,@RequestParam("description") String description,
                             @RequestParam("quantity") int quantity){
        l.addwish(itemName,description,quantity);
        System.out.println(l.toString());
        return "redirect:/make-a-wish";
    }

}

