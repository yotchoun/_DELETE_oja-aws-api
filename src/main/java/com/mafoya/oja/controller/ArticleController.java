package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.ArticleDto;
import com.mafoya.oja.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles/all")
    public List<ArticleDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.articleService.getAll(authorization);
    }

    @GetMapping("/articles/{id}")
    public ArticleDto getArticleById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.articleService.getById(authorization, id);

    }

    @PostMapping("/articles")
    public ArticleDto createArticle(@RequestBody @Valid ArticleDto articleDto, @RequestHeader("authorization") String authorization) {
        return this.articleService.create(authorization, articleDto);
    }

    @PutMapping("/articles/{id}")
    public ArticleDto updateArticle(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody ArticleDto articleDto) {
        return this.articleService.update(authorization, articleDto, id);


    }

    @DeleteMapping("/articles/{id}")
    public void deleteArticle(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.articleService.delete(authorization, id);
    }
}

