package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.ShopServiceObject;
import com.mafoya.oja.service.ShopServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ShopController{

    @Autowired
    private ShopServiceService shopServiceService;

    @GetMapping("/shops/all")
    public List<ShopServiceObject> findAll(@RequestHeader("authorization") String authorization) {
        return this.shopServiceService.getAll(authorization);
    }

    @GetMapping("/shops/{id}")
    public Optional<ShopServiceObject> getShopById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.shopServiceService.getById(authorization, id);

    }

    @PostMapping("/shops")
    public ShopServiceObject createShop(@RequestBody @Valid ShopServiceObject shopDto, @RequestHeader("authorization") String authorization) {
        return this.shopServiceService.create(authorization, shopDto);
    }

    @PutMapping("/shops/{id}")
    public ShopServiceObject updateShop(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody ShopServiceObject shop) {
        return this.shopServiceService.update(authorization, shop, id);


    }

    @DeleteMapping("/shops/{id}")
    public void deleteShop(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.shopServiceService.delete(authorization, id);
    }
}

