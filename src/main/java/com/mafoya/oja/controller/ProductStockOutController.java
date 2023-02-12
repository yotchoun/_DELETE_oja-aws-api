package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.ProductStockOutDto;
import com.mafoya.oja.service.ProductStockOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ProductStockOutController {

    @Autowired
    private ProductStockOutService productStockOutService;

    @GetMapping("/productStockOuts/all")
    public List<ProductStockOutDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.productStockOutService.getAll(authorization);
    }

    @GetMapping("/productStockOuts/{id}")
    public ProductStockOutDto getProductStockOutById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.productStockOutService.getById(authorization, id);

    }

    @PostMapping("/productStockOuts")
    public ProductStockOutDto createProductStockOut(@RequestBody @Valid ProductStockOutDto productStockOutDto, @RequestHeader("authorization") String authorization) {
        return this.productStockOutService.create(authorization, productStockOutDto);
    }

    @PutMapping("/productStockOuts/{id}")
    public ProductStockOutDto updateProductStockOut(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody ProductStockOutDto productStockOutDto) {
        return this.productStockOutService.update(authorization, productStockOutDto, id);


    }

    @DeleteMapping("/productStockOuts/{id}")
    public void deleteProductStockOut(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.productStockOutService.delete(authorization, id);
    }
}

