package com.dongyang.dohyeonAclass01.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstApiController {
    @GetMapping("/api/hi")
    public String hello(){
        return "Hello! REST!";
    }
}