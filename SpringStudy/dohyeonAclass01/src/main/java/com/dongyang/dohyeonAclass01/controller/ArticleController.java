package com.dongyang.dohyeonAclass01.controller;

import com.dongyang.dohyeonAclass01.dto.ArticleForm;
import com.dongyang.dohyeonAclass01.dto.CommentDto;
import com.dongyang.dohyeonAclass01.entity.Article;
import com.dongyang.dohyeonAclass01.repository.ArticleRepository;
import com.dongyang.dohyeonAclass01.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    private CommentService commentService;

    //게시글 작성
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "boards/new";
    }

    //상세페이지
    @GetMapping("/articles/{id}")
    public String show(@PathVariable("id") Long id, Model mo){
        Article articleEntity=articleRepository.findById(id).orElse(null);
        mo.addAttribute("article",articleEntity);
        List<CommentDto> commentDtos = commentService.comments(id);
        mo.addAttribute("commentDtos", commentDtos);
        return "boards/show";
    }

    //수정
    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model mo){
        Article articleEntity=articleRepository.findById(id).orElse(null);
        mo.addAttribute("article",articleEntity);
        return "boards/edit";
    }

    //삭제
    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable("id") Long id, RedirectAttributes rttr){
        articleRepository.deleteById(id);
        rttr.addFlashAttribute("msg", "삭제되었습니다!"); //flash란 redirect되는 첫 페이지에서만 사용됨
        return "redirect:/articles/index";
    }

    //수정
    @PostMapping("/articles/update")
    public String update(@RequestParam("id") Long id, ArticleForm articleForm, Model mo){
        Article article = articleForm.toEntity();
        Article saved = articleRepository.save(article);
        return "redirect:/articles/"+saved.getId();
    }

    //전체 조회
    @GetMapping("/articles/index")
    public String index(Model mo){
        List<Article> articleEntityList = (List<Article>) articleRepository.findAll();
        mo.addAttribute("articles",articleEntityList);
        return "/boards/index";
    }

    @PostMapping("/articles/new")
    public String newArticleForm(ArticleForm articleForm){
        Article article = articleForm.toEntity();
        Article savedArticle = articleRepository.save(article);
        return "redirect:/articles/" + savedArticle.getId();
    }
}
