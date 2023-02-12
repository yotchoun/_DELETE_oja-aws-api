package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.ShopDto;
import com.mafoya.oja.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ShopController{

    @Autowired
    private ShopService shopService;

    @GetMapping("/shops/all")
    public List<ShopDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.shopService.getAll(authorization);
    }

    @GetMapping("/shops/{id}")
    public ShopDto getShopById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.shopService.getById(authorization, id);

    }

    @PostMapping("/shops")
    public ShopDto createShop(@RequestBody @Valid ShopDto shopDto, @RequestHeader("authorization") String authorization) {
        return this.shopService.create(authorization, shopDto);
    }

    @PutMapping("/shops/{id}")
    public ShopDto updateShop(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody ShopDto shop) {
        return this.shopService.update(authorization, shop, id);


    }

    @DeleteMapping("/shops/{id}")
    public void deleteShop(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.shopService.delete(authorization, id);
    }
}

