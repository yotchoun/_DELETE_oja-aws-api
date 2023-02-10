package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.Category;
import com.mafoya.oja.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categorys/all")
    public List<Category> findAll(@RequestHeader("authorization") String authorization) {
        return this.categoryService.getAll(authorization);
    }

    @GetMapping("/categorys/{id}")
    public Optional<Category> getCategoryById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.categoryService.getById(authorization, id);

    }

    @PostMapping("/categorys")
    public Category createCategory(@RequestBody @Valid Category categoryDto, @RequestHeader("authorization") String authorization) {
        return this.categoryService.create(authorization, categoryDto);
    }

    @PutMapping("/categorys/{id}")
    public Category updateCategory(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody Category category) {
        return this.categoryService.update(authorization, category, id);


    }

    @DeleteMapping("/categorys/{id}")
    public void deleteCategory(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.categoryService.delete(authorization, id);
    }
}

