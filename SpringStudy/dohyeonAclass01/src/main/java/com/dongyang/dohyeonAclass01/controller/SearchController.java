package com.dongyang.dohyeonAclass01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {
    @GetMapping("/search")
    @ResponseBody
    public String mainSearch(@RequestParam("mainSearchKeyword") String searchKeyword){
        System.out.println("검색어 : "+searchKeyword);
        return "검색어: " + searchKeyword;
    }
}
