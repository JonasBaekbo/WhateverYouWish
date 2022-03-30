package com.example.whateveryouwish;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/make-a-wish")
    public String makeawish(){
        return "make-a-wish";
    }
    @GetMapping("/createuser")
    public String createuser(){
        return "createuser";
    }
    @PostMapping(value = "/createuser")
    @ResponseBody
    public String createNewUser(@RequestParam("username") String username, @RequestParam("password") String password){
        return "User created with name:" + username + " and password: " + password;
    }
    }

