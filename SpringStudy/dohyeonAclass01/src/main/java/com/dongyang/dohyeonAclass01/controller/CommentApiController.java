package com.dongyang.dohyeonAclass01.controller;

import com.dongyang.dohyeonAclass01.dto.CommentDto;
import com.dongyang.dohyeonAclass01.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<CommentDto> create(@PathVariable Long articleId, @RequestBody CommentDto dto){
        commentService.create(articleId, dto);
        return ResponseEntity.ok().body(dto);
    }

}