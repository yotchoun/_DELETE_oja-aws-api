package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.BrandDto;
import com.mafoya.oja.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/brands/all")
    public List<BrandDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.brandService.getAll(authorization);
    }

    @GetMapping("/brands/{id}")
    public BrandDto getBrandById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.brandService.getById(authorization, id);

    }

    @PostMapping("/brands")
    public BrandDto createBrand(@RequestBody @Valid BrandDto brandDto, @RequestHeader("authorization") String authorization) {
        return this.brandService.create(authorization, brandDto);
    }

    @PutMapping("/brands/{id}")
    public BrandDto updateBrand(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody BrandDto brandDto) {
        return this.brandService.update(authorization, brandDto, id);


    }

    @DeleteMapping("/brands/{id}")
    public void deleteBrand(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.brandService.delete(authorization, id);
    }
}
