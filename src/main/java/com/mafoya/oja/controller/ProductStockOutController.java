package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.ProductStockOut;
import com.mafoya.oja.service.ProductStockOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ProductStockOutController {

    @Autowired
    private ProductStockOutService productStockOutService;

    @GetMapping("/productStockOuts/all")
    public List<ProductStockOut> findAll(@RequestHeader("authorization") String authorization) {
        return this.productStockOutService.getAll(authorization);
    }

    @GetMapping("/productStockOuts/{id}")
    public Optional<ProductStockOut> getProductStockOutById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.productStockOutService.getById(authorization, id);

    }

    @PostMapping("/productStockOuts")
    public ProductStockOut createProductStockOut(@RequestBody @Valid ProductStockOut productStockOutDto, @RequestHeader("authorization") String authorization) {
        return this.productStockOutService.create(authorization, productStockOutDto);
    }

    @PutMapping("/productStockOuts/{id}")
    public ProductStockOut updateProductStockOut(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody ProductStockOut productStockOut) {
        return this.productStockOutService.update(authorization, productStockOut, id);


    }

    @DeleteMapping("/productStockOuts/{id}")
    public void deleteProductStockOut(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.productStockOutService.delete(authorization, id);
    }
}

