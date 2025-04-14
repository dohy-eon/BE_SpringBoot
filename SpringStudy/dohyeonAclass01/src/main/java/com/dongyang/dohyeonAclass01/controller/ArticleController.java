package com.dongyang.dohyeonAclass01.controller;

import com.dongyang.dohyeonAclass01.dto.ArticleForm;
import com.dongyang.dohyeonAclass01.entity.Article;
import com.dongyang.dohyeonAclass01.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "boards/new";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable("id") Long id){
        System.out.println("아이디 값 : "+id);
        ArticleForm articleForm = new ArticleForm();
        return "";
    }

    @PostMapping("/articles/new")
    public String newArticleForm(ArticleForm articleForm){
        Article article = articleForm.toEntity();
        Article savedArticle = articleRepository.save(article);
        return "redirect:/articles/" + savedArticle.getId();
    }
}
