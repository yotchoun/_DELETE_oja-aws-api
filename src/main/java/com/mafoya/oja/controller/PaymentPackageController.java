package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.PaymentPackage;
import com.mafoya.oja.service.PaymentPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class PaymentPackageController {

    @Autowired
    private PaymentPackageService paymentPackageService;

    @GetMapping("/paymentPackages/all")
    public List<PaymentPackage> findAll(@RequestHeader("authorization") String authorization) {
        return this.paymentPackageService.getAll(authorization);
    }

    @GetMapping("/paymentPackages/{id}")
    public Optional<PaymentPackage> getPaymentPackageById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.paymentPackageService.getById(authorization, id);

    }

    @PostMapping("/paymentPackages")
    public PaymentPackage createPaymentPackage(@RequestBody @Valid PaymentPackage paymentPackageDto, @RequestHeader("authorization") String authorization) {
        return this.paymentPackageService.create(authorization, paymentPackageDto);
    }

    @PutMapping("/paymentPackages/{id}")
    public PaymentPackage updatePaymentPackage(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody PaymentPackage paymentPackage) {
        return this.paymentPackageService.update(authorization, paymentPackage, id);


    }

    @DeleteMapping("/paymentPackages/{id}")
    public void deletePaymentPackage(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.paymentPackageService.delete(authorization, id);
    }
}

