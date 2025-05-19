package com.dongyang.dohyeonAclass01.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
//@Table(name="users")
public class Article {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(length=100)
    private String title;
    @Column(length=100)
    private String content;

    public void patch(Article article){
        if(article.getTitle() != null)
            this.title = article.getTitle();
        if(article.getContent() != null)
            this.content = article.getContent();
    }
}
