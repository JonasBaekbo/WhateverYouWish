package com.example.whateveryouwish;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/test")
    public String test(Model m){

        return "test";
    }
    @GetMapping("/make-a-wish")
    public String makeawish(){
        return "make-a-wish";
    }
}