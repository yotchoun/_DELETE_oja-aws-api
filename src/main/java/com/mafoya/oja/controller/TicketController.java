package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.Ticket;
import com.mafoya.oja.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets/all")
    public List<Ticket> findAll(@RequestHeader("authorization") String authorization) {
        return this.ticketService.getAll(authorization);
    }

    @GetMapping("/tickets/{id}")
    public Optional<Ticket> getTicketById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.ticketService.getById(authorization, id);

    }

    @PostMapping("/tickets")
    public Ticket createTicket(@RequestBody @Valid Ticket ticketDto, @RequestHeader("authorization") String authorization) {
        return this.ticketService.create(authorization, ticketDto);
    }

    @PutMapping("/tickets/{id}")
    public Ticket updateTicket(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody Ticket ticket) {
        return this.ticketService.update(authorization, ticket, id);


    }

    @DeleteMapping("/tickets/{id}")
    public void deleteTicket(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.ticketService.delete(authorization, id);
    }
}

