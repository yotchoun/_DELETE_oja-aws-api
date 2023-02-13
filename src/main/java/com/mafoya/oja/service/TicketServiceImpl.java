package com.mafoya.oja.service;

import com.mafoya.oja.dto.TicketDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Ticket;
import com.mafoya.oja.repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TicketServiceImpl  implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public TicketDto getById(String authorization, String id) {
        TicketDto ticketDto;
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if (ticketOptional.isPresent()) {
            ticketDto = OjaMapper.mapTicketDto(ticketOptional.get());
            return ticketDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public TicketDto create(String authorization, TicketDto ticketDto) {
        Ticket ticket = OjaMapper.mapTicketDo(ticketDto);
        ticketRepository.save(ticket);
        return ticketDto;
    }

    @Override
    public TicketDto update(String authorization, TicketDto ticketDto, String id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if (ticketOptional.isPresent()) {
            Ticket ticket = OjaMapper.mapTicketDo(ticketDto);
            ticket.setId(id);
            ticketRepository.save(ticket);
            return ticketDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<TicketDto> getAll(String authorization) {
        List<Ticket> doList = (List<Ticket>) ticketRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        ticketRepository.deleteById(id);
    }
}

