package com.dongyang.dohyeonAclass01.service;

import com.dongyang.dohyeonAclass01.dto.CommentDto;
import com.dongyang.dohyeonAclass01.entity.Article;
import com.dongyang.dohyeonAclass01.entity.Comment;
import com.dongyang.dohyeonAclass01.repository.ArticleRepository;
import com.dongyang.dohyeonAclass01.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    public CommentDto create(Long articleId, CommentDto dto){
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패" + "대상 게시글이 없습니다."));
        Comment comment = Comment.createComment(dto, article);
        Comment created = commentRepository.save(comment);
        return CommentDto.createCommentDto(created);
    }

}
