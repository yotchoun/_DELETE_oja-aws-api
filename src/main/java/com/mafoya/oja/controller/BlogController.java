package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.BlogDto;
import com.mafoya.oja.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs/all")
    public List<BlogDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.blogService.getAll(authorization);
    }

    @GetMapping("/blogs/{id}")
    public BlogDto getBlogById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.blogService.getById(authorization, id);

    }

    @PostMapping("/blogs")
    public BlogDto createBlog(@RequestBody @Valid BlogDto blogDto, @RequestHeader("authorization") String authorization) {
        return this.blogService.create(authorization, blogDto);
    }

    @PutMapping("/blogs/{id}")
    public BlogDto updateBlog(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody BlogDto blogDto) {
        return this.blogService.update(authorization, blogDto, id);


    }

    @DeleteMapping("/blogs/{id}")
    public void deleteBlog(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.blogService.delete(authorization, id);
    }
}

