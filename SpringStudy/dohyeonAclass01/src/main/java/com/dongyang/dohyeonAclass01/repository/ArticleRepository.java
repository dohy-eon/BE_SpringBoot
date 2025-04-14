package com.dongyang.dohyeonAclass01.repository;

import com.dongyang.dohyeonAclass01.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}