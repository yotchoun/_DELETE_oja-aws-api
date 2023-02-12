package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.TicketDto;
import com.mafoya.oja.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets/all")
    public List<TicketDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.ticketService.getAll(authorization);
    }

    @GetMapping("/tickets/{id}")
    public TicketDto getTicketById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.ticketService.getById(authorization, id);

    }

    @PostMapping("/tickets")
    public TicketDto createTicket(@RequestBody @Valid TicketDto ticketDto, @RequestHeader("authorization") String authorization) {
        return this.ticketService.create(authorization, ticketDto);
    }

    @PutMapping("/tickets/{id}")
    public TicketDto updateTicket(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody TicketDto ticketDto) {
        return this.ticketService.update(authorization, ticketDto, id);


    }

    @DeleteMapping("/tickets/{id}")
    public void deleteTicket(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.ticketService.delete(authorization, id);
    }
}

