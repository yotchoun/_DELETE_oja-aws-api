package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.DealOfTheWeek;
import com.mafoya.oja.service.DealOfTheWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class DealOfTheWeekController {

    @Autowired
    private DealOfTheWeekService dealOfTheWeekService;

    @GetMapping("/dealOfTheWeeks/all")
    public List<DealOfTheWeek> findAll(@RequestHeader("authorization") String authorization) {
        return this.dealOfTheWeekService.getAll(authorization);
    }

    @GetMapping("/dealOfTheWeeks/{id}")
    public Optional<DealOfTheWeek> getDealOfTheWeekById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.dealOfTheWeekService.getById(authorization, id);

    }

    @PostMapping("/dealOfTheWeeks")
    public DealOfTheWeek createDealOfTheWeek(@RequestBody @Valid DealOfTheWeek dealOfTheWeekDto, @RequestHeader("authorization") String authorization) {
        return this.dealOfTheWeekService.create(authorization, dealOfTheWeekDto);
    }

    @PutMapping("/dealOfTheWeeks/{id}")
    public DealOfTheWeek updateDealOfTheWeek(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody DealOfTheWeek dealOfTheWeek) {
        return this.dealOfTheWeekService.update(authorization, dealOfTheWeek, id);


    }

    @DeleteMapping("/dealOfTheWeeks/{id}")
    public void deleteDealOfTheWeek(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.dealOfTheWeekService.delete(authorization, id);
    }
}

