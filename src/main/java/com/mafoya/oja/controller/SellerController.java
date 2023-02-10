package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.Seller;
import com.mafoya.oja.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping("/sellers/all")
    public List<Seller> findAll(@RequestHeader("authorization") String authorization) {
        return this.sellerService.getAll(authorization);
    }

    @GetMapping("/sellers/{id}")
    public Optional<Seller> getSellerById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.sellerService.getById(authorization, id);

    }

    @PostMapping("/sellers")
    public Seller createSeller(@RequestBody @Valid Seller sellerDto, @RequestHeader("authorization") String authorization) {
        return this.sellerService.create(authorization, sellerDto);
    }

    @PutMapping("/sellers/{id}")
    public Seller updateSeller(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody Seller seller) {
        return this.sellerService.update(authorization, seller, id);


    }

    @DeleteMapping("/sellers/{id}")
    public void deleteSeller(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.sellerService.delete(authorization, id);
    }
}

