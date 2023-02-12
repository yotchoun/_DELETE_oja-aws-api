package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.ColorDto;
import com.mafoya.oja.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ColorController{

    @Autowired
    private ColorService colorService;

    @GetMapping("/colors/all")
    public List<ColorDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.colorService.getAll(authorization);
    }

    @GetMapping("/colors/{id}")
    public ColorDto getColorById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.colorService.getById(authorization, id);

    }

    @PostMapping("/colors")
    public ColorDto createColor(@RequestBody @Valid ColorDto colorDto, @RequestHeader("authorization") String authorization) {
        return this.colorService.create(authorization, colorDto);
    }

    @PutMapping("/colors/{id}")
    public ColorDto updateColor(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody ColorDto colorDto) {
        return this.colorService.update(authorization, colorDto, id);


    }

    @DeleteMapping("/colors/{id}")
    public void deleteColor(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.colorService.delete(authorization, id);
    }
}

