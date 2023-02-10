package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.RecentPurchase;
import com.mafoya.oja.service.RecentPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class RecentPurchaseController {

    @Autowired
    private RecentPurchaseService recentPurchaseService;

    @GetMapping("/recentPurchases/all")
    public List<RecentPurchase> findAll(@RequestHeader("authorization") String authorization) {
        return this.recentPurchaseService.getAll(authorization);
    }

    @GetMapping("/recentPurchases/{id}")
    public Optional<RecentPurchase> getRecentPurchaseById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.recentPurchaseService.getById(authorization, id);

    }

    @PostMapping("/recentPurchases")
    public RecentPurchase createRecentPurchase(@RequestBody @Valid RecentPurchase recentPurchaseDto, @RequestHeader("authorization") String authorization) {
        return this.recentPurchaseService.create(authorization, recentPurchaseDto);
    }

    @PutMapping("/recentPurchases/{id}")
    public RecentPurchase updateRecentPurchase(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody RecentPurchase recentPurchase) {
        return this.recentPurchaseService.update(authorization, recentPurchase, id);


    }

    @DeleteMapping("/recentPurchases/{id}")
    public void deleteRecentPurchase(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.recentPurchaseService.delete(authorization, id);
    }
}

