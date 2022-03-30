package com.example.whateveryouwish;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {
    Wish w = new Wish(null,null,0,0);
    ListOfWish l = new ListOfWish();
    @GetMapping("/")
    public String index(Model m){
        m.addAttribute("title","Forside");
        return "index";
    }

    @GetMapping("/make-a-wish")
    public String makeawish(Model m){
        m.addAttribute("title","Make a wish!");
        return "make-a-wish";
    }

    @PostMapping("/make-a-wish")
    public String createwish(@RequestParam("itemName") String itemName,@RequestParam("description") String description,
                             @RequestParam("quantity") int quantity,@RequestParam("id") int id){
        l.addwish(itemName,description,quantity,id);
        return "redirect:/make-a-wish";
    }

}