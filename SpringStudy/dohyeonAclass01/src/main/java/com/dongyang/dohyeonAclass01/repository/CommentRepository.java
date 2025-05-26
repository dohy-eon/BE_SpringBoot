package com.dongyang.dohyeonAclass01.repository;

import com.dongyang.dohyeonAclass01.entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
