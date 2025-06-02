package com.dongyang.dohyeonAclass01.dto;

import com.dongyang.dohyeonAclass01.entity.Article;
import com.dongyang.dohyeonAclass01.entity.Comment;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long id;
    private Long articleId;
    private String nickname;
    private String body;

    public static CommentDto createCommentDto(Comment comment){
        return new CommentDto(
                comment.getId(),
                comment.getArticle().getId(),
                comment.getNickname(),
                comment.getBody()
        );
    }
}