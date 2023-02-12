package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.PaymentPackageDto;
import com.mafoya.oja.service.PaymentPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class PaymentPackageController {

    @Autowired
    private PaymentPackageService paymentPackageService;

    @GetMapping("/paymentPackages/all")
    public List<PaymentPackageDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.paymentPackageService.getAll(authorization);
    }

    @GetMapping("/paymentPackages/{id}")
    public PaymentPackageDto getPaymentPackageById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.paymentPackageService.getById(authorization, id);

    }

    @PostMapping("/paymentPackages")
    public PaymentPackageDto createPaymentPackage(@RequestBody @Valid PaymentPackageDto paymentPackageDto, @RequestHeader("authorization") String authorization) {
        return this.paymentPackageService.create(authorization, paymentPackageDto);
    }

    @PutMapping("/paymentPackages/{id}")
    public PaymentPackageDto updatePaymentPackage(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody PaymentPackageDto paymentPackageDto) {
        return this.paymentPackageService.update(authorization, paymentPackageDto, id);


    }

    @DeleteMapping("/paymentPackages/{id}")
    public void deletePaymentPackage(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.paymentPackageService.delete(authorization, id);
    }
}

