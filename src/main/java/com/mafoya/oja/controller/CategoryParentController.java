package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.CategoryParent;
import com.mafoya.oja.service.CategoryParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CategoryParentController{

    @Autowired
    private CategoryParentService categoryParentService;

    @GetMapping("/categoryParents/all")
    public List<CategoryParent> findAll(@RequestHeader("authorization") String authorization) {
        return this.categoryParentService.getAll(authorization);
    }

    @GetMapping("/categoryParents/{id}")
    public Optional<CategoryParent> getCategoryParentById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.categoryParentService.getById(authorization, id);

    }

    @PostMapping("/categoryParents")
    public CategoryParent createCategoryParent(@RequestBody @Valid CategoryParent categoryParentDto, @RequestHeader("authorization") String authorization) {
        return this.categoryParentService.create(authorization, categoryParentDto);
    }

    @PutMapping("/categoryParents/{id}")
    public CategoryParent updateCategoryParent(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody CategoryParent categoryParent) {
        return this.categoryParentService.update(authorization, categoryParent, id);


    }

    @DeleteMapping("/categoryParents/{id}")
    public void deleteCategoryParent(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.categoryParentService.delete(authorization, id);
    }
}

