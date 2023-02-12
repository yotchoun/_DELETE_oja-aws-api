package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.ForDto;
import com.mafoya.oja.service.ForService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ForController{

    @Autowired
    private ForService forSerService;

    @GetMapping("/for/all")
    public List<ForDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.forSerService.getAll(authorization);
    }

    @GetMapping("/for/{id}")
    public ForDto getForById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.forSerService.getById(authorization, id);

    }

    @PostMapping("/for")
    public ForDto createFor(@RequestBody @Valid ForDto forSerDto, @RequestHeader("authorization") String authorization) {
        return this.forSerService.create(authorization, forSerDto);
    }

    @PutMapping("/for/{id}")
    public ForDto updateFor(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody ForDto forSer) {
        return this.forSerService.update(authorization, forSer, id);


    }

    @DeleteMapping("/for/{id}")
    public void deleteFor(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.forSerService.delete(authorization, id);
    }
}

