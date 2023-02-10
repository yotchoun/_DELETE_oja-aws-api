package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.PayoutRequest;
import com.mafoya.oja.service.PayoutRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class PayoutRequestController {

    @Autowired
    private PayoutRequestService payoutRequestService;

    @GetMapping("/payoutRequests/all")
    public List<PayoutRequest> findAll(@RequestHeader("authorization") String authorization) {
        return this.payoutRequestService.getAll(authorization);
    }

    @GetMapping("/payoutRequests/{id}")
    public Optional<PayoutRequest> getPayoutRequestById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.payoutRequestService.getById(authorization, id);

    }

    @PostMapping("/payoutRequests")
    public PayoutRequest createPayoutRequest(@RequestBody @Valid PayoutRequest payoutRequestDto, @RequestHeader("authorization") String authorization) {
        return this.payoutRequestService.create(authorization, payoutRequestDto);
    }

    @PutMapping("/payoutRequests/{id}")
    public PayoutRequest updatePayoutRequest(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody PayoutRequest payoutRequest) {
        return this.payoutRequestService.update(authorization, payoutRequest, id);


    }

    @DeleteMapping("/payoutRequests/{id}")
    public void deletePayoutRequest(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.payoutRequestService.delete(authorization, id);
    }
}
