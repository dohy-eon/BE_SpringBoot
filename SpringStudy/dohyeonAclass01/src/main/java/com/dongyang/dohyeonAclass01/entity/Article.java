package com.dongyang.dohyeonAclass01.entity;

import jakarta.persistence.*;

@Entity
//@Table(name="users")
public class Article {
    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
    public Article() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(length=100)
    private String title;
    @Column(length=100)
    private String content;
}
