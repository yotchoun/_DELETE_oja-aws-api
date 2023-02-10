package com.mafoya.oja.service;

import com.mafoya.oja.model.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    Blog create(String authorization, Blog blog);

    Blog update(String authorization, Blog blog, String id);

    Optional<Blog> getById(String authorization, String id);

    List<Blog> getAll(String authorization);

    void delete(String authorization, String id);
}
