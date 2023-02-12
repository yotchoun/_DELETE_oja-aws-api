package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.PayoutDto;
import com.mafoya.oja.service.PayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class PayoutController {

    @Autowired
    private PayoutService payoutService;

    @GetMapping("/payouts/all")
    public List<PayoutDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.payoutService.getAll(authorization);
    }

    @GetMapping("/payouts/{id}")
    public PayoutDto getPayoutById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.payoutService.getById(authorization, id);

    }

    @PostMapping("/payouts")
    public PayoutDto createPayout(@RequestBody @Valid PayoutDto payoutDto, @RequestHeader("authorization") String authorization) {
        return this.payoutService.create(authorization, payoutDto);
    }

    @PutMapping("/payouts/{id}")
    public PayoutDto updatePayout(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody PayoutDto payoutDto) {
        return this.payoutService.update(authorization, payoutDto, id);


    }

    @DeleteMapping("/payouts/{id}")
    public void deletePayout(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.payoutService.delete(authorization, id);
    }
}

