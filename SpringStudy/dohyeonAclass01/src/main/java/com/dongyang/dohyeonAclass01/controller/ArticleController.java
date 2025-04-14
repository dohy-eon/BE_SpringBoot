package com.dongyang.dohyeonAclass01.controller;

import com.dongyang.dohyeonAclass01.dto.ArticleForm;
import com.dongyang.dohyeonAclass01.entity.Article;
import com.dongyang.dohyeonAclass01.repository.ArticleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    ArticleRepository articleRepository;
    
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "boards/new";
    }

    @PostMapping("/articles/new")
    public String newArticleForm(ArticleForm articleForm){
        Article article = articleForm.toEntity();

        return "boards/new";
    }
}
