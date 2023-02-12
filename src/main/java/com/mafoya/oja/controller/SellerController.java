package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.SellerDto;
import com.mafoya.oja.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping("/sellers/all")
    public List<SellerDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.sellerService.getAll(authorization);
    }

    @GetMapping("/sellers/{id}")
    public SellerDto getSellerById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.sellerService.getById(authorization, id);

    }

    @PostMapping("/sellers")
    public SellerDto createSeller(@RequestBody @Valid SellerDto sellerDto, @RequestHeader("authorization") String authorization) {
        return this.sellerService.create(authorization, sellerDto);
    }

    @PutMapping("/sellers/{id}")
    public SellerDto updateSeller(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody SellerDto sellerDto) {
        return this.sellerService.update(authorization, sellerDto, id);


    }

    @DeleteMapping("/sellers/{id}")
    public void deleteSeller(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.sellerService.delete(authorization, id);
    }
}

