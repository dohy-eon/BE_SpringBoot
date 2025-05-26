package com.dongyang.dohyeonAclass01.service;

import com.dongyang.dohyeonAclass01.dto.ArticleForm;
import com.dongyang.dohyeonAclass01.entity.Article;
import com.dongyang.dohyeonAclass01.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return (List<Article>) articleRepository.findAll();
    }

    public Article show(Long id){
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto){
        Article article = dto.toEntity();
        return articleRepository.save(article);
    }

    public Article delete(Long id){
        Article target = articleRepository.findById(id).orElse(null);
        if (target == null){
            return null;
        }
        articleRepository.delete(target);
        return target;
    }

    public Article update(Long id, ArticleForm dto){
        Article article = dto.toEntity();
        Article target = articleRepository.findById(id).orElse(null);
        if (target == null || id != target.getId()){
            return null;
        }
        target.patch(article);
        Article updated = articleRepository.save(target);
        return updated;

    }

}
