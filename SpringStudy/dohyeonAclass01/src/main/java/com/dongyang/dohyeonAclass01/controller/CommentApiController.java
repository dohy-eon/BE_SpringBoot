package com.dongyang.dohyeonAclass01.controller;

import com.dongyang.dohyeonAclass01.repository.CommentRepository;
import com.dongyang.dohyeonAclass01.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;

}