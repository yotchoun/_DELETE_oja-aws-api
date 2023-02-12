package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.RefundRequestDto;
import com.mafoya.oja.service.RefundRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class RefundRequestController {

    @Autowired
    private RefundRequestService refundRequestService;

    @GetMapping("/refundRequests/all")
    public List<RefundRequestDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.refundRequestService.getAll(authorization);
    }

    @GetMapping("/refundRequests/{id}")
    public RefundRequestDto getRefundRequestById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.refundRequestService.getById(authorization, id);

    }

    @PostMapping("/refundRequests")
    public RefundRequestDto createRefundRequest(@RequestBody @Valid RefundRequestDto refundRequestDto, @RequestHeader("authorization") String authorization) {
        return this.refundRequestService.create(authorization, refundRequestDto);
    }

    @PutMapping("/refundRequests/{id}")
    public RefundRequestDto updateRefundRequest(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody RefundRequestDto refundRequestDto) {
        return this.refundRequestService.update(authorization, refundRequestDto, id);


    }

    @DeleteMapping("/refundRequests/{id}")
    public void deleteRefundRequest(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.refundRequestService.delete(authorization, id);
    }
}
