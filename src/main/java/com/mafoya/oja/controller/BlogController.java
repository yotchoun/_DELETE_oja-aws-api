package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.Blog;
import com.mafoya.oja.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs/all")
    public List<Blog> findAll(@RequestHeader("authorization") String authorization) {
        return this.blogService.getAll(authorization);
    }

    @GetMapping("/blogs/{id}")
    public Optional<Blog> getBlogById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.blogService.getById(authorization, id);

    }

    @PostMapping("/blogs")
    public Blog createBlog(@RequestBody @Valid Blog blogDto, @RequestHeader("authorization") String authorization) {
        return this.blogService.create(authorization, blogDto);
    }

    @PutMapping("/blogs/{id}")
    public Blog updateBlog(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody Blog blog) {
        return this.blogService.update(authorization, blog, id);


    }

    @DeleteMapping("/blogs/{id}")
    public void deleteBlog(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.blogService.delete(authorization, id);
    }
}

