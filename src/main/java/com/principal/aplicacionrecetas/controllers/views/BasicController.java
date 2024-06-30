package com.principal.aplicacionrecetas.controllers.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BasicController {

    
    @GetMapping("login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("home")
    public String home(Model model){
        return "home";
    }


    @GetMapping("admin")
    public String admin(Model model){
        return "admin";
    }


}
