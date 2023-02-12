package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.RecentPurchaseDto;
import com.mafoya.oja.service.RecentPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class RecentPurchaseController {

    @Autowired
    private RecentPurchaseService recentPurchaseService;

    @GetMapping("/recentPurchases/all")
    public List<RecentPurchaseDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.recentPurchaseService.getAll(authorization);
    }

    @GetMapping("/recentPurchases/{id}")
    public RecentPurchaseDto getRecentPurchaseById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.recentPurchaseService.getById(authorization, id);

    }

    @PostMapping("/recentPurchases")
    public RecentPurchaseDto createRecentPurchase(@RequestBody @Valid RecentPurchaseDto recentPurchaseDto, @RequestHeader("authorization") String authorization) {
        return this.recentPurchaseService.create(authorization, recentPurchaseDto);
    }

    @PutMapping("/recentPurchases/{id}")
    public RecentPurchaseDto updateRecentPurchase(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody RecentPurchaseDto recentPurchaseDto) {
        return this.recentPurchaseService.update(authorization, recentPurchaseDto, id);


    }

    @DeleteMapping("/recentPurchases/{id}")
    public void deleteRecentPurchase(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.recentPurchaseService.delete(authorization, id);
    }
}

