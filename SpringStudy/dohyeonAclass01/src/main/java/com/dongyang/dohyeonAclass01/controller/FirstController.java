package com.dongyang.dohyeonAclass01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController   {
    @GetMapping("/hi")
    public String niceToMeet(Model mo) {
        mo.addAttribute("nameVar", "최도현");
        mo.addAttribute("ageVar", 12);
        return "greetings";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
}