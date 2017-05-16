package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping(value = "/welcome")
    public String welcome(Model model){
        model.addAttribute("greeting", "Witaj w sklepie internetowym");
        model.addAttribute("tagline","Wyjatkowym i jedynym");

        return "welcome";
    }
}
