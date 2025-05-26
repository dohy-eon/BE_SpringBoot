package com.dongyang.dohyeonAclass01.service;

import com.dongyang.dohyeonAclass01.dto.ArticleForm;
import com.dongyang.dohyeonAclass01.entity.Article;
import com.dongyang.dohyeonAclass01.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos){
        List<Article> articleList = new ArrayList<>();
        for (int i = 0; i<dtos.size(); i++){
            ArticleForm dto = dtos.get(i);
            Article article = dto.toEntity();
            articleList.add(article);
        }
//        for (int i = 0; i<articleList.size(); i++){
//            Article article = articleList.get(i);
//            articleRepository.save(article);
//        }
        articleRepository.saveAll(articleList);
        try {
            articleRepository.findById(-1L).orElseThrow();
        } catch (Exception e) {
            throw new IllegalArgumentException("결제 실패");
        }
        return articleList;

    }

}
