package com.mafoya.oja.service;

import com.mafoya.oja.model.Ticket;
import com.mafoya.oja.repository.TicketRepository;

import java.util.List;
import java.util.Optional;

public class TicketServiceImpl  implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket create(String authorization, Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket update(String authorization, Ticket ticket, String id) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Optional<Ticket> getById(String authorization, String id) {
        return ticketRepository.findById(id);
    }

    @Override
    public List<Ticket> getAll(String authorization) {
        return (List<Ticket>) ticketRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        ticketRepository.deleteById(id);
    }
}

