package com.mafoya.oja.service;

import com.mafoya.oja.model.Blog;
import com.mafoya.oja.repository.BlogRepository;

import java.util.List;
import java.util.Optional;

public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog create(String authorization, Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog update(String authorization, Blog blog, String id) {
        return blogRepository.save(blog);
    }

    @Override
    public Optional<Blog> getById(String authorization, String id) {
        return blogRepository.findById(id);
    }

    @Override
    public List<Blog> getAll(String authorization) {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        blogRepository.deleteById(id);
    }
}

