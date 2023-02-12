package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.EarningDto;
import com.mafoya.oja.service.EarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class EarningController {

    @Autowired
    private EarningService earningService;

    @GetMapping("/earnings/all")
    public List<EarningDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.earningService.getAll(authorization);
    }

    @GetMapping("/earnings/{id}")
    public EarningDto getEarningById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.earningService.getById(authorization, id);

    }

    @PostMapping("/earnings")
    public EarningDto createEarning(@RequestBody @Valid EarningDto earningDto, @RequestHeader("authorization") String authorization) {
        return this.earningService.create(authorization, earningDto);
    }

    @PutMapping("/earnings/{id}")
    public EarningDto updateEarning(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody EarningDto earningDto) {
        return this.earningService.update(authorization, earningDto, id);


    }

    @DeleteMapping("/earnings/{id}")
    public void deleteEarning(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.earningService.delete(authorization, id);
    }
}

