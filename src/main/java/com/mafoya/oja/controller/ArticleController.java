package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.Article;
import com.mafoya.oja.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles/all")
    public List<Article> findAll(@RequestHeader("authorization") String authorization) {
        return this.articleService.getAll(authorization);
    }

    @GetMapping("/articles/{id}")
    public Optional<Article> getArticleById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.articleService.getById(authorization, id);

    }

    @PostMapping("/articles")
    public Article createArticle(@RequestBody @Valid Article articleDto, @RequestHeader("authorization") String authorization) {
        return this.articleService.create(authorization, articleDto);
    }

    @PutMapping("/articles/{id}")
    public Article updateArticle(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody Article article) {
        return this.articleService.update(authorization, article, id);


    }

    @DeleteMapping("/articles/{id}")
    public void deleteArticle(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.articleService.delete(authorization, id);
    }
}

