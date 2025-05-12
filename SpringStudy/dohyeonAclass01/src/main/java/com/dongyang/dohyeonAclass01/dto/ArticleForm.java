package com.dongyang.dohyeonAclass01.dto;

import com.dongyang.dohyeonAclass01.entity.Article;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
