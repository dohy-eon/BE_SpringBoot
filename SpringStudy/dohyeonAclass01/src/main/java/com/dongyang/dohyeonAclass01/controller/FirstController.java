package com.dongyang.dohyeonAclass01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController   {
    @GetMapping("/hi")
    public String niceToMeet() {
        return "greetings";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
}