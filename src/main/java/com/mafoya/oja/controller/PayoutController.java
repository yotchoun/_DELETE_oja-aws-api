package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.Payout;
import com.mafoya.oja.service.PayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class PayoutController {

    @Autowired
    private PayoutService payoutService;

    @GetMapping("/payouts/all")
    public List<Payout> findAll(@RequestHeader("authorization") String authorization) {
        return this.payoutService.getAll(authorization);
    }

    @GetMapping("/payouts/{id}")
    public Optional<Payout> getPayoutById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.payoutService.getById(authorization, id);

    }

    @PostMapping("/payouts")
    public Payout createPayout(@RequestBody @Valid Payout payoutDto, @RequestHeader("authorization") String authorization) {
        return this.payoutService.create(authorization, payoutDto);
    }

    @PutMapping("/payouts/{id}")
    public Payout updatePayout(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody Payout payout) {
        return this.payoutService.update(authorization, payout, id);


    }

    @DeleteMapping("/payouts/{id}")
    public void deletePayout(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.payoutService.delete(authorization, id);
    }
}

