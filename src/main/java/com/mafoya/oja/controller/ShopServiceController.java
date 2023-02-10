package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.ShopService;
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
public class ShopServiceController {

    @Autowired
    private ShopServiceService shopServiceService;

    @GetMapping("/shopServices/all")
    public List<ShopService> findAll(@RequestHeader("authorization") String authorization) {
        return this.shopServiceService.getAll(authorization);
    }

    @GetMapping("/shopServices/{id}")
    public Optional<ShopService> getShopServiceById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.shopServiceService.getById(authorization, id);

    }

    @PostMapping("/shopServices")
    public ShopService createShopService(@RequestBody @Valid ShopService shopServiceDto, @RequestHeader("authorization") String authorization) {
        return this.shopServiceService.create(authorization, shopServiceDto);
    }

    @PutMapping("/shopServices/{id}")
    public ShopService updateShopService(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody ShopService shopService) {
        return this.shopServiceService.update(authorization, shopService, id);


    }

    @DeleteMapping("/shopServices/{id}")
    public void deleteShopService(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.shopServiceService.delete(authorization, id);
    }
}

