package com.mafoya.oja.service;

import com.mafoya.oja.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    Ticket create(String authorization, Ticket ticket);

    Ticket update(String authorization, Ticket ticket, String id);

    Optional<Ticket> getById(String authorization, String id);

    List<Ticket> getAll(String authorization);

    void delete(String authorization, String id);
}
