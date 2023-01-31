package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.Brand;
import com.mafoya.oja.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/brands/all")
    public List<Brand> findAll(@RequestHeader("authorization") String authorization) {
        return this.brandService.getAll(authorization);
    }

    @GetMapping("/brands/{id}")
    public Optional<Brand> getBrandById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.brandService.getById(authorization, id);

    }

    @PostMapping("/brands")
    public Brand createBrand(@RequestBody @Valid Brand brandDto, @RequestHeader("authorization") String authorization) {
        return this.brandService.create(authorization, brandDto);
    }

    @PutMapping("/brands/{id}")
    public Brand updateBrand(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody Brand brand) {
        return this.brandService.update(authorization, brand, id);


    }

    @DeleteMapping("/brands/{id}")
    public void deleteBrand(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.brandService.delete(authorization, id);
    }
}
