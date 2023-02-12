package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.DiscountCardDto;
import com.mafoya.oja.service.DiscountCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class DiscountCardController {

    @Autowired
    private DiscountCardService discountCardService;

    @GetMapping("/discountCards/all")
    public List<DiscountCardDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.discountCardService.getAll(authorization);
    }

    @GetMapping("/discountCards/{id}")
    public DiscountCardDto getDiscountCardById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.discountCardService.getById(authorization, id);

    }

    @PostMapping("/discountCards")
    public DiscountCardDto createDiscountCard(@RequestBody @Valid DiscountCardDto discountCardDto, @RequestHeader("authorization") String authorization) {
        return this.discountCardService.create(authorization, discountCardDto);
    }

    @PutMapping("/discountCards/{id}")
    public DiscountCardDto updateDiscountCard(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody DiscountCardDto discountCardDto) {
        return this.discountCardService.update(authorization, discountCardDto, id);


    }

    @DeleteMapping("/discountCards/{id}")
    public void deleteDiscountCard(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.discountCardService.delete(authorization, id);
    }
}

