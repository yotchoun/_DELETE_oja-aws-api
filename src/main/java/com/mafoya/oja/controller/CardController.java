package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.CardDto;
import com.mafoya.oja.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/cards/all")
    public List<CardDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.cardService.getAll(authorization);
    }

    @GetMapping("/cards/{id}")
    public CardDto getCardById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.cardService.getById(authorization, id);

    }

    @PostMapping("/cards")
    public CardDto createCard(@RequestBody @Valid CardDto cardDto, @RequestHeader("authorization") String authorization) {
        return this.cardService.create(authorization, cardDto);
    }

    @PutMapping("/cards/{id}")
    public CardDto updateCard(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody CardDto cardDto) {
        return this.cardService.update(authorization, cardDto, id);


    }

    @DeleteMapping("/cards/{id}")
    public void deleteCard(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.cardService.delete(authorization, id);
    }
}

