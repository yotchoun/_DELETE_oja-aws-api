package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.Visitor;
import com.mafoya.oja.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @GetMapping("/visitors/all")
    public List<Visitor> findAll(@RequestHeader("authorization") String authorization) {
        return this.visitorService.getAll(authorization);
    }

    @GetMapping("/visitors/{id}")
    public Optional<Visitor> getVisitorById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.visitorService.getById(authorization, id);

    }

    @PostMapping("/visitors")
    public Visitor createVisitor(@RequestBody @Valid Visitor visitorDto, @RequestHeader("authorization") String authorization) {
        return this.visitorService.create(authorization, visitorDto);
    }

    @PutMapping("/visitors/{id}")
    public Visitor updateVisitor(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody Visitor visitor) {
        return this.visitorService.update(authorization, visitor, id);


    }

    @DeleteMapping("/visitors/{id}")
    public void deleteVisitor(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.visitorService.delete(authorization, id);
    }
}

