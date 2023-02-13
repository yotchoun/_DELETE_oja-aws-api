package com.mafoya.oja.service;

import com.mafoya.oja.dto.TicketDto;

import java.util.List;
import java.util.Set;

public interface TicketService {
    TicketDto create(String authorization, TicketDto ticketDto);

    TicketDto update(String authorization, TicketDto ticketDto, String id);

    TicketDto getById(String authorization, String id);

    List<TicketDto> getAll(String authorization);

    void delete(String authorization, String id);

    Set<TicketDto> findByUserId(String authorization,String id);
}
