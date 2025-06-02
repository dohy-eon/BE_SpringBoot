package com.dongyang.dohyeonAclass01.repository;

import com.dongyang.dohyeonAclass01.entity.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    @Query(value = "SELECT * FROM comment WHERE article_id = :articleId", nativeQuery = true)
    List<Comment> findByArticleId(Long articleId);

    List<Comment> findByNickname(String nickname);

}
