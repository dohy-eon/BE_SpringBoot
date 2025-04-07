package com.dongyang.dohyeonAclass01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class SecondController {
    @GetMapping("random-quote")
    public String randomQuote(Model model) {
        String[] quotes = {
                "피할수 없으면 즐겨라 – 로버트 엘리엇",
                "산다는것 그것은 치열한 전투이다. - 로망로랑",
                "성공은 최종적인 것이 아니고, 실패는 치명적인 것이 아니다. 중요한 것은 계속해 나가는 용기이다. – 윈스턴 처칠",
                "직업에서 행복을 찾아라. 아니면 행복이 무엇인지 절대 모를 것이다 - 엘버트 허버드",
                "천 리 길도 한 걸음부터. – 노자"
        };

        Random random = new Random();
        int index = random.nextInt(quotes.length);
        String selectedQuote = quotes[index];

        model.addAttribute("quote", selectedQuote);
        return "quote";
    }
}