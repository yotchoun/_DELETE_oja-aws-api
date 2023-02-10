package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.CategoryNavigationDto;
import com.mafoya.oja.model.CategoryNavigation;
import com.mafoya.oja.service.CategoryNavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CategoryNavigationController {

    @Autowired
    private CategoryNavigationService navigationService;

    @GetMapping("/categoryNavigations/all")
    public List<CategoryNavigation> findAll(@RequestHeader("authorization") String authorization) {
        return this.navigationService.getAll(authorization);
    }

    @GetMapping("/categoryNavigations/{id}")
    public Optional<CategoryNavigation> getCategoryNavigationById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.navigationService.getById(authorization, id);

    }

    @PostMapping("/categoryNavigations")
    public CategoryNavigation createCategoryNavigation(@RequestBody @Valid CategoryNavigationDto CategoryNavigationDto, @RequestHeader("authorization") String authorization) {
        return this.navigationService.create(authorization, CategoryNavigationDto);
    }

    @PutMapping("/categoryNavigations/{id}")
    public CategoryNavigation updateCategoryNavigation(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody CategoryNavigation CategoryNavigation) {
        return this.navigationService.update(authorization, CategoryNavigation, id);


    }

    @DeleteMapping("/CategoryNavigations/{id}")
    public void deleteCategoryNavigation(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.navigationService.delete(authorization, id);
    }
}
