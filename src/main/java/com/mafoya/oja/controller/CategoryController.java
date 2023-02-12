package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.CategoryDto;
import com.mafoya.oja.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categorys/all")
    public List<CategoryDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.categoryService.getAll(authorization);
    }

    @GetMapping("/categorys/{id}")
    public CategoryDto getCategoryById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.categoryService.getById(authorization, id);

    }

    @PostMapping("/categorys")
    public CategoryDto createCategory(@RequestBody @Valid CategoryDto categoryDto, @RequestHeader("authorization") String authorization) {
        return this.categoryService.create(authorization, categoryDto);
    }

    @PutMapping("/categorys/{id}")
    public CategoryDto updateCategory(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody CategoryDto categoryDto) {
        return this.categoryService.update(authorization, categoryDto, id);


    }

    @DeleteMapping("/categorys/{id}")
    public void deleteCategory(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.categoryService.delete(authorization, id);
    }
}

