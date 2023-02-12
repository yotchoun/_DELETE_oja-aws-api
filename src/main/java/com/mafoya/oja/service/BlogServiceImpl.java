package com.mafoya.oja.service;

import com.mafoya.oja.dto.BlogDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Blog;
import com.mafoya.oja.model.Blog;
import com.mafoya.oja.repository.BlogRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public BlogDto getById(String authorization, String id) {
        BlogDto blogDto;
        Optional<Blog> blogOptional = blogRepository.findById(id);
        if (blogOptional.isPresent()) {
            blogDto = OjaMapper.mapBlogDto(blogOptional.get());
            return blogDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public BlogDto create(String authorization, BlogDto blogDto) {
        Blog blog = OjaMapper.mapBlogDo(blogDto);
        blogRepository.save(blog);
        return blogDto;
    }

    @Override
    public BlogDto update(String authorization, BlogDto blogDto, String id) {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        if (blogOptional.isPresent()) {
            Blog blog = OjaMapper.mapBlogDo(blogDto);
            blog.setId(id);
            blogRepository.save(blog);
            return blogDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<BlogDto> getAll(String authorization) {
        List<Blog> doList = (List<Blog>) blogRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        blogRepository.deleteById(id);
    }
}

