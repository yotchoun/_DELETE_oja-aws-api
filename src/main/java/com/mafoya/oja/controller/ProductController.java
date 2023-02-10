package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.Product;
import com.mafoya.oja.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ProductController{

    @Autowired
    private ProductService productService;

    @GetMapping("/products/all")
    public List<Product> findAll(@RequestHeader("authorization") String authorization) {
        return this.productService.getAll(authorization);
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.productService.getById(authorization, id);

    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody @Valid Product productDto, @RequestHeader("authorization") String authorization) {
        return this.productService.create(authorization, productDto);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody Product product) {
        return this.productService.update(authorization, product, id);


    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.productService.delete(authorization, id);
    }
}

