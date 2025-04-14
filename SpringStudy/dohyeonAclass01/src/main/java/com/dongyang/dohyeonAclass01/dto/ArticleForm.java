package com.dongyang.dohyeonAclass01.dto;

import com.dongyang.dohyeonAclass01.entity.Article;

public class ArticleForm {
    private String title;
    private String content;

    public Article ArticleForm() {
        return new Article(null, title, content);
    }

    @Override
    public String toString() {
        return "ArticleForm{" + "title=" + title + ", content=" + content + '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
