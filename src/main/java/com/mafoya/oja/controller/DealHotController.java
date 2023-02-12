package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.DealHotDto;
import com.mafoya.oja.service.DealHotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class DealHotController {

    @Autowired
    private DealHotService dealHotService;

    @GetMapping("/dealHots/all")
    public List<DealHotDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.dealHotService.getAll(authorization);
    }

    @GetMapping("/dealHots/{id}")
    public DealHotDto getDealHotById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.dealHotService.getById(authorization, id);

    }

    @PostMapping("/dealHots")
    public DealHotDto createDealHot(@RequestBody @Valid DealHotDto dealHotDto, @RequestHeader("authorization") String authorization) {
        return this.dealHotService.create(authorization, dealHotDto);
    }

    @PutMapping("/dealHots/{id}")
    public DealHotDto updateDealHot(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody DealHotDto dealHotDto) {
        return this.dealHotService.update(authorization, dealHotDto, id);


    }

    @DeleteMapping("/dealHots/{id}")
    public void deleteDealHot(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.dealHotService.delete(authorization, id);
    }
}

