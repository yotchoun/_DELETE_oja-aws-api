package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.For;
import com.mafoya.oja.service.ForService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ForController{

    @Autowired
    private ForService forSerService;

    @GetMapping("/forSers/all")
    public List<For> findAll(@RequestHeader("authorization") String authorization) {
        return this.forSerService.getAll(authorization);
    }

    @GetMapping("/forSers/{id}")
    public Optional<For> getForById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.forSerService.getById(authorization, id);

    }

    @PostMapping("/forSers")
    public For createFor(@RequestBody @Valid For forSerDto, @RequestHeader("authorization") String authorization) {
        return this.forSerService.create(authorization, forSerDto);
    }

    @PutMapping("/forSers/{id}")
    public For updateFor(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody For forSer) {
        return this.forSerService.update(authorization, forSer, id);


    }

    @DeleteMapping("/forSers/{id}")
    public void deleteFor(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.forSerService.delete(authorization, id);
    }
}

