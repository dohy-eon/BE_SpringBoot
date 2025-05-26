package com.dongyang.dohyeonAclass01.service;

import com.dongyang.dohyeonAclass01.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

}
